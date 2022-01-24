package com.poputchiki.controllers;

import com.poputchiki.dto.join.TripListResponse;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class JoinTheTripController {

    @GetMapping("/trips?")
    public List<TripListResponse> tripSearch(){
        return Collections.emptyList();
    }

    @PostMapping("/trips/{TRIP_ID}")
    public void joinTheTrip(@PathVariable(value = "TRIP_ID") Integer id){

    }

}
