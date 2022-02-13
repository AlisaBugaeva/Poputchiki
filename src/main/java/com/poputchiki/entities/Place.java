package com.poputchiki.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Entity
@Table(name="places")
@Data
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;

    private String city;

    private String description;

    private String photo;

    @Column(name="created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name="modified_at", nullable = false)
    private LocalDateTime modifiedAt;
}
