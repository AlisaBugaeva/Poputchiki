package com.poputchiki.services;

import com.poputchiki.RequestContext;
import com.poputchiki.constants.ErrorMessages;
import com.poputchiki.constants.TravelStatus;
import com.poputchiki.dto.join.TripListResponse;
import com.poputchiki.dto.make.trip.NewTripRequest;
import com.poputchiki.entities.Poputchik;
import com.poputchiki.entities.Travel;
import com.poputchiki.entities.User;
import com.poputchiki.errors.PoputchikiAppException;
import com.poputchiki.repositories.PlaceRepository;
import com.poputchiki.repositories.PoputchikRepository;
import com.poputchiki.repositories.TravelRepository;
import com.poputchiki.repositories.UserRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
public class ActionWithTripService {

    private PoputchikRepository poputchikRepository;
    private TravelRepository travelRepository;
    private UserRepository userRepository;
    private PlaceRepository placeRepository;
    private RequestContext requestContext;

    public ActionWithTripService(PoputchikRepository poputchikRepository, TravelRepository travelRepository, UserRepository userRepository, PlaceRepository placeRepository, RequestContext requestContext) {
        this.poputchikRepository = poputchikRepository;
        this.travelRepository = travelRepository;
        this.userRepository = userRepository;
        this.placeRepository = placeRepository;
        this.requestContext = requestContext;
    }

    public void joinTheTrip(Integer id){
        travelRepository.findById(id).orElseThrow(
                ()-> new PoputchikiAppException(ErrorMessages.TRIP_NOT_EXISTS));

        int poputchikId = requestContext.getUserId();
        if(poputchikRepository.findByPoputchikIdAndAndTravelId(poputchikId,id).isEmpty()) {
            Poputchik poputchik = new Poputchik();
            poputchik.setPoputchikId(poputchikId);
            poputchik.setTravelId(id);
            poputchik.setCreatedAt(LocalDateTime.now());
            poputchik.setModifiedAt(LocalDateTime.now());

            poputchikRepository.save(poputchik);
        }

    }

    public void makeNewTrip( NewTripRequest trip){
        if(placeRepository.findByCity(trip.getFinish())!=null
            && placeRepository.findByCity(trip.getStart())!=null) {

            Travel travel = new Travel();


            travel.setUser(userRepository.findById(requestContext.getUserId()).orElseThrow(
                    ()-> new PoputchikiAppException(ErrorMessages.UNKNOWN_ERROR)));
            travel.setDeparturePoint(trip.getStart());
            travel.setDestinationPoint(trip.getFinish());
            travel.setDepartureDate(trip.getStartDate());
            travel.setDestinationDate(trip.getFinishDate());
            travel.setCreatedAt(LocalDateTime.now());
            travel.setModifiedAt(LocalDateTime.now());

            travelRepository.save(travel);
        }
        else {
            throw new PoputchikiAppException(ErrorMessages.PLACE_NOT_EXISTS);
        }

    }

    public TripListResponse viewTheTrip(Integer id){
        Travel travel = travelRepository.findById(id).orElseThrow(
                ()-> new PoputchikiAppException(ErrorMessages.TRIP_NOT_EXISTS)
        );

        TripListResponse tripListResponse = new TripListResponse(travel.getUser().getName(),travel.getUser().getSurname(),
                travel.getDeparturePoint(),travel.getDestinationPoint(),travel.getDepartureDate(),travel.getDestinationDate());
        return tripListResponse;
    }

    public void deleteTheTrip(Integer id){
        Travel travel = travelRepository.findById(id).orElseThrow(
                ()-> new PoputchikiAppException(ErrorMessages.TRIP_NOT_EXISTS)
        );
        travel.setStatus(TravelStatus.CLOSED_STATUS);

        travelRepository.save(travel);

    }
}
