package com.luxevision.backend.repository;

import com.luxevision.backend.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query("""
        SELECT COUNT(b) > 0
        FROM Booking b
        WHERE b.studio.id = :studioId
          AND b.date = :date
          AND (:startTime < b.endTime AND :endTime > b.startTime)
          AND (b.status != 'CANCELLED')
    """)
    boolean existsByDateAndTimeOverlap(@Param("date") LocalDate date,
                                       @Param("startTime") LocalTime startTime,
                                       @Param("endTime") LocalTime endTime,
                                       @Param("studioId") Integer studioId);



    List<Booking> findAllByDateIsAfter(LocalDate date);

    List<Booking> findAllByStudioId(Integer studioId);

    List<Booking> findAllByDateIsAfterAndStudioId(LocalDate date, Integer studioId);

    List<Booking> findAllByUserId(Long userId);

}
