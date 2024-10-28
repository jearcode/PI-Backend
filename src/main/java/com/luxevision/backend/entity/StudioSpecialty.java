package com.luxevision.backend.entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class StudioSpecialty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "studio_id", nullable = false)
    private Studio studio;

    @ManyToOne
    @JoinColumn(name = "specialty_id", nullable = false)
    private Specialties specialty;
}