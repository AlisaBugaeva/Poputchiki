package com.poputchiki.services;

import com.poputchiki.RequestContext;
import com.poputchiki.constants.MessageStatus;
import com.poputchiki.constants.PopitchikiStatus;
import com.poputchiki.dto.messages.MessagesListResponse;
import com.poputchiki.entities.Message;
import com.poputchiki.entities.Poputchik;
import com.poputchiki.repositories.DialogRepository;
import com.poputchiki.repositories.MessagesRepository;
import com.poputchiki.repositories.PoputchikRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MessagesServer {
    private PoputchikRepository poputchikRepository;
    private DialogRepository dialogRepository;
    private MessagesRepository messagesRepository;
    private RequestContext requestContext;

    public MessagesServer(PoputchikRepository poputchikRepository, DialogRepository dialogRepository, MessagesRepository messagesRepository, RequestContext requestContext) {
        this.poputchikRepository = poputchikRepository;
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
        return messagesRepository.countByUserIdStatusEquals(requestContext.getUserId(), MessageStatus.UNREAD_STATUS);
    }

    public void readMessages(Integer id){
        List<Message> messages = messagesRepository.findByDialogId(id);

        for(Message message: messages) {
            message.setStatus(MessageStatus.READ_STATUS);
            messagesRepository.save(message);
        }
    }
}
