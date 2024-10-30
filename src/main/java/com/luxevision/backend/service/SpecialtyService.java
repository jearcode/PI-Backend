package com.luxevision.backend.service;

import com.luxevision.backend.entity.Specialty;
import com.luxevision.backend.repository.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecialtyService {

    @Autowired
    private SpecialtyRepository specialtyRepository;

    public Specialty saveSpecialty (Specialty specialty) {
        return specialtyRepository.save(specialty);
    }

    public Optional<Specialty> findSpecialtyById(Integer id) {
        return specialtyRepository.findById(id);
    }

    public Specialty updateSpecialty (Specialty specialty) {
        return specialtyRepository.save(specialty);
    }

    public void deleteSpecialtyById (Integer id) {
        specialtyRepository.deleteById(id);
    }

    public List<Specialty> findAllSpecialties() {
        return specialtyRepository.findAll();
    }

}
