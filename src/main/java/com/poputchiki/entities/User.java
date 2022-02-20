package com.poputchiki.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Table(name="users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Travel> travels;

    private String name;

    private String surname;

    @Column(name="phone_number", nullable = false)
    private String phoneNumber;

    private String email;

    private String password;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name="modified_at")
    private LocalDateTime  modifiedAt;

}
