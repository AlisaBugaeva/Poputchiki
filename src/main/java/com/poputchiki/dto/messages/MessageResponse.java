package com.poputchiki.dto.messages;

import com.poputchiki.constants.MessageStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MessageResponse {

    private int DialogId;
    private String text;
    private String status = MessageStatus.UNREAD_STATUS;
    private LocalDateTime date;
    private boolean mine = true;

    public MessageResponse(int dialogId, String text, LocalDateTime date) {
        DialogId = dialogId;
        this.text = text;
        this.date = date;
    }
}
