package com.luxevision.backend.repository;

import com.luxevision.backend.entity.Photographer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotographerRepository extends JpaRepository<Photographer, Integer> {
}
