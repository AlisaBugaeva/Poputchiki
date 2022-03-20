package com.poputchiki.dto.poputchiki;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class MyTravelRequestsResponse {

    private int id;
    private String name;
    private String surname;
    private String email;
    private  String departurePoint;
    private  String destinationPoint;
    private LocalDate departureDate;
    private LocalDate destinationDate;
    private String status;

    public MyTravelRequestsResponse(int id, String name, String surname, String email, String departurePoint, String destinationPoint, LocalDate departureDate, LocalDate destinationDate, String status) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.departurePoint = departurePoint;
        this.destinationPoint = destinationPoint;
        this.departureDate = departureDate;
        this.destinationDate = destinationDate;
        this.status = status;
    }
}
