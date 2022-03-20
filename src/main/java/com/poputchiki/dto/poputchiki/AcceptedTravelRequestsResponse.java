package com.poputchiki.dto.poputchiki;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AcceptedTravelRequestsResponse {

    private String name;
    private String surname;
    private String email;
    private  String departurePoint;
    private  String destinationPoint;
    private LocalDate departureDate;
    private LocalDate destinationDate;

    public AcceptedTravelRequestsResponse(String name, String surname, String email, String departurePoint, String destinationPoint, LocalDate departureDate, LocalDate destinationDate) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.departurePoint = departurePoint;
        this.destinationPoint = destinationPoint;
        this.departureDate = departureDate;
        this.destinationDate = destinationDate;
    }
}
