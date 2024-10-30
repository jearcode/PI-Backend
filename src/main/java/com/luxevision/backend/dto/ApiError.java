package com.luxevision.backend.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class ApiError implements Serializable {

    private LocalDateTime timestamp;
    private String error;
    private String message;
    private String method;

}
