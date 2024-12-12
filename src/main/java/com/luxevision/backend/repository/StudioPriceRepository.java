package com.luxevision.backend.repository;

import com.luxevision.backend.entity.StudioPrice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudioPriceRepository extends JpaRepository<StudioPrice, Long> {

    StudioPrice findStudioPriceByStudioIdAndSpecialtyId(Integer studioId, Integer specialtyId);
    List<StudioPrice> findByStudioId(Integer studioId);

}
