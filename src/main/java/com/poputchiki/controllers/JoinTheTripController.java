package com.poputchiki.controllers;

import com.poputchiki.dto.join.TripListResponse;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/trips")
public class JoinTheTripController {

    @GetMapping("/search")
    public List<TripListResponse> tripSearch(@RequestParam("fromTime") OffsetDateTime fromTime,
                                             @RequestParam("toTime") OffsetDateTime toTime,
                                             @RequestParam("fromPoint") String fromPoint,
                                             @RequestParam("toPoint") String toPoint){
        return Collections.emptyList();
    }

    @PostMapping("/{TRIP_ID}/join")
    public void joinTheTrip(@PathVariable(value = "TRIP_ID") Integer id){

    }

}
