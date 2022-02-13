package com.poputchiki.services;

import com.poputchiki.RequestContext;
import com.poputchiki.dto.home.NewTripListResponse;
import com.poputchiki.dto.join.TripListResponse;
import com.poputchiki.dto.make.trip.NewTripRequest;
import com.poputchiki.entities.Poputchik;
import com.poputchiki.entities.Travel;
import com.poputchiki.entities.User;
import com.poputchiki.errors.PoputchikiAppException;
import com.poputchiki.repositories.PoputchikRepository;
import com.poputchiki.repositories.TravelRepository;
import com.poputchiki.repositories.UserRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;


@Component
public class ActionWithTripService {

    private PoputchikRepository poputchikRepository;
    private TravelRepository travelRepository;
    private UserRepository userRepository;
    private RequestContext requestContext;

    public ActionWithTripService(PoputchikRepository poputchikRepository, TravelRepository travelRepository, UserRepository userRepository, RequestContext requestContext) {
        this.poputchikRepository = poputchikRepository;
        this.travelRepository = travelRepository;
        this.userRepository = userRepository;
        this.requestContext = requestContext;
    }

    public void joinTheTrip(Integer id){
        Poputchik poputchik = new Poputchik();
        poputchik.setPoputchikId(requestContext.getUserId());
        poputchik.setTravelId(id);
        poputchik.setCreatedAt(LocalDateTime.now());
        poputchik.setModifiedAt(LocalDateTime.now());

        poputchikRepository.save(poputchik);

    }

    public void makeNewTrip( NewTripRequest trip){
        Travel travel = new Travel();
        travel.setUserId(requestContext.getUserId());
        travel.setDeparturePoint(trip.getStart());
        travel.setDestinationPoint(trip.getFinish());
        travel.setDepartureDate(trip.getStartDate());
        travel.setDestinationDate(trip.getFinishDate());
        travel.setCreatedAt(LocalDateTime.now());
        travel.setModifiedAt(LocalDateTime.now());

        travelRepository.save(travel);

    }

    public TripListResponse viewTheTrip(Integer id){
        Travel travel = travelRepository.findById(id).orElseThrow(
                ()-> new PoputchikiAppException("No trip with such ID")
        );

        TripListResponse tripListResponse = new TripListResponse(userRepository.findById(travel.getUserId()).orElseThrow(
                        ()-> new PoputchikiAppException("Something went wrong!")).getName(),
                userRepository.findById(travel.getUserId()).orElseThrow(
                        ()-> new PoputchikiAppException("Something went wrong!")).getSurname(),
                travel.getDeparturePoint(),travel.getDestinationPoint(),travel.getDepartureDate(),travel.getDestinationDate());
        return tripListResponse;
    }

    public void deleteTheTrip(Integer id){
        Travel travel = travelRepository.findById(id).orElseThrow(
                ()-> new PoputchikiAppException("No trip with such ID")
        );
        travel.setStatus("CLOSED");

        travelRepository.save(travel);

    }
}
