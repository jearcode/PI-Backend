package com.luxevision.backend.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class QuotationRequest {

    @NotNull(message = "Date is mandatory.")
    private LocalDate date;

    @NotNull(message = "Start time is mandatory.")
    private LocalTime startTime;

    @NotNull(message = "End time is mandatory.")
    private LocalTime endTime;

    @NotNull(message = "Studio ID is mandatory.")
    private Integer studioID;

    @NotNull(message = "Specialty ID is mandatory.")
    private Integer specialtyID;

}
