package com.poputchiki.dto.places;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlaceResponse {
    private String city;
    private String description;
    private String photo;

    public PlaceResponse(String city, String description, String photo) {
        this.city = city;
        this.description = description;
        this.photo = photo;
    }
}
