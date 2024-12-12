package com.luxevision.backend.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class StudioPriceResponse implements Serializable {

    private Long id;
    private Integer studioID;
    private Integer specialtyID;
    private Double price;

}
