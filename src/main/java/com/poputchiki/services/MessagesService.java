package com.poputchiki.services;

import com.poputchiki.RequestContext;
import com.poputchiki.constants.ErrorMessages;
import com.poputchiki.constants.MessageStatus;
import com.poputchiki.constants.WhoseConstants;
import com.poputchiki.dto.messages.DialogListResponse;
import com.poputchiki.dto.messages.MessagesListResponse;
import com.poputchiki.entities.*;
import com.poputchiki.errors.PoputchikiAppException;
import com.poputchiki.repositories.*;
import org.springframework.stereotype.Component;

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

    public MessagesService(DialogRepository dialogRepository, MessagesRepository messagesRepository, RequestContext requestContext, UserRepository userRepository, TravelRepository travelRepository, PoputchikRepository poputchikRepository) {
        this.dialogRepository = dialogRepository;
        this.messagesRepository = messagesRepository;
        this.requestContext = requestContext;
        this.userRepository = userRepository;
        this.travelRepository = travelRepository;
        this.poputchikRepository = poputchikRepository;
    }

    public List<MessagesListResponse> viewMessages(Integer id){
        int dialogId = dialogRepository.findByPoputchikiId(id).getId();
        List<Message> messages = messagesRepository.findByDialogIdOrderByCreatedAt(dialogId);

        List<MessagesListResponse> messagesListResponses = new ArrayList<>();
        String whose;
        for(Message message: messages){
            if(message.getUserId() == requestContext.getUserId()){
                whose = WhoseConstants.MY;
            }
            else{
                whose = WhoseConstants.NOT_MY;
            }
            messagesListResponses.add(new MessagesListResponse(message.getMessage(), message.getCreatedAt(), whose));
        }
        return messagesListResponses;
    }

    public int countUnreadMessages(){
        return messagesRepository.countByUserIdNotAndStatus(requestContext.getUserId(), MessageStatus.UNREAD_STATUS);
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
            dialogListResponses.add(new DialogListResponse(poputchik.getId(),user.getName(), user.getSurname(),
                    travel.getDeparturePoint(), travel.getDestinationPoint(), travel.getDepartureDate(), travel.getDestinationDate(),
                    messagesRepository.lastMessage(dialog.getId()).getMessage()));
        }

        return dialogListResponses;

    }
}
