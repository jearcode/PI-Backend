package com.luxevision.backend.service;

import com.luxevision.backend.entity.Feature;
import com.luxevision.backend.repository.FeatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeatureService {

    @Autowired
    private FeatureRepository featureRepository;

    public Feature saveFeature (Feature feature) {
        return featureRepository.save(feature);
    }

    public Optional<Feature> findFeatureById (Long id) {
        return featureRepository.findById(id);
    }

    public Feature updateFeature (Feature feature) {
        return featureRepository.save(feature);
    }

    public void deleteFeatureById (Long id) {
        featureRepository.deleteById(id);
    }

    public List<Feature> findAllFeatures () {
        return featureRepository.findAll();
    }

}
