package com.poputchiki.dto.messages;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MessagesListResponse {
    private String text;
    private LocalDateTime date;

    public MessagesListResponse(String text, LocalDateTime date) {
        this.text = text;
        this.date = date;
    }
}


