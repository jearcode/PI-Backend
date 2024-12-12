package com.luxevision.backend.repository;

import com.luxevision.backend.entity.Studio;
import com.luxevision.backend.entity.StudioWorkingHours;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;

public interface StudioWorkingHoursRepository extends JpaRepository<StudioWorkingHours, Long> {

    Optional<StudioWorkingHours> findByStudioAndDayOfWeek(Studio studio, DayOfWeek dayOfWeek);

    List<StudioWorkingHours> findAllByStudioId(Integer studioId);

}
