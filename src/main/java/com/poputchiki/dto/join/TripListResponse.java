package com.poputchiki.dto.join;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.Date;

@Getter
@Setter
public class TripListResponse {

    private String name;
    private String surname;
    private String start;
    private String finish;
    private OffsetDateTime startDate;
    private OffsetDateTime finishDate;

}
