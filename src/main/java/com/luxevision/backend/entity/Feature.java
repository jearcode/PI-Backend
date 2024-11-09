package com.luxevision.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Feature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "feature_name")
    private String featureName;

    private String icon;

    @OneToMany(mappedBy = "feature")
    @JsonIgnore
    private List<StudioFeature> studioFeatures;

}
