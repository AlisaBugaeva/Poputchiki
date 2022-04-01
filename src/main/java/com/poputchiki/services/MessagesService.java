package com.poputchiki.services;

import com.poputchiki.RequestContext;
import com.poputchiki.constants.MessageStatus;
import com.poputchiki.dto.messages.MessagesListResponse;
import com.poputchiki.entities.Message;
import com.poputchiki.repositories.DialogRepository;
import com.poputchiki.repositories.MessagesRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MessagesService {
    private DialogRepository dialogRepository;
    private MessagesRepository messagesRepository;
    private RequestContext requestContext;

    public MessagesService( DialogRepository dialogRepository, MessagesRepository messagesRepository, RequestContext requestContext) {
        this.dialogRepository = dialogRepository;
        this.messagesRepository = messagesRepository;
        this.requestContext = requestContext;
    }

    public List<MessagesListResponse> viewMessages(Integer id){
        int dialogId = dialogRepository.findByPoputchikiId(id).getId();
        List<Message> messages = messagesRepository.findByDialogId(dialogId);

        List<MessagesListResponse> messagesListResponses = new ArrayList<>();
        for(Message message: messages){
            messagesListResponses.add(new MessagesListResponse(message.getMessage(), message.getCreatedAt()));
        }
        return messagesListResponses;
    }

    public int countUnreadMessages(){
        return messagesRepository.countByUserIdAndStatusEquals(requestContext.getUserId(), MessageStatus.UNREAD_STATUS);
    }

    public void readMessages(Integer id){
        List<Message> messages = messagesRepository.findByDialogId(id);

        for(Message message: messages) {
            message.setStatus(MessageStatus.READ_STATUS);
            messagesRepository.save(message);
        }
    }
}
