package com.luxevision.backend.entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Photographer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "studio_id", nullable = false)
    private Studio studio;
}