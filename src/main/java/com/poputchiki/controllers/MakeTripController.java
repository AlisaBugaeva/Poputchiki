package com.poputchiki.controllers;

import com.poputchiki.dto.make.trip.NewTripRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MakeTripController {
    @PostMapping("/trips")
    public void requestToRegister(@RequestBody NewTripRequest trip){

    }
}
