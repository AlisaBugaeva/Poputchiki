package com.poputchiki.services;

import com.poputchiki.RequestContext;
import com.poputchiki.dto.home.MyTripListResponse;
import com.poputchiki.dto.home.NewTripListResponse;
import com.poputchiki.dto.join.TripListResponse;
import com.poputchiki.entities.Travel;
import com.poputchiki.errors.PoputchikiAppException;
import com.poputchiki.repositories.TravelRepository;
import com.poputchiki.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Component
public class SearchTripsService {

    private Logger log = LoggerFactory.getLogger(SearchPlaceService.class);

    private RequestContext requestContext;
    private TravelRepository travelRepository;
    private UserRepository userRepository;

    public SearchTripsService(RequestContext requestContext, TravelRepository travelRepository, UserRepository userRepository) {
        this.requestContext = requestContext;
        this.travelRepository = travelRepository;
        this.userRepository = userRepository;
    }

    public List<MyTripListResponse> getUserTrips(){
        List<Travel> travels = travelRepository.findByUserId(requestContext.getUserId());
        log.info("myTravels" + travels);
        List<MyTripListResponse> myTripListResponses = new ArrayList<>();
        for (Travel travel: travels) {
            myTripListResponses.add(new MyTripListResponse(travel.getDeparturePoint(),travel.getDestinationPoint(),travel.getDepartureDate(),travel.getDestinationDate()));
        }
        return myTripListResponses;
    }


    public List<NewTripListResponse> getNewTrips(Integer limit, Integer pages){
        List<Travel> travels = travelRepository.findAll();
        List<NewTripListResponse> newTripListResponses = new ArrayList<>();

        for (Travel travel: travels) {
            if(travel.getCreatedAt().compareTo(LocalDateTime.now().minusDays(5))>0){
                newTripListResponses.add(new NewTripListResponse(userRepository.findById(travel.getUserId()).orElseThrow(
                        ()-> new PoputchikiAppException("Something went wrong!")).getName(),
                        userRepository.findById(travel.getUserId()).orElseThrow(
                        ()-> new PoputchikiAppException("Something went wrong!")).getSurname(),
                        travel.getDeparturePoint(),travel.getDestinationPoint(),travel.getDepartureDate(),travel.getDestinationDate()));
            }
        }
        return newTripListResponses;
    }

    public List<TripListResponse> tripSearch(String fromTime,String toTime,String fromPoint, String toPoint,Integer limit, Integer pages){
        List<Travel> travels = travelRepository.findAll();
        List<TripListResponse> tripListResponses = new ArrayList<>();
        LocalDate startDate = LocalDate.parse(fromTime, DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate finishDate = LocalDate.parse(toTime, DateTimeFormatter.ISO_LOCAL_DATE);
        for (Travel travel: travels) {
            if(travel.getDepartureDate().equals(startDate) && travel.getDestinationDate().equals(finishDate) && travel.getDeparturePoint().equals(fromPoint) && travel.getDestinationPoint().equals(toPoint)){
                tripListResponses.add(new TripListResponse(userRepository.findById(travel.getUserId()).orElseThrow(
                        ()-> new PoputchikiAppException("Something went wrong!")).getName(),
                        userRepository.findById(travel.getUserId()).orElseThrow(
                                ()-> new PoputchikiAppException("Something went wrong!")).getSurname(),
                        travel.getDeparturePoint(),travel.getDestinationPoint(),travel.getDepartureDate(),travel.getDestinationDate()));
            }
        }


        return tripListResponses;
    }
}
