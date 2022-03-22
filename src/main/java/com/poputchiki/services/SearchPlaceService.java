package com.poputchiki.services;

import com.poputchiki.dto.places.PlaceResponse;
import com.poputchiki.dto.requestParam.LimitCriteria;
import com.poputchiki.entities.Place;
import com.poputchiki.repositories.PlaceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SearchPlaceService {

    private Logger log = LoggerFactory.getLogger(SearchPlaceService.class);

    private PlaceRepository placeRepository;

    public SearchPlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public List<PlaceResponse> getTopPlaces(LimitCriteria limitCriteria){
        Pageable page = PageRequest.of(limitCriteria.getPage(), limitCriteria.getLimit());
        List<Place> places = placeRepository.topOfCities();
        List<PlaceResponse> placeResponses = new ArrayList<>();
        for (Place place: places) {
            placeResponses.add(new PlaceResponse(place.getCity(),place.getDescription(),place.getPhoto()));
        }
        return placeResponses;
    }

    public List<PlaceResponse> getPlaces(String name){
        List<Place> places = placeRepository.findByCityContainingIgnoreCase(name);
        log.info("places: " + places);
        List<PlaceResponse> placeResponses = new ArrayList<>();
        for (Place place: places) {
            placeResponses.add(new PlaceResponse(place.getCity(),place.getDescription(),place.getPhoto()));
        }

        return placeResponses;
    }
}
