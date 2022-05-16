package com.poputchiki.services;

import com.poputchiki.RequestContext;
import com.poputchiki.constants.ErrorMessages;
import com.poputchiki.constants.MessageStatus;
import com.poputchiki.dto.messages.*;
import com.poputchiki.entities.*;
import com.poputchiki.errors.PoputchikiAppException;
import com.poputchiki.repositories.*;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class MessagesService {
    private DialogRepository dialogRepository;
    private MessagesRepository messagesRepository;
    private RequestContext requestContext;
    private UserRepository userRepository;
    private TravelRepository travelRepository;
    private PoputchikRepository poputchikRepository;
    private UserTokenRepository userTokenRepository;
    private SimpMessagingTemplate messagingTemplate;

    public MessagesService(DialogRepository dialogRepository, MessagesRepository messagesRepository, RequestContext requestContext, UserRepository userRepository, TravelRepository travelRepository, PoputchikRepository poputchikRepository, UserTokenRepository userTokenRepository, SimpMessagingTemplate messagingTemplate) {
        this.dialogRepository = dialogRepository;
        this.messagesRepository = messagesRepository;
        this.requestContext = requestContext;
        this.userRepository = userRepository;
        this.travelRepository = travelRepository;
        this.poputchikRepository = poputchikRepository;
        this.userTokenRepository = userTokenRepository;
        this.messagingTemplate = messagingTemplate;
    }

    public List<MessagesListResponse> viewMessages(Integer id){
        int dialogId = dialogRepository.findByPoputchikiId(id).getId();
        List<Message> messages = messagesRepository.findByDialogIdOrderByCreatedAt(dialogId);

        List<MessagesListResponse> messagesListResponses = new ArrayList<>();
        for(Message message: messages){
            messagesListResponses.add(new MessagesListResponse(message.getMessage(), message.getCreatedAt(), dialogId,message.getUserId()));
        }
        return messagesListResponses;
    }

    public boolean countUnreadMessages(){
        return messagesRepository.countByUserIdNotAndStatus(requestContext.getUserId(), MessageStatus.UNREAD_STATUS) != 0;
    }

    public void readMessages(Integer id){
        int dialogId = dialogRepository.findByPoputchikiId(id).getId();
        List<Message> messages = messagesRepository.findByDialogIdOrderByCreatedAt(dialogId);

        for(Message message: messages) {
            if(message.getUserId()!=requestContext.getUserId()) {
                message.setStatus(MessageStatus.READ_STATUS);
                messagesRepository.save(message);
            }
        }
    }

    public List<DialogListResponse> viewDialogs() {
        int myId = requestContext.getUserId();
        List<Poputchik> poputchiki = poputchikRepository.viewAllDialogs(myId);

        List<DialogListResponse> dialogListResponses = new ArrayList<>();
        for (Poputchik poputchik : poputchiki) {
            User user;
            Travel travel = travelRepository.findById(poputchik.getTravelId()).orElseThrow(() -> new PoputchikiAppException(ErrorMessages.UNKNOWN_ERROR));
            Dialog dialog = dialogRepository.findByPoputchikiId(poputchik.getId());
            if (poputchik.getPoputchikId() != myId) {
                user = userRepository.findById(poputchik.getPoputchikId()).orElseThrow(() -> new PoputchikiAppException(ErrorMessages.UNKNOWN_ERROR));
            } else {
                user = travel.getUser();
            }
            if (messagesRepository.lastMessage(dialog.getId()).getMessage()!= null) {
                dialogListResponses.add(new DialogListResponse(poputchik.getId(), user.getName(), user.getSurname(),
                        travel.getDeparturePoint(), travel.getDestinationPoint(), travel.getDepartureDate(), travel.getDestinationDate(),
                        messagesRepository.lastMessage(dialog.getId()).getMessage()));
            }
            else
                dialogListResponses.add(new DialogListResponse(poputchik.getId(), user.getName(), user.getSurname(),
                        travel.getDeparturePoint(), travel.getDestinationPoint(), travel.getDepartureDate(), travel.getDestinationDate(),
                        "-"));
        }

        return dialogListResponses;

    }


    public void send(MessageRequest message, String token) throws Exception {
        Message newMessage = new Message();

        int dialogId = dialogRepository.findByPoputchikiId(message.getIdPoputchik()).getId();
        newMessage.setMessage(message.getText());
        newMessage.setUserId(userTokenRepository.findByAccessToken(token).getUserId());
        newMessage.setDialogId(dialogId);
        newMessage.setCreatedAt(LocalDateTime.now());
        newMessage.setModifiedAt(LocalDateTime.now());

        messagesRepository.save(newMessage);

        messagingTemplate.convertAndSendToUser(
                String.valueOf(message.getIdPoputchik()),"/topic/messages",
                new MessagesListResponse(newMessage.getMessage(), newMessage.getCreatedAt(), newMessage.getDialogId(),userTokenRepository.findByAccessToken(token).getUserId()));
    }
}
