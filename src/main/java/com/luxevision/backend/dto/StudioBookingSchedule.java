package com.luxevision.backend.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
public class StudioBookingSchedule implements Serializable {
    LocalDate date;
    LocalTime startTime;
    LocalTime endTime;
}
