package com.luxevision.backend.dto;

import com.luxevision.backend.entity.util.Status;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
public class BookingResponse implements Serializable {

    private Long id;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private Double totalPrice;
    private Status status;
    private Integer studioID;
    private Integer specialtyID;
    private String user;

}
