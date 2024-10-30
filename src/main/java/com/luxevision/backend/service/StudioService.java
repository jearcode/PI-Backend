package com.luxevision.backend.service;
import com.luxevision.backend.entity.Studio;
import com.luxevision.backend.repository.PhotographerRepository;
import com.luxevision.backend.repository.StudioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudioService {

    @Autowired
    private PhotographerRepository photographerRepository;
    @Autowired
    private StudioRepository studioRepository;

    public List<Studio> getRandomStudios() {
        return studioRepository.findRandomStudios(PageRequest.of(0, 10));
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

    public Studio updateStudio (Studio studio) {
        return studioRepository.save(studio);
    }

    public List<Studio> findAllStudios() {
        return studioRepository.findAll();
    }

    public Boolean existsStudioByStudioName (String studioName) {
        return studioRepository.existsStudioByStudioName(studioName);
    }
}