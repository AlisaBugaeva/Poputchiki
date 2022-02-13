package com.poputchiki.dto.make.trip;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Date;

@Getter
@Setter
public class NewTripRequest {
    private String start;
    private String finish;
    private LocalDate startDate;
    private LocalDate finishDate;
}
