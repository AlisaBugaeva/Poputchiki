package com.poputchiki.controllers;

import com.poputchiki.constants.ApiConstants;
import com.poputchiki.dto.home.MyTripListResponse;
import com.poputchiki.dto.home.NewTripListResponse;
import com.poputchiki.dto.join.TripListResponse;
import com.poputchiki.services.SearchTripsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(ApiConstants.API_TRIPS_PATH)
public class SearchTripsController {

    private SearchTripsService searchTripsService;

    public SearchTripsController(SearchTripsService searchTripsService) {
        this.searchTripsService = searchTripsService;
    }

    @GetMapping(params = ApiConstants.API_TRIPS_MINE_PATH)
    public List<MyTripListResponse> getUserTrips(){
        return searchTripsService.getUserTrips();
    }

    @GetMapping(params=ApiConstants.API_TRIPS_LAST_PATH)
    public List<NewTripListResponse> getNewTrips(@RequestParam("limit") Integer limit,
                                                 @RequestParam("pages") Integer pages ){
        return searchTripsService.getNewTrips(limit,pages);
    }

    @GetMapping(params="fromTime")
    public List<TripListResponse> tripSearch(@RequestParam("fromTime") String fromTime,
                                             @RequestParam("toTime") String toTime,
                                             @RequestParam("fromPoint") String fromPoint,
                                             @RequestParam("toPoint") String toPoint,
                                             @RequestParam("limit") Integer limit,
                                             @RequestParam("pages") Integer pages ){
        return searchTripsService.tripSearch(fromTime,toTime,fromPoint,toPoint,limit,pages);
    }
}
