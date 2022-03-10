package com.poputchiki.services;

import com.poputchiki.RequestContext;
import com.poputchiki.constants.ErrorMessages;
import com.poputchiki.dto.home.MyTripListResponse;
import com.poputchiki.dto.home.NewTripListResponse;
import com.poputchiki.dto.join.TripListResponse;
import com.poputchiki.dto.requestParam.LimitCriteria;
import com.poputchiki.dto.requestParam.SearchingCriteria;
import com.poputchiki.entities.Travel;
import com.poputchiki.errors.PoputchikiAppException;
import com.poputchiki.repositories.TravelRepository;
import com.poputchiki.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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


    public List<NewTripListResponse> getNewTrips(LimitCriteria limitCriteria){
        Pageable page = PageRequest.of(limitCriteria.getPage(), limitCriteria.getLimit());
        LocalDateTime date = LocalDateTime.now().minusDays(50);
        List<Travel> travels =travelRepository.findByCreatedAtGreaterThan(date,page);
        List<NewTripListResponse> newTripListResponses = new ArrayList<>();

        for (Travel travel: travels) {
                newTripListResponses.add(new NewTripListResponse(travel.getUser().getName(),travel.getUser().getSurname(),
                        travel.getDeparturePoint(),travel.getDestinationPoint(),travel.getDepartureDate(),travel.getDestinationDate()));
        }
        return newTripListResponses;
    }

    public List<TripListResponse> tripSearch(SearchingCriteria searchingCriteria, LimitCriteria limitCriteria){
        Pageable page = PageRequest.of(limitCriteria.getPage(), limitCriteria.getLimit());
        LocalDate startDate = LocalDate.parse(searchingCriteria.getFromTime(), DateTimeFormatter.ISO_LOCAL_DATE);
        List<Travel> travels = travelRepository.findByDepartureDateAndDeparturePointAndDestinationPoint
                (startDate, searchingCriteria.getFromPoint(), searchingCriteria.getToPoint(), page);

        List<TripListResponse> tripListResponses = new ArrayList<>();
        for (Travel travel: travels) {
                tripListResponses.add(new TripListResponse(travel.getUser().getName(),travel.getUser().getSurname(),
                        travel.getDeparturePoint(),travel.getDestinationPoint(),travel.getDepartureDate(),travel.getDestinationDate()));
        }

        return tripListResponses;
    }
}
