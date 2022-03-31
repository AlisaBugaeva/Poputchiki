package com.poputchiki.entities;

import com.poputchiki.constants.MessageStatus;
import com.poputchiki.constants.PopitchikiStatus;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="messages")
@Data
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;

    @Column(name="dialog_id", nullable = false)
    private int dialogId;

    @Column(name="user_id", nullable = false)
    private int userId;

    private String message;

    private String status = MessageStatus.UNREAD_STATUS;

    @Column(name="created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name="modified_at", nullable = false)
    private LocalDateTime  modifiedAt;
}
