package com.poputchiki.controllers;

import com.poputchiki.dto.home.MyTripListResponse;
import com.poputchiki.dto.home.NewTripListResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class HomePageController {

    @GetMapping("/trips/my")
    public List<MyTripListResponse> GetUserTrips(){
        return Collections.emptyList();
    }

    @GetMapping("/trips?latest=true")
    public List<NewTripListResponse> GetNewTrips(){
        return Collections.emptyList();
    }



}
