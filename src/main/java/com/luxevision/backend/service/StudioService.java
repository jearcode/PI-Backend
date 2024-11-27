package com.luxevision.backend.service;
import com.luxevision.backend.dto.UpdateStudio;
import com.luxevision.backend.dto.UpdateStudioImages;
import com.luxevision.backend.entity.*;
import com.luxevision.backend.exception.MinimumImagesRequirementException;
import com.luxevision.backend.exception.ObjectNotFoundException;
import com.luxevision.backend.exception.StudioNameAlreadyRegisteredException;
import com.luxevision.backend.repository.PhotographerRepository;
import com.luxevision.backend.repository.StudioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudioService {

    @Autowired
    private PhotographerRepository photographerRepository;

    @Autowired
    private StudioRepository studioRepository;

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

    public List<Studio> getRandomStudios() {
        return studioRepository.findRandomStudios(PageRequest.of(0, 12));
    }

    public List<Studio> getAllStudios() {
        return studioRepository.findAll();
    }
    @Transactional
    public void deleteStudioById(Integer id) {
        if (!studioRepository.existsById(id)) {
            throw new EntityNotFoundException("El Studio con " + id + " no fue encontrado.");
        }
        photographerRepository.deleteByStudioId(id);
        studioRepository.deleteById(id);
    }

    public Studio saveStudio (Studio studio) {
        return studioRepository.save(studio);
    }

    public Optional<Studio> findStudioById (Integer id) {
        return studioRepository.findById(id);
    }

    public Studio updateStudio(UpdateStudio studio, MultipartFile profileImage, List<MultipartFile> portfolioImages, UpdateStudioImages updateStudioImages)
            throws StudioNameAlreadyRegisteredException, IOException {

        Studio studioFromDB = studioRepository.findById(studio.getId()).orElseThrow(
                () -> new ObjectNotFoundException("Studio not found")
        );

        validateTotalImages(portfolioImages, updateStudioImages);
        validateStudioNameChanged(studioFromDB, studio);

        boolean nameChanged = !studioFromDB.getStudioName().equals(studio.getStudioName());
        String oldStudioName = studioFromDB.getStudioName();


        for (Integer specialtyId : studio.getSpecialties()) {
            specialtyService.findSpecialtyById(specialtyId).orElseThrow(
                    () -> new ObjectNotFoundException("Specialty not found")
            );
        }

        for (Long featureId : studio.getFeatures()) {
            featureService.findFeatureById(featureId).orElseThrow(
                    () -> new ObjectNotFoundException("Feature not found")
            );
        }

        Location savedLocation = updateStudioLocation(studioFromDB, studio);;

        Studio studioSaved = mapStudioData(studioFromDB, studio, savedLocation);;

        handlePhotographers(studioSaved, studio);
        handleSpecialties(studioSaved, studio);
        handleFeatures(studioSaved, studio);

        handleImageUpload(studioSaved, profileImage, portfolioImages, updateStudioImages, studioFromDB, nameChanged, oldStudioName);

        studioSaved.setLastUpdate(LocalDateTime.now());
        return studioRepository.save(studioSaved);

    }

    private void handleImageUpload(Studio studioSaved, MultipartFile profileImage, List<MultipartFile> portfolioImages, UpdateStudioImages updateStudioImages, Studio studioFromDB, Boolean nameChanged, String oldStudioName) throws IOException {

        try {
            boolean hasProfileImageMultipart = profileImage != null && !profileImage.isEmpty();
            boolean hasPortfolioImagesMultipart = portfolioImages != null && !portfolioImages.isEmpty();
            boolean hasUpdateStudioImages = updateStudioImages != null && updateStudioImages.getPortfolioPhotos() != null;

            if (hasProfileImageMultipart) {
                String profilePhotoUrl = s3Service.uploadProfileImage(profileImage, studioSaved.getStudioName());
                studioSaved.setProfileImage(profilePhotoUrl);
            } else {
                studioSaved.setProfileImage(studioFromDB.getProfileImage());
            }

            List<PortfolioPhoto> portfolioPhotos = new ArrayList<>();
            if (hasPortfolioImagesMultipart || hasUpdateStudioImages) {

                int index = 1;
                List<PortfolioPhoto> existingPortfolioPhotos = new ArrayList<>();


                for (PortfolioPhoto portfolioPhoto : studioFromDB.getPortfolioPhotos()) {
                    existingPortfolioPhotos.add(portfolioPhoto);
                }


                if (hasUpdateStudioImages) {
                    for (String photoUrl : updateStudioImages.getPortfolioPhotos()) {
                        System.out.println("Processing: " + photoUrl);
                        PortfolioPhoto portfolioPhoto = existingPortfolioPhotos.get(index - 1); // Obtener la entidad existente
                        photoUrl = s3Service.uploadPortfolioPhotoFromUrl(photoUrl, studioSaved.getStudioName(), index);
                        portfolioPhoto.setImage(photoUrl);
                        portfolioPhoto.setStudio(studioSaved);
                        portfolioPhotos.add(portfolioPhotoService.savePortfolioPhoto(portfolioPhoto));
                        index++;
                    }
                }

                if (hasPortfolioImagesMultipart) {
                    for (MultipartFile portfolioImage : portfolioImages) {
                        PortfolioPhoto portfolioPhoto = existingPortfolioPhotos.get(index - 1); // Obtener la entidad existente
                        String photoUrl = s3Service.uploadPortfolioPhoto(portfolioImage, studioSaved.getStudioName(), index);
                        portfolioPhoto.setImage(photoUrl);
                        portfolioPhoto.setStudio(studioSaved);
                        portfolioPhotos.add(portfolioPhotoService.savePortfolioPhoto(portfolioPhoto));
                        index++;
                    }
                }

            } else {
                portfolioPhotos = studioFromDB.getPortfolioPhotos();
            }

            if ( nameChanged && (hasProfileImageMultipart || hasPortfolioImagesMultipart || hasUpdateStudioImages) ) {

                if (hasProfileImageMultipart) {
                    String newProfileImageUrl = studioSaved.getProfileImage().replace(
                            "/"+removeSpacesFromString(oldStudioName)+"/",
                            "/"+removeSpacesFromString(studioSaved.getStudioName())+"/"
                    );
                    studioSaved.setProfileImage(newProfileImageUrl);
                }

                // Update portfolio images URLs
                List<PortfolioPhoto> updatedPortfolioPhotos = new ArrayList<>();
                for (PortfolioPhoto photo : studioSaved.getPortfolioPhotos()) {
                    String newPortfolioImageUrl = photo.getImage().replace(
                            "/"+removeSpacesFromString(oldStudioName)+"/",
                            "/"+removeSpacesFromString(studioSaved.getStudioName())+"/"
                    );

                    photo.setImage(newPortfolioImageUrl);
                    updatedPortfolioPhotos.add(photo);
                }
                studioSaved.setPortfolioPhotos(updatedPortfolioPhotos);


                if (hasProfileImageMultipart && hasPortfolioImagesMultipart ) {
                    s3Service.copySpecificObject(oldStudioName, studioSaved.getStudioName());
                }

            }

            if ( nameChanged && (portfolioImages == null || updateStudioImages == null ) ) {

                s3Service.updateStudioPortfolioImages(oldStudioName, studioSaved.getStudioName());

                if (hasProfileImageMultipart) {
                    String newProfileImageUrl = studioSaved.getProfileImage().replace(
                            "/"+removeSpacesFromString(oldStudioName)+"/",
                            "/"+removeSpacesFromString(studioSaved.getStudioName())+"/"
                    );
                    studioSaved.setProfileImage(newProfileImageUrl);
                }

                List<PortfolioPhoto> updatedPortfolioPhotos = new ArrayList<>();
                for (PortfolioPhoto photo : studioSaved.getPortfolioPhotos()) {

                    String newPortfolioImageUrl = photo.getImage().replace(
                            "/"+removeSpacesFromString(oldStudioName)+"/",
                            "/"+removeSpacesFromString(studioSaved.getStudioName())+"/"
                    );
                    photo.setImage(newPortfolioImageUrl);
                    updatedPortfolioPhotos.add(photo);
                }
                studioSaved.setPortfolioPhotos(updatedPortfolioPhotos);

            }

            if (nameChanged && profileImage == null) {
                s3Service.updateStudioProfileImage(oldStudioName, studioSaved.getStudioName());
                String newProfileImageUrl = studioSaved.getProfileImage().replace(
                        "/"+removeSpacesFromString(oldStudioName)+"/",
                        "/"+removeSpacesFromString(studioSaved.getStudioName())+"/"
                );
                studioSaved.setProfileImage(newProfileImageUrl);
            }

            if ( nameChanged && (hasProfileImageMultipart || hasPortfolioImagesMultipart || hasUpdateStudioImages) ) {
                s3Service.deleteObject(oldStudioName);
            }

            studioSaved.setPortfolioPhotos(portfolioPhotos);

        } catch (IOException e) {
            throw new IOException(e.getLocalizedMessage());
        }

    }


    private Studio mapStudioData(Studio studioFromDB, UpdateStudio studio, Location savedLocation) {


        Studio studioToSave = new Studio();

        studioToSave.setId(studio.getId());
        studioToSave.setStudioName(studio.getStudioName());
        studioToSave.setEmail(studio.getEmail());
        studioToSave.setPhone(studio.getPhone());
        studioToSave.setDescription(studio.getDescription());
        studioToSave.setSignup(studioFromDB.getSignup());
        studioToSave.setYearsOfExperience(studio.getYearsOfExperience());
        studioToSave.setLocation(savedLocation);
        studioToSave.setPhotographers(studio.getPhotographers());
        studioToSave.setPortfolioPhotos(studioFromDB.getPortfolioPhotos());
        studioToSave.setProfileImage(studioFromDB.getProfileImage());
        studioToSave.setStudioSpecialties(studioFromDB.getStudioSpecialties());
        studioToSave.setStudioFeatures(studioFromDB.getStudioFeatures());

        return studioRepository.save(studioToSave);

    }


    private void validateTotalImages (List<MultipartFile> portfolioImages, UpdateStudioImages updateStudioImages)
            throws MinimumImagesRequirementException {

        // Validar el número total de imágenes
        int totalImages = 0;
        if (portfolioImages != null) {
            totalImages += portfolioImages.size();
        }
        if (updateStudioImages != null && updateStudioImages.getPortfolioPhotos() != null) {
            totalImages += updateStudioImages.getPortfolioPhotos().size();
        }

        boolean hasPortfolioImages = (portfolioImages != null) || (updateStudioImages != null && updateStudioImages.getPortfolioPhotos() != null);

        if (hasPortfolioImages && totalImages > 5) {
            throw new MinimumImagesRequirementException("The total number of images exceeds the allowed limit of 5. Current count: " + totalImages);
        } else if (hasPortfolioImages && totalImages < 5) {
            throw new MinimumImagesRequirementException("The total number of images is less than the allowed limit of 5. Current count: " + totalImages);
        }

    }


    public void validateStudioNameChanged(Studio studioDB, UpdateStudio updateStudio) throws StudioNameAlreadyRegisteredException {

        if (!studioDB.getStudioName().equals(updateStudio.getStudioName()) &&
                studioRepository.existsStudioByStudioName(updateStudio.getStudioName())) {
            throw new StudioNameAlreadyRegisteredException();
        }

    }

    private Location updateStudioLocation(Studio studioFromDB, UpdateStudio studio) {

        Location locationToSave;
        if (studioFromDB.getLocation() != null) {
            locationToSave = studioFromDB.getLocation();
            locationToSave.setAddress(studio.getLocation().getAddress());
            locationToSave.setCity(studio.getLocation().getCity());
            locationToSave.setCountry(studio.getLocation().getCountry());
            locationToSave.setState(studio.getLocation().getState());
        } else {
            locationToSave = new Location();
            locationToSave.setAddress(studio.getLocation().getAddress());
            locationToSave.setCity(studio.getLocation().getCity());
            locationToSave.setCountry(studio.getLocation().getCountry());
            locationToSave.setState(studio.getLocation().getState());
        }
        return locationService.updateLocation(locationToSave);

    }

    private void handlePhotographers(Studio studioSaved, UpdateStudio studio) {

        // Procesar los Photographers
        List<Photographer> photographers = new ArrayList<>();
        List<Photographer> existingPhotographers = new ArrayList<>(studioSaved.getPhotographers());

        int indexPhotographer = 0;
        for (Photographer photographer : studio.getPhotographers()) {
            if (indexPhotographer < existingPhotographers.size()) {
                Photographer existingPhotographer = existingPhotographers.get(indexPhotographer);
                existingPhotographer.setFirstName(photographer.getFirstName());
                existingPhotographer.setLastName(photographer.getLastName());
                existingPhotographer.setStudio(studioSaved);
                photographers.add(photographerService.savePhotographer(existingPhotographer));
            } else {
                photographer.setStudio(studioSaved);
                photographers.add(photographerService.savePhotographer(photographer));
            }
            indexPhotographer++;
        }

        studioSaved.setPhotographers(photographers);

    }


    private void handleSpecialties(Studio studioSaved, UpdateStudio studio) {

        List<StudioSpecialty> studioSpecialties = new ArrayList<>();

        // Obtener las entidades existentes
        List<StudioSpecialty> existingSpecialties = new ArrayList<>(studioSaved.getStudioSpecialties());

        // Iterar sobre las specialties proporcionadas desde el controlador
        int indexSpecialty = 0;
        for (Integer specialtyId : studio.getSpecialties()) {
            StudioSpecialty studioSpecialty;

            // Reutilizar entidad existente si hay, de lo contrario crear una nueva
            if (indexSpecialty < existingSpecialties.size()) {
                studioSpecialty = existingSpecialties.get(indexSpecialty);
            } else {
                studioSpecialty = new StudioSpecialty();
                studioSpecialty.setStudio(studioSaved); // Setear el estudio al objeto recién creado
                Specialty specialtyFromDB = specialtyService.findSpecialtyById(specialtyId).orElseThrow(
                        () -> new ObjectNotFoundException("Specialty not found")
                );
                studioSpecialty.setSpecialty(specialtyFromDB); // Setear la entidad specialty
            }

            // Setear el estudio y specialty en cualquier caso (nueva o existente)
            studioSpecialty.setStudio(studioSaved);
            Specialty specialtyFromDB = specialtyService.findSpecialtyById(specialtyId).orElseThrow(
                    () -> new ObjectNotFoundException("Specialty not found")
            );
            studioSpecialty.setSpecialty(specialtyFromDB);
            studioSpecialties.add(studioSpecialtyService.saveStudioSpecialty(studioSpecialty));

            indexSpecialty++;
        }

        studioSaved.setStudioSpecialties(studioSpecialties);

    }

    private void handleFeatures(Studio studioSaved, UpdateStudio studio) {

        List<StudioFeature> studioFeatures = new ArrayList<>();

        // Obtener las entidades existentes
        List<StudioFeature> existingFeatures = new ArrayList<>(studioSaved.getStudioFeatures());

        // Iterar sobre los features proporcionados desde el controlador
        int indexFeature = 0;
        for (Long featureId : studio.getFeatures()) {
            StudioFeature studioFeature;

            // Reutilizar entidad existente si hay, de lo contrario crear una nueva
            if (indexFeature < existingFeatures.size()) {
                studioFeature = existingFeatures.get(indexFeature);
            } else {
                studioFeature = new StudioFeature();
                studioFeature.setStudio(studioSaved); // Setear el estudio al objeto recién creado
                Feature featureFromDB = featureService.findFeatureById(featureId).orElseThrow(
                        () -> new ObjectNotFoundException("Feature not found")
                );
                studioFeature.setFeature(featureFromDB); // Setear la entidad feature
            }

            // Setear el estudio y feature en cualquier caso (nueva o existente)
            studioFeature.setStudio(studioSaved);
            Feature featureFromDB = featureService.findFeatureById(featureId).orElseThrow(
                    () -> new ObjectNotFoundException("Feature not found")
            );
            studioFeature.setFeature(featureFromDB);
            studioFeatures.add(studioFeatureService.saveStudioFeature(studioFeature));

            indexFeature++;
        }

        studioSaved.setStudioFeatures(studioFeatures);

    }

    String removeSpacesFromString (String name) {
        return name.replaceAll("\\s+", "");
    }

    public Boolean existsStudioByStudioName (String studioName) {
        return studioRepository.existsStudioByStudioName(studioName);
    }
}