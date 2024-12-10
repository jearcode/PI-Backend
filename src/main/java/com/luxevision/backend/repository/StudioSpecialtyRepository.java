package com.luxevision.backend.repository;

import com.luxevision.backend.entity.StudioSpecialty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudioSpecialtyRepository extends JpaRepository<StudioSpecialty, Integer> {

    Boolean existsStudioSpecialtiesByStudioIdAndSpecialtyId(Integer studioId, Integer specialtyId);

}
