package com.poputchiki.dto.home;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Date;

@Getter
@Setter
public class MyTripListResponse {
    private String start;
    private String finish;
    private LocalDate startDate;
    private LocalDate finishDate;

    public MyTripListResponse(String start, String finish, LocalDate startDate, LocalDate finishDate) {
        this.start = start;
        this.finish = finish;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }
}
