package com.luxevision.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class StudioFeature {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "studio_id")
    @JsonIgnore
    private Studio studio;

    @ManyToOne
    @JoinColumn(name = "feature_id")
    private Feature feature;

}
