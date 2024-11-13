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

    @NotNull(message = "Signup date cannot be null.")
    private LocalDateTime signup;

    @Min(value = 0, message = "Years of experience must be at least 0.")
    @NotNull(message = "Years of experience cannot be null.")
    private Integer yearsOfExperience;

    @NotNull(message = "Location cannot be null.")
    private Location location;

    @NotEmpty(message = "Photographers list cannot be empty or null.")
    private List<Photographer> photographers;

    @NotEmpty(message = "Specialties array cannot be empty or null.")
    private Integer[] specialties;

    @NotEmpty(message = "Features array cannot be empty or null.")
    private Long[] features;

}
