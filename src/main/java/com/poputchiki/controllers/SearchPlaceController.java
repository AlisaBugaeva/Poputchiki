package com.poputchiki.controllers;

import com.poputchiki.dto.places.PlaceResponse;
import com.poputchiki.services.SearchPlaceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/places")
public class SearchPlaceController {

    private SearchPlaceService searchPlaceService;

    public SearchPlaceController(SearchPlaceService searchPlaceService) {
        this.searchPlaceService = searchPlaceService;
    }

    @GetMapping(params="limit")
    public List<PlaceResponse> getTopPlaces(@RequestParam("limit") Integer limit,
                                            @RequestParam("pages") Integer pages){
        return searchPlaceService.getTopPlaces(limit,pages);
    }

    @GetMapping(params="name")
    public List<PlaceResponse> getPlaces(@RequestParam("name") String name){
        return searchPlaceService.getPlaces(name);
    }

}
