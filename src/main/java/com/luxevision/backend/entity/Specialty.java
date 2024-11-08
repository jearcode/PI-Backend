package com.luxevision.backend.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Specialty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "specialty_name", length = 50)
    private String specialtyName;

    private String description;

    private String image;

    @OneToMany(mappedBy = "specialty")
    @JsonIgnore
    private List<StudioSpecialty> studioSpecialties;
}