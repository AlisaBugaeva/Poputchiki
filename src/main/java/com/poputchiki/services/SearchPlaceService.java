package com.poputchiki.services;

import com.poputchiki.dto.places.PlaceResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

@Component
public class SearchPlaceService {

    public List<PlaceResponse> getTopPlaces(Integer limit, Integer pages){
        return Collections.emptyList();
    }

    public List<PlaceResponse> getPlaces(String name){
        return Collections.emptyList();
    }
}
