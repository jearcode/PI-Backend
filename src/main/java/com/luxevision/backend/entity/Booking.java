package com.luxevision.backend.entity;

import com.luxevision.backend.entity.util.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "booking_date")
    private LocalDate date;
    @Column(name = "start_time")
    private LocalTime startTime;
    @Column(name = "end_time")
    private LocalTime endTime;
    @Column(name = "total_price")
    private Double totalPrice;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "studio_id")
    private Studio studio;

    @ManyToOne
    @JoinColumn(name = "specialty_id")
    private Specialty specialty;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
