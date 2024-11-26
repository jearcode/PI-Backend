package com.luxevision.backend.dto;

import lombok.Data;

import java.util.List;

@Data
public class FavoriteResponse {
    private List<Long> studios;
}