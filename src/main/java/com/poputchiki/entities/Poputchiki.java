package com.poputchiki.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="poputchiki")
@Data
public class Poputchiki {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;

    @Column(name="poputchik_id", nullable = false)
    private int poputchikId;

    @Column(name="travel_id", nullable = false)
    private int travelId;

    private String status;

    @Column(name="created_at", nullable = false)
    private Date createdAt;

    @Column(name="modified_at", nullable = false)
    private Date  modifiedAt;


}
