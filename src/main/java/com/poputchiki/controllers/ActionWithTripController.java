package com.poputchiki.controllers;

import com.poputchiki.dto.join.TripListResponse;
import com.poputchiki.dto.make.trip.NewTripRequest;
import com.poputchiki.services.ActionWithTripService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trips")
public class ActionWithTripController {

    private ActionWithTripService actionWithTripService;

    public ActionWithTripController(ActionWithTripService actionWithTripService) {
        this.actionWithTripService = actionWithTripService;
    }

    @PostMapping(path="/{TRIP_ID}/join")
    public void joinTheTrip(@PathVariable(value = "TRIP_ID") Integer id){
        actionWithTripService.joinTheTrip(id);
    }

    @PostMapping("/new")
    public void makeNewTrip(@RequestBody NewTripRequest trip){
        actionWithTripService.makeNewTrip(trip);
    }

    @GetMapping("/{TRIP_ID}/view")
    public TripListResponse viewTheTrip(@PathVariable(value = "TRIP_ID") Integer id){
        return actionWithTripService.viewTheTrip(id);
    }

    @DeleteMapping("/{TRIP_ID}/delete")
    public void deleteTheTrip(@PathVariable(value = "TRIP_ID") Integer id){
        actionWithTripService.deleteTheTrip(id);
    }

}
