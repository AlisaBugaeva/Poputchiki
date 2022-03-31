package com.poputchiki.entities;

import com.poputchiki.constants.PopitchikiStatus;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="dialogs")
@Data
public class Dialog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;

    @Column(name="poputchiki_id", nullable = false)
    private int poputchikiId;

    @Column(name="created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name="modified_at", nullable = false)
    private LocalDateTime  modifiedAt;
}
