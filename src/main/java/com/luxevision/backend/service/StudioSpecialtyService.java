package com.luxevision.backend.service;

import com.luxevision.backend.entity.StudioSpecialty;
import com.luxevision.backend.repository.StudioSpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudioSpecialtyService {

    @Autowired
    private StudioSpecialtyRepository studioSpecialtyRepository;

    public StudioSpecialty saveStudioSpecialty (StudioSpecialty studioSpecialty) {
        return studioSpecialtyRepository.save(studioSpecialty);
    }

    public Optional<StudioSpecialty> findStudioSpecialtyById (Integer id) {
        return studioSpecialtyRepository.findById(id);
    }

    public StudioSpecialty updateStudioSpecialty (StudioSpecialty studioSpecialty) {
        return studioSpecialtyRepository.save(studioSpecialty);
    }

    public void deleteStudioSpecialty (Integer id) {
        studioSpecialtyRepository.deleteById(id);
    }

    public List<StudioSpecialty> findAllStudioSpecialties() {
        return studioSpecialtyRepository.findAll();
    }

}
