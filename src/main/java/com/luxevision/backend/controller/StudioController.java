package com.luxevision.backend.controller;
import com.luxevision.backend.entity.*;
import com.luxevision.backend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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


    @GetMapping("/random")
    public List<Studio> getRandomStudios() {
        return studioService.getRandomStudios();
    }

    @PostMapping
    public ResponseEntity<?> saveStudio (@RequestPart("studio") Studio studio,
                                         @RequestPart("profileImage")MultipartFile profileImage,
                                         @RequestPart("portfolioImages") List<MultipartFile> portfolioImages) {

        Location location = new Location();
        location.setCity(studio.getLocation().getCity());
        location.setState(studio.getLocation().getState());
        location.setCountry(studio.getLocation().getCountry());
        location.setAddress(studio.getLocation().getAddress());
        Location locationSaved = locationService.saveLocation(location);

        Studio studioToSave = studio;
        studioToSave.setLocation(locationSaved);

        Studio studioSaved = studioService.saveStudio(studioToSave);

        for (Photographer photographer : studio.getPhotographers()) {
            photographer.setStudio(studioSaved);
            photographerService.savePhotographer(photographer);
        }

        for (StudioSpecialty studioSpecialty : studio.getStudioSpecialties()) {
            studioSpecialty.setStudio(studioSaved);
            studioSpecialtyService.saveStudioSpecialty(studioSpecialty);
        }

        try {
            String profilePhotoUrl = s3Service.uploadFile(profileImage);
            studioSaved.setProfileImage(profilePhotoUrl);

            List<PortfolioPhoto> portfolioPhotos = new ArrayList<>();

            for (MultipartFile portfolioImage : portfolioImages) {
                PortfolioPhoto portfolioPhoto = new PortfolioPhoto();
                String photoUrl = s3Service.uploadFile(portfolioImage);
                portfolioPhoto.setImage(photoUrl);
                portfolioPhoto.setStudio(studioSaved);
                portfolioPhotos.add(portfolioPhotoService.savePortfolioPhoto(portfolioPhoto));
            }

            studioSaved.setPortfolioPhotos(portfolioPhotos);
            studioService.updateStudio(studioSaved);

        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(studioSaved);

    }

}