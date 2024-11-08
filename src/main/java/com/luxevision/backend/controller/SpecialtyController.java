package com.luxevision.backend.controller;

import com.luxevision.backend.entity.Specialty;
import com.luxevision.backend.service.S3Service;
import com.luxevision.backend.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/specialties")
public class SpecialtyController {

    @Autowired
    private SpecialtyService specialtyService;

    @Autowired
    private S3Service s3Service;

    @PostMapping
    public ResponseEntity<Specialty> saveSpecialty (@RequestPart Specialty specialty,
                                                    @RequestPart MultipartFile image) throws IOException {

        try{
            String imageURL = s3Service.uploadImage(image, specialty.getSpecialtyName());
            specialty.setImage(imageURL);
            specialtyService.saveSpecialty(specialty);
            return ResponseEntity.status(HttpStatus.CREATED).body(specialty);
        } catch (IOException e) {
            throw new IOException(e.getLocalizedMessage());
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Specialty> findSpecialtyById (@PathVariable Integer id) {
        Optional<Specialty> specialtyFromDB = specialtyService.findSpecialtyById(id);
        if (!specialtyFromDB.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(specialtyFromDB.get());
    }

    @PutMapping
    public ResponseEntity<Specialty> updateSpecialty (@RequestBody Specialty specialty) {

        Optional<Specialty> specialtyFromDB = specialtyService.findSpecialtyById(specialty.getId());

        if (!specialtyFromDB.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(specialtyService.updateSpecialty(specialty));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSpecialtyById (@PathVariable Integer id) {
        Optional<Specialty> specialtyFromDB = specialtyService.findSpecialtyById(id);
        if (!specialtyFromDB.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        s3Service.deleteObject(specialtyFromDB.get(), null);
        specialtyService.deleteSpecialtyById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Specialty>> findAllSpecialties () {
        return ResponseEntity.ok(specialtyService.findAllSpecialties());
    }

}
