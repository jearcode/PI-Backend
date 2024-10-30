package com.luxevision.backend.repository;

import com.luxevision.backend.entity.Photographer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotographerRepository extends JpaRepository<Photographer, Integer> {
    @Modifying
    @Transactional
    @Query("DELETE FROM Photographer p WHERE p.studio.id = :studioId")
    void deleteByStudioId(@Param("studioId") Integer studioId);
}