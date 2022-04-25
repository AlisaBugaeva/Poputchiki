package com.poputchiki.dto.messages;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class MessagesListResponse {
    private int id;
    private String text;
    private String date;
    private int userId;

    public MessagesListResponse(String text, LocalDateTime date,int id, int userId) {
        this.text = text;
        this.date = date.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        this.id = id;
        this.userId=userId;
    }
}


