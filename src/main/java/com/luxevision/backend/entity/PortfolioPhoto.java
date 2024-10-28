package com.luxevision.backend.entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class PortfolioPhoto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 255)
    private String image;

    @ManyToOne
    @JoinColumn(name = "studio_id", nullable = false)
    private Studio studio;
}