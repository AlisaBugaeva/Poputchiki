package com.poputchiki.controllers;

import com.poputchiki.constants.ApiConstants;
import com.poputchiki.dto.home.MyTripListResponse;
import com.poputchiki.dto.home.NewTripListResponse;
import com.poputchiki.dto.join.TripListResponse;
import com.poputchiki.dto.requestParam.LimitCriteria;
import com.poputchiki.dto.requestParam.SearchingCriteria;
import com.poputchiki.services.SearchTripsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(ApiConstants.API_TRIPS_PATH)
public class SearchTripsController {

    private SearchTripsService searchTripsService;

    public SearchTripsController(SearchTripsService searchTripsService) {
        this.searchTripsService = searchTripsService;
    }

    @GetMapping(ApiConstants.API_TRIPS_MINE_PATH)
    public List<MyTripListResponse> getUserTrips(){
        return searchTripsService.getUserTrips();
    }

    @GetMapping(ApiConstants.API_TRIPS_LAST_PATH)
    public List<NewTripListResponse> getNewTrips(LimitCriteria limitCriteria ){
        return searchTripsService.getNewTrips(limitCriteria);
    }

    @GetMapping(ApiConstants.API_TRIPS_SEARCH_PATH)
    public List<TripListResponse> tripSearch(@Valid SearchingCriteria searchingCriteria, LimitCriteria limitCriteria ){
        return searchTripsService.tripSearch(searchingCriteria,limitCriteria);
    }
}
