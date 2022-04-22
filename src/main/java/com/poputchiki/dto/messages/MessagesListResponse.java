package com.poputchiki.dto.messages;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MessagesListResponse {
    private int id;
    private String text;
    private LocalDateTime date;
    private boolean mine;

    public MessagesListResponse(String text, LocalDateTime date, boolean mine,int id) {
        this.text = text;
        this.date = date;
        this.mine = mine;
        this.id = id;
    }
}


