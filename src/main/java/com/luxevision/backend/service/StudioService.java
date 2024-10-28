package com.luxevision.backend.service;
import com.luxevision.backend.entity.Studio;
import com.luxevision.backend.repository.StudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudioService {

    @Autowired
    private StudioRepository studioRepository;

    public List<Studio> getRandomStudios() {
        return studioRepository.findRandomStudios(PageRequest.of(0, 10));
    }
}