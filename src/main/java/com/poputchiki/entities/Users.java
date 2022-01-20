package com.poputchiki.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="users")
@Data
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;

    private String name;

    private String surname;

    @Column(name="phone_number", nullable = false)
    private String phoneNumber;

    private String email;

    private String password;

    @Column(name="created_at", nullable = false)
    private Date createdAt;

    @Column(name="modified_at", nullable = false)
    private Date  modifiedAt;

}
