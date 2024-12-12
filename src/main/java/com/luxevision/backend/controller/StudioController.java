package com.luxevision.backend.controller;
import com.luxevision.backend.dto.*;
import com.luxevision.backend.entity.*;
import com.luxevision.backend.exception.*;
import com.luxevision.backend.repository.StudioRepository;
import com.luxevision.backend.service.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/studios")
public class StudioController {

    @Autowired
    private StudioService studioService;

    @Autowired
    private LocationService locationService;

    @Autowired
    private PhotographerService photographerService;

    @Autowired
    private PortfolioPhotoService portfolioPhotoService;

    @Autowired
    private StudioSpecialtyService studioSpecialtyService;

    @Autowired
    private S3Service s3Service;

    @Autowired
    private StudioFeatureService studioFeatureService;

    @Autowired
    private SpecialtyService specialtyService;

    @Autowired
    private FeatureService featureService;

    @Autowired
    private StudioRepository studioRepository;

    @GetMapping
    public List<Studio> getAllStudios() {
        return studioService.getAllStudios();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudio(@PathVariable Integer id) {

        Studio studioFromDB = studioService.findStudioById(id).orElseThrow(
                () -> new ObjectNotFoundException("Studio with id " + id + " not found")
        );

        try {
            s3Service.deleteObject(null, studioFromDB);
            studioService.deleteStudioById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/random")
    public List<Studio> getRandomStudios() {
        return studioService.getRandomStudios();
    }

    @PostMapping
    public ResponseEntity<?> saveStudio (@RequestPart("studio") @Valid SaveStudio studio,
                                         @RequestPart("profileImage")MultipartFile profileImage,
                                         @RequestPart("portfolioImages") List<MultipartFile> portfolioImages)
            throws StudioNameAlreadyRegisteredException {

        if(studioService.existsStudioByStudioName(studio.getStudioName()) ) {
            throw new StudioNameAlreadyRegisteredException();
        }

        for (Integer specialtyId : studio.getSpecialties()) {

            specialtyService.findSpecialtyById(specialtyId).orElseThrow(
                    () -> new ObjectNotFoundException("Specialty with id: " + specialtyId + " not found")
            );
        }

        for (Long featureId : studio.getFeatures()) {

            featureService.findFeatureById(featureId).orElseThrow(
                    () -> new ObjectNotFoundException("Feature with id: " + featureId + " not found")
            );

        }

        Location location = locationService.saveLocation(studio.getLocation());

        Studio StudioToSave = new Studio();

        StudioToSave.setStudioName(studio.getStudioName());
        StudioToSave.setEmail(studio.getEmail());
        StudioToSave.setPhone(studio.getPhone());
        StudioToSave.setDescription(studio.getDescription());
        StudioToSave.setSignup(LocalDateTime.now());
        StudioToSave.setYearsOfExperience(studio.getYearsOfExperience());
        StudioToSave.setLocation(location);
        StudioToSave.setPhotographers(studio.getPhotographers());

        Studio studioSaved = studioService.saveStudio(StudioToSave);

        for (Photographer photographer : studio.getPhotographers()) {
            photographer.setStudio(studioSaved);
            photographerService.savePhotographer(photographer);
        }

        List<StudioSpecialty> studioSpecialties = new ArrayList<>();
        for (Integer specialtyId : studio.getSpecialties()) {
            StudioSpecialty studioSpecialty = new StudioSpecialty();
            studioSpecialty.setStudio(studioSaved);

            Specialty specialtyFromDB = specialtyService.findSpecialtyById(specialtyId).orElseThrow(
                    () -> new ObjectNotFoundException("Specialty not found")
            );
            studioSpecialty.setSpecialty(specialtyFromDB);

            studioSpecialties.add(studioSpecialtyService.saveStudioSpecialty(studioSpecialty));
        }

        List<StudioFeature> studioFeatures = new ArrayList<>();
        for (Long featureId : studio.getFeatures()) {
            StudioFeature studioFeature = new StudioFeature();
            studioFeature.setStudio(studioSaved);

            Feature featureFromDB = featureService.findFeatureById(featureId).orElseThrow(
                    () -> new ObjectNotFoundException("Feature not found")
            );
            studioFeature.setFeature(featureFromDB);
            studioFeatures.add(studioFeatureService.saveStudioFeature(studioFeature));
        }

        studioSaved.setStudioSpecialties(studioSpecialties);
        studioSaved.setStudioFeatures(studioFeatures);

        try {
            String profilePhotoUrl = s3Service.uploadProfileImage(profileImage, studio.getStudioName());
            studioSaved.setProfileImage(profilePhotoUrl);

            List<PortfolioPhoto> portfolioPhotos = new ArrayList<>();

            int index = 1;
            for (MultipartFile portfolioImage : portfolioImages) {
                PortfolioPhoto portfolioPhoto = new PortfolioPhoto();
                String photoUrl = s3Service.uploadPortfolioPhoto(portfolioImage, studio.getStudioName(), index);
                portfolioPhoto.setImage(photoUrl);
                portfolioPhoto.setStudio(studioSaved);
                portfolioPhotos.add(portfolioPhotoService.savePortfolioPhoto(portfolioPhoto));
                index++;
            }

            studioSaved.setLastUpdate(LocalDateTime.now());
            studioSaved.setPortfolioPhotos(portfolioPhotos);

        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(studioRepository.save(studioSaved));


    }

    @GetMapping("/{id}")
    public ResponseEntity<Studio> findStudioById (@PathVariable Integer id) {

        Studio studioFromDB = studioService.findStudioById(id).orElseThrow(
                () -> new ObjectNotFoundException("Studio with id " + id + " not found")
        );

        return ResponseEntity.status(HttpStatus.OK).body(studioFromDB);
    }


    @PutMapping
    public ResponseEntity<?> updateStudio(
            @RequestPart("studio") @Valid UpdateStudio studio,
            @RequestPart(value = "profileImage", required = false) MultipartFile profileImage,
            @RequestPart(value = "portfolioImages", required = false) List<MultipartFile> portfolioImages,
            @RequestPart(value = "studioImagesURL", required = false) @Valid UpdateStudioImages updateStudioImages)
            throws StudioNameAlreadyRegisteredException{

       try {
           Studio updateStudio = studioService.updateStudio(studio, profileImage, portfolioImages, updateStudioImages);
           return ResponseEntity.ok(updateStudio);
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
    }


    @GetMapping("/{id}/working-hours")
    public ResponseEntity<WorkSchedules> findStudioWork(@PathVariable Integer id) {

        return ResponseEntity.ok(studioService.findStudioWorkHours(id));

    }

    @GetMapping("/available")
    public ResponseEntity<List<Studio>> findAvailableStudios(@RequestParam("specialtyID") Integer specialtyID,
                                                  @RequestParam("date") LocalDate date,
                                                  @RequestParam("startTime") LocalTime startTime,
                                                  @RequestParam("endTime") LocalTime endTime) {

       return ResponseEntity.ok(studioService.findAvailableStudios(specialtyID, date, startTime, endTime));

    }

    @GetMapping("/{id}/prices")
    public ResponseEntity<List<StudioPriceResponse>> findStudioPriceByStudioID (@PathVariable Integer id) {

        return ResponseEntity.ok(studioService.findStudioPriceByStudioID(id));

    }

    @GetMapping("/{id}/occupied-schedules")
    public ResponseEntity<List<StudioBookingSchedule>> findAllOccupiedSchedulesByStudioFromCurrentDate (@PathVariable Integer id) {

        return ResponseEntity.ok(studioService.findAllOccupiedSchedulesByStudioIDFromCurrentDate(id));

    }


}