package com.luxevision.backend.service;

import com.luxevision.backend.entity.StudioFeature;
import com.luxevision.backend.repository.StudioFeatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudioFeatureService {

    @Autowired
    private StudioFeatureRepository studioFeatureRepository;

    public StudioFeature saveStudioFeature (StudioFeature studioFeature) {
        return studioFeatureRepository.save(studioFeature);
    }

    public Optional<StudioFeature> findStudioFeatureById (Long id) {
        return studioFeatureRepository.findById(id);
    }

    public StudioFeature updateStudioFeature (StudioFeature studioFeature) {
        return studioFeatureRepository.save(studioFeature);
    }

    public void deleteStudioFeatureById (Long id) {
        studioFeatureRepository.deleteById(id);
    }

    public List<StudioFeature> findAllStudioFeatures () {
        return studioFeatureRepository.findAll();
    }

}
