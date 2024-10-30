package com.luxevision.backend.service;
import com.luxevision.backend.entity.Studio;
import com.luxevision.backend.repository.StudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudioService {

    @Autowired
    private StudioRepository studioRepository;

    public List<Studio> getRandomStudios() {
        return studioRepository.findRandomStudios(PageRequest.of(0, 10));
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

    public void deleteStudioById (Integer id) {
        studioRepository.deleteById(id);
    }

    public List<Studio> findAllStudios() {
        return studioRepository.findAll();
    }

    public Boolean existsStudioByStudioName (String studioName) {
        return studioRepository.existsStudioByStudioName(studioName);
    }
}