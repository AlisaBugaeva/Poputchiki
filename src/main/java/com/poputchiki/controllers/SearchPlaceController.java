package com.poputchiki.controllers;

import com.poputchiki.constants.ApiConstants;
import com.poputchiki.dto.places.PlaceResponse;
import com.poputchiki.dto.requestParam.LimitCriteria;
import com.poputchiki.services.SearchPlaceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(ApiConstants.API_PLACES_PATH)
public class SearchPlaceController {

    private SearchPlaceService searchPlaceService;

    public SearchPlaceController(SearchPlaceService searchPlaceService) {
        this.searchPlaceService = searchPlaceService;
    }

    @GetMapping(params="limit")
    public List<PlaceResponse> getTopPlaces(LimitCriteria limitCriteria){
        return searchPlaceService.getTopPlaces(limitCriteria);
    }

    @GetMapping(params="name")
    public List<PlaceResponse> getPlaces(@RequestParam("name") String name){
        return searchPlaceService.getPlaces(name);
    }

}
