package com.poputchiki.dto.poputchiki;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TravelRequestsResponse {
    private int id;
    private String name;
    private String surname;

    public TravelRequestsResponse(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }
}
