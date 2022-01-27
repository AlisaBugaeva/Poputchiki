package com.poputchiki.controllers;

import com.poputchiki.dto.home.MyTripListResponse;
import com.poputchiki.dto.home.NewTripListResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/trips")
public class HomePageController {

    @GetMapping("/my")
    public List<MyTripListResponse> GetUserTrips(){
        return Collections.emptyList();
    }

    @GetMapping
    public List<NewTripListResponse> GetNewTrips(@RequestParam("latest") Boolean latest){
        return Collections.emptyList();
    }



}
