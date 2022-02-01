package com.poputchiki.services;

import com.poputchiki.dto.join.TripListResponse;
import com.poputchiki.dto.make.trip.NewTripRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;


@Component
public class ActionWithTripService {

    public void joinTheTrip(Integer id){

    }

    public void makeNewTrip( NewTripRequest trip){

    }

    public TripListResponse viewTheTrip( Integer id){
        return null;
    }

    public void deleteTheTrip(Integer id){

    }
}
