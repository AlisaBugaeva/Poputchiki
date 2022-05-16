package com.poputchiki.services;

import com.poputchiki.RequestContext;
import com.poputchiki.constants.ErrorMessages;
import com.poputchiki.constants.PopitchikiStatus;
import com.poputchiki.dto.poputchiki.AcceptedTravelRequestsResponse;
import com.poputchiki.dto.poputchiki.MyTravelRequestsResponse;
import com.poputchiki.dto.poputchiki.TravelRequestsResponse;
import com.poputchiki.entities.Dialog;
import com.poputchiki.entities.Poputchik;
import com.poputchiki.entities.Travel;
import com.poputchiki.entities.User;
import com.poputchiki.errors.PoputchikiAppException;
import com.poputchiki.repositories.DialogRepository;
import com.poputchiki.repositories.PoputchikRepository;
import com.poputchiki.repositories.TravelRepository;
import com.poputchiki.repositories.UserRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class PoputchikiService {

    private PoputchikRepository poputchikRepository;
    private UserRepository userRepository;
    private RequestContext requestContext;
    private TravelRepository travelRepository;
    private DialogRepository dialogRepository;

    public PoputchikiService(PoputchikRepository poputchikRepository, UserRepository userRepository, RequestContext requestContext, TravelRepository travelRepository, DialogRepository dialogRepository) {
        this.poputchikRepository = poputchikRepository;
        this.userRepository = userRepository;
        this.requestContext = requestContext;
        this.travelRepository = travelRepository;
        this.dialogRepository = dialogRepository;
    }

    public List<TravelRequestsResponse> viewRequests(Integer id){
        List<Poputchik> poputchiki = poputchikRepository.findByTravelId(id);
        List<TravelRequestsResponse> travelRequestsResponses = new ArrayList<>();

        for(Poputchik poputchik: poputchiki) {
            if (poputchik.getStatus().equals(PopitchikiStatus.NEW_STATUS)) {
                User user = userRepository.findById(poputchik.getPoputchikId()).orElseThrow(() -> new PoputchikiAppException(ErrorMessages.UNKNOWN_ERROR));
                travelRequestsResponses.add(new TravelRequestsResponse(poputchik.getPoputchikId(),user.getName(),user.getSurname()));
            }
        }
        return travelRequestsResponses;
    }

    public void acceptRequest(Integer idPoputchik, Integer idTravel){
        List <Poputchik> poputchiki = poputchikRepository.findByPoputchikIdAndAndTravelId(idPoputchik, idTravel);

        for(Poputchik poputchik: poputchiki) {
                poputchik.setStatus(PopitchikiStatus.ACCEPTED_STATUS);
            poputchikRepository.save(poputchik);

            Dialog dialog = new Dialog();
            dialog.setPoputchikiId(poputchik.getId());
            dialog.setCreatedAt(LocalDateTime.now());
            dialog.setModifiedAt(LocalDateTime.now());
            dialogRepository.save(dialog);
        }

    }

    public void rejectRequest(Integer idPoputchik, Integer idTravel){
        List <Poputchik> poputchiki = poputchikRepository.findByPoputchikIdAndAndTravelId(idPoputchik, idTravel);

        for(Poputchik poputchik: poputchiki) {
            poputchik.setStatus(PopitchikiStatus.DECLINED_STATUS);
            poputchikRepository.save(poputchik);
        }
    }

    public List<MyTravelRequestsResponse> viewMyRequests(){
        List <Poputchik> poputchiki = poputchikRepository.findByPoputchikId(requestContext.getUserId());

        List<MyTravelRequestsResponse> myTravelRequestsResponses = new ArrayList<>();

        for(Poputchik poputchik: poputchiki) {
            Travel travel = travelRepository.findById(poputchik.getTravelId()).orElseThrow(() -> new PoputchikiAppException(ErrorMessages.UNKNOWN_ERROR));
            User user = travel.getUser();
            String email = "-";
            if(poputchik.getStatus().equals(PopitchikiStatus.ACCEPTED_STATUS)){
                email = user.getEmail();
            }
                myTravelRequestsResponses.add(new MyTravelRequestsResponse(poputchik.getId(),user.getName(), user.getSurname(),email,travel.getDeparturePoint(),travel.getDestinationPoint(),travel.getDepartureDate(),travel.getDestinationDate(),poputchik.getStatus()));
            }
        return myTravelRequestsResponses;
    }




    public List<AcceptedTravelRequestsResponse> viewAcceptedRequests(){
        List <Poputchik> poputchiki = poputchikRepository.userRequests(requestContext.getUserId());

        List<AcceptedTravelRequestsResponse> acceptedTravelRequestsResponses = new ArrayList<>();

        for(Poputchik poputchik: poputchiki) {
            User user = userRepository.findById(poputchik.getPoputchikId()).orElseThrow(() -> new PoputchikiAppException(ErrorMessages.UNKNOWN_ERROR));
            Travel travel = travelRepository.findById(poputchik.getTravelId()).orElseThrow(() -> new PoputchikiAppException(ErrorMessages.UNKNOWN_ERROR));
            String email = user.getEmail();
            if(poputchik.getStatus().equals(PopitchikiStatus.ACCEPTED_STATUS)) {
                acceptedTravelRequestsResponses.add(new AcceptedTravelRequestsResponse(poputchik.getId(),user.getName(), user.getSurname(), email, travel.getDeparturePoint(), travel.getDestinationPoint(), travel.getDepartureDate(), travel.getDestinationDate()));
            }
        }
        return acceptedTravelRequestsResponses;
    }


}
