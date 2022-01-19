package com.poputchiki.dto.join;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SearchTripRequest {
    private String start;
    private String finish;
    private Date startDate;
    private Date finishDate;

}
