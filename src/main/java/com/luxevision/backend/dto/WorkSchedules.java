package com.luxevision.backend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WorkSchedules {

    private String monday;
    private String tuesday;
    private String wednesday;
    private String thursday;
    private String friday;
    private String saturday;
    private String sunday;

}
