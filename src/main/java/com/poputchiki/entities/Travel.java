package com.poputchiki.entities;

import com.poputchiki.constants.TravelStatus;
import lombok.Data;
import lombok.ToString;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private User user;

    @Column(name="departure_point", nullable = false)
    private String departurePoint;

    @Column(name="destination_point", nullable = false)
    private String destinationPoint;

    @Column(name="departure_date", nullable = false)
    private LocalDate departureDate;

    @Column(name="destination_date", nullable = false)
    private LocalDate destinationDate;

    private String status = TravelStatus.OPEN_STATUS;

    @Column(name="created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name="modified_at", nullable = false)
    private LocalDateTime  modifiedAt;


}
