package com.luxevision.backend.service;

import com.luxevision.backend.entity.Photographer;
import com.luxevision.backend.repository.PhotographerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhotographerService {

    @Autowired
    private PhotographerRepository photographerRepository;

    public Photographer savePhotographer (Photographer photographer) {
        return photographerRepository.save(photographer);
    }

    public Optional<Photographer> findPhotographerById (Integer id) {
        return photographerRepository.findById(id);
    }

    public Photographer updatePhotographer (Photographer photographer) {
        return photographerRepository.save(photographer);
    }

    public void deletePhotographerById (Integer id) {
        photographerRepository.deleteById(id);
    }

    public List<Photographer> findAllPhotographers() {
        return photographerRepository.findAll();
    }

}
