package com.poputchiki.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Entity
@Table(name="travels")
@Data
public class Travel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;

    @Column(name="user_id", nullable = false)
    private int userId;

    @Column(name="departure_point", nullable = false)
    private String departurePoint;

    @Column(name="destination_point", nullable = false)
    private String destinationPoint;

    @Column(name="departure_date", nullable = false)
    private LocalDate departureDate;

    @Column(name="destination_date", nullable = false)
    private LocalDate destinationDate;

    private String status = "OPEN";

    @Column(name="created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name="modified_at", nullable = false)
    private LocalDateTime  modifiedAt;


}
