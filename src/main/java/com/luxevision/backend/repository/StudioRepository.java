package com.luxevision.backend.repository;
import com.luxevision.backend.entity.Studio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface StudioRepository extends JpaRepository<Studio, Integer> {

    @Query("SELECT s FROM Studio s ORDER BY FUNCTION('RAND')")
    List<Studio> findRandomStudios(org.springframework.data.domain.Pageable pageable);

    Boolean existsStudioByStudioName(String studioName);

    @Query("""
    SELECT s
    FROM Studio s
    JOIN s.studioSpecialties ss
    JOIN ss.specialty sp
    JOIN StudioWorkingHours wh ON wh.studio.id = s.id
    WHERE sp.id = :specialtyId
      AND wh.dayOfWeek = :dayOfWeek
      AND :startTime >= wh.openingTime
      AND :endTime <= wh.closingTime
      AND NOT EXISTS (
          SELECT 1
          FROM Booking b
          WHERE b.studio.id = s.id
            AND b.date = :date
            AND (:startTime < b.endTime AND :endTime > b.startTime)
            AND (b.status != 'CANCELLED')
      )
""")
    List<Studio> findAvailableStudios(
            @Param("specialtyId") Integer specialtyId,
            @Param("dayOfWeek") DayOfWeek dayOfWeek,
            @Param("date") LocalDate date,
            @Param("startTime") LocalTime startTime,
            @Param("endTime") LocalTime endTime);






}