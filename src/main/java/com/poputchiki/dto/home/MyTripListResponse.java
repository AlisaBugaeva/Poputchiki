package com.poputchiki.dto.home;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.Date;

@Getter
@Setter
public class MyTripListResponse {
    private String start;
    private String finish;
    private OffsetDateTime startDate;
    private OffsetDateTime finishDate;
}
