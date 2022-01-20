package com.poputchiki.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="travels")
@Data
public class Travels {
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
    private Date departureDate;

    @Column(name="destination_date", nullable = false)
    private Date destinationDate;

    private String status;

    @Column(name="created_at", nullable = false)
    private Date createdAt;

    @Column(name="modified_at", nullable = false)
    private Date  modifiedAt;


}
