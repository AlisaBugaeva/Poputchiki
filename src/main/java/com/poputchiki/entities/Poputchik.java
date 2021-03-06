package com.poputchiki.entities;

import com.poputchiki.constants.PopitchikiStatus;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Entity
@Table(name="poputchiki")
@Data
public class Poputchik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;

    @Column(name="poputchik_id", nullable = false)
    private int poputchikId;

    @Column(name="travel_id", nullable = false)
    private int travelId;

    private String status = PopitchikiStatus.NEW_STATUS;

    @Column(name="created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name="modified_at", nullable = false)
    private LocalDateTime  modifiedAt;


}
