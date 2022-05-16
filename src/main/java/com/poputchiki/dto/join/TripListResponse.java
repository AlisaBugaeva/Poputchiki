package com.poputchiki.dto.join;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Date;

@Getter
@Setter
public class TripListResponse {
    private int id;
    private int userId;
    private String name;
    private String surname;
    private String start;
    private String finish;
    private LocalDate startDate;
    private LocalDate finishDate;

    public TripListResponse(String name, String surname, String start, String finish, LocalDate startDate, LocalDate finishDate, int id, int userId) {
        this.name = name;
        this.surname = surname;
        this.start = start;
        this.finish = finish;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.id = id;
        this.userId=userId;
    }
}
