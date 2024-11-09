package com.luxevision.backend.controller;

import com.luxevision.backend.entity.Feature;
import com.luxevision.backend.service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/features")
public class FeatureController {

    @Autowired
    private FeatureService featureService;

    @PostMapping
    public ResponseEntity<Feature> saveFeature (@RequestBody Feature feature) {
        return ResponseEntity.status(HttpStatus.CREATED).body(featureService.saveFeature(feature));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Feature> findFeatureById (@PathVariable Long id) {

        Optional<Feature> featureFromDB = featureService.findFeatureById(id);

        if(!featureFromDB.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(featureFromDB.get());

    }

    @PutMapping
    public ResponseEntity<Feature> updateFeature (@RequestBody Feature feature) {

        Optional<Feature> featureFromDB = featureService.findFeatureById(feature.getId());

        if(!featureFromDB.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(featureService.updateFeature(feature));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFeatureById (@PathVariable Long id) {

        Optional<Feature> featureFromDB = featureService.findFeatureById(id);

        if(!featureFromDB.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        featureService.deleteFeatureById(id);
        return ResponseEntity.noContent().build();

    }

    @GetMapping
    public ResponseEntity<List<Feature>> findAllFeatures () {
        return ResponseEntity.ok(featureService.findAllFeatures());
    }

}
