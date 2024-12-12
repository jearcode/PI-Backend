package com.luxevision.backend.dto;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class QuotationResponse implements Serializable {

    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private String hours;
    private String totalHours;
    private Double pricePerHalfHour;
    private Double totalPrice;
    private Integer specialtyID;
    private Integer studioID;

}
