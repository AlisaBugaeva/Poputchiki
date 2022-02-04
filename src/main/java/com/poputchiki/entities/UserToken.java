package com.poputchiki.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name="user_tokens")
@Data
public class UserToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;

    @Column(name="user_id", nullable = false)
    private int userId;

    @Column(name="access_token", nullable = false)
    private String accessToken;

    @Column(name="refresh_token", nullable = false)
    private String refreshToken;

    @Column(name="created_at", nullable = false)
    private OffsetDateTime createdAt;

    @Column(name="expired_at", nullable = false)
    private OffsetDateTime  expiredAt;

}
