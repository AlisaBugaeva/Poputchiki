package com.poputchiki.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="places")
@Data
public class Places {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;

    private String city;

    private String description;

    private String photo;

    @Column(name="created_at", nullable = false)
    private Date createdAt;

    @Column(name="modified_at", nullable = false)
    private Date modifiedAt;
}
