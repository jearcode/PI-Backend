package com.luxevision.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class StudioPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "studio_id")
    private Studio studio;

    @ManyToOne
    @JoinColumn(name = "specialty_id")
    private Specialty specialty;

    @Column
    private Double price;

}
