package com.luxevision.backend.entity;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Studio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "studio_name", nullable = false, length = 255)
    private String studioName;

    @Column(nullable = false, length = 150)
    private String email;

    @Column(length = 15)
    private String phone;

    @Column(length = 200)
    private String description;

    @Column(nullable = false)
    private LocalDateTime signup;

    @Column(name = "years_of_experience", nullable = false)
    private Integer yearsOfExperience;

    @Column(name = "profile_image", length = 255)
    private String profileImage;

    @OneToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @OneToMany(mappedBy = "studio")
    private List<Photographer> photographers;

    @OneToMany(mappedBy = "studio")
    private List<PortfolioPhoto> portfolioPhotos;

    @OneToMany(mappedBy = "studio")
    private List<StudioSpecialty> studioSpecialties;
}

