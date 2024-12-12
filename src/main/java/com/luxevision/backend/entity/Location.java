package com.luxevision.backend.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String city;

    @Column(length = 50)
    private String state;

    @Column(nullable = false, length = 50)
    private String country;

    @Column(length = 255)
    private String address;

    @OneToOne(mappedBy = "location")
    @JsonIgnore
    private Studio studio;
}