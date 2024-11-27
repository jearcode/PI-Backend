package com.luxevision.backend.dto;

import com.luxevision.backend.entity.Location;
import com.luxevision.backend.entity.Photographer;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class UpdateStudio {

    @NotNull(message = "The field 'id' has not been defined")
    private Integer id;

    @NotBlank(message = "Studio name cannot be empty or null.")
    private String studioName;

    @NotBlank(message = "Email cannot be empty or null.")
    @Email(message = "Please provide a valid email address.")
    private String email;

    @NotBlank(message = "Phone number cannot be empty or null.")
    private String phone;

    @NotBlank(message = "Description cannot be empty or null.")
    private String description;

    @Min(value = 0, message = "Years of experience must be at least 0.")
    @NotNull(message = "Years of experience cannot be null.")
    private Integer yearsOfExperience;

    @NotNull(message = "Location cannot be null.")
    private Location location;

    @Size(min = 3, max = 15, message = "The photographers list must contain between 3 and 15 photographers.")
    @NotEmpty(message = "Photographers list cannot be empty or null.")
    private List<Photographer> photographers;

    @Size(min = 1, max = 3, message = "The specialties array must contain between 1 and 3 specialties.")
    @NotEmpty(message = "Specialties array cannot be empty or null.")
    private Integer[] specialties;

    @Size(min = 1, message = "The features array must contain at least 1 feature.")
    @NotEmpty(message = "Features array cannot be empty or null.")
    private Long[] features;

}
