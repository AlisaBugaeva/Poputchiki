package com.poputchiki.controllers;

import com.poputchiki.constants.ApiConstants;
import com.poputchiki.dto.messages.MessagesListResponse;
import com.poputchiki.services.MessagesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiConstants.API_MESSAGES_PATH)
public class MessagesController {

    private MessagesService messagesServer;

    public MessagesController(MessagesService messagesServer) {
        this.messagesServer = messagesServer;
    }

    @GetMapping(ApiConstants.API_POPUTCHIK_ID_PATH + ApiConstants.API_VIEW_BY_ID_PATH)
    public List<MessagesListResponse> viewMessages(@PathVariable(value = "POPUTCHIK_ID") Integer id){
        return messagesServer.viewMessages(id);
    }

    @GetMapping(ApiConstants.API_UNREAD_MESSAGES_PATH)
    public int countUnreadMessages(){
        return messagesServer.countUnreadMessages();
    }

    @PostMapping(ApiConstants.API_DIALOG_ID_PATH + ApiConstants.API_READ_MESSAGES_PATH)
    public void readMessages(@PathVariable(value = "DIALOG_ID") Integer id){
        messagesServer.readMessages(id);
    }
}
