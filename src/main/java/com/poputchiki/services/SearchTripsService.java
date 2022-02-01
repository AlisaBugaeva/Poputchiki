package com.poputchiki.services;

import com.poputchiki.dto.home.MyTripListResponse;
import com.poputchiki.dto.home.NewTripListResponse;
import com.poputchiki.dto.join.TripListResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

@Component
public class SearchTripsService {

    public List<MyTripListResponse> getUserTrips(){
        return Collections.emptyList();
    }

    public List<NewTripListResponse> getNewTrips(Integer limit, Integer pages){
        return Collections.emptyList();
    }

    public List<TripListResponse> tripSearch(String fromTime,String toTime,String fromPoint, String toPoint,Integer limit, Integer pages){
        return Collections.emptyList();
    }
}
