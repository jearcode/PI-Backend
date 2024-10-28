package com.luxevision.backend.entity;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Specialties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "specialty_name", nullable = false, length = 50)
    private String specialtyName;

    @OneToMany(mappedBy = "specialty")
    private List<StudioSpecialty> studioSpecialties;
}