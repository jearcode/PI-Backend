package com.luxevision.backend.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class UpdateStudioImages {

    @NotEmpty(message = "The studioImagesURL.portfolioPhotos field cannot be empty.")
    @Size(max = 5, message = "The studioImagesURL.portfolioPhotos field can contain up to 5 values.")
    private List<String> portfolioPhotos;

}