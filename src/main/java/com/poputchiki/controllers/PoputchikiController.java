package com.poputchiki.controllers;

import com.poputchiki.constants.ApiConstants;
import com.poputchiki.dto.join.TripListResponse;
import com.poputchiki.dto.poputchiki.AcceptedTravelRequestsResponse;
import com.poputchiki.dto.poputchiki.MyTravelRequestsResponse;
import com.poputchiki.dto.poputchiki.TravelRequestsResponse;
import com.poputchiki.services.PoputchikiService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiConstants.API_POPUTCHIKI_PATH)
public class PoputchikiController {

    PoputchikiService poputchikiService;

    public PoputchikiController(PoputchikiService poputchikiService) {
        this.poputchikiService = poputchikiService;
    }

    @GetMapping(ApiConstants.API_TRIP_ID_PATH+ ApiConstants.API_VIEW_TRIP_BY_ID_PATH)
    public List<TravelRequestsResponse> viewRequests(@PathVariable(value = "TRIP_ID") Integer id){
        return poputchikiService.viewRequests(id);
    }

    @PostMapping(ApiConstants.API_POPUTCHIK_ID_PATH + ApiConstants.API_TRIP_ID_PATH + ApiConstants.API_POPUTCHIKI_ACCEPT_PATH)
    public void acceptRequest(@PathVariable(value = "POPUTCHIK_ID") Integer idPoputchik, @PathVariable(value = "TRIP_ID") Integer idTravel){
        poputchikiService.acceptRequest(idPoputchik, idTravel);
    }

    @PostMapping(ApiConstants.API_POPUTCHIK_ID_PATH + ApiConstants.API_TRIP_ID_PATH + ApiConstants.API_POPUTCHIKI_REJECT_PATH)
    public void rejectRequest(@PathVariable(value = "POPUTCHIK_ID") Integer idPoputchik, @PathVariable(value = "TRIP_ID") Integer idTravel){
        poputchikiService.rejectRequest(idPoputchik, idTravel);
    }

    @GetMapping(ApiConstants.API_POPUTCHIK_REQUESTS_PATH)
    public List<MyTravelRequestsResponse> viewMyRequests(){
        return poputchikiService.viewMyRequests();
    }

    @GetMapping(ApiConstants.API_POPUTCHIK_ACCEPTED_REQUESTS_PATH)
    public List<AcceptedTravelRequestsResponse> viewAcceptedRequests(){
        return poputchikiService.viewAcceptedRequests();
    }


}
