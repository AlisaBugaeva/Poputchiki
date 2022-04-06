package com.poputchiki.dto.messages;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MessagesListResponse {
    private String text;
    private LocalDateTime date;
    private String whose;

    public MessagesListResponse(String text, LocalDateTime date, String whose) {
        this.text = text;
        this.date = date;
        this.whose = whose;
    }
}


