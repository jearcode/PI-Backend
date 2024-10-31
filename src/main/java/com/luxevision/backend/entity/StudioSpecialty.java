package com.luxevision.backend.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class StudioSpecialty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "studio_id")
    @JsonIgnore
    private Studio studio;

    @ManyToOne
    @JoinColumn(name = "specialty_id")
    private Specialty specialty;
}