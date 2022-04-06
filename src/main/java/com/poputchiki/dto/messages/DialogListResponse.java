package com.poputchiki.dto.messages;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class DialogListResponse {
    private int id;
    private String name;
    private String surname;
    private  String departurePoint;
    private  String destinationPoint;
    private LocalDate departureDate;
    private LocalDate destinationDate;
    private String lastMessage;

    public DialogListResponse(int id, String name, String surname, String departurePoint, String destinationPoint, LocalDate departureDate, LocalDate destinationDate, String lastMessage) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.departurePoint = departurePoint;
        this.destinationPoint = destinationPoint;
        this.departureDate = departureDate;
        this.destinationDate = destinationDate;
        this.lastMessage = lastMessage;
    }
}
