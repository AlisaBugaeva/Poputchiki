package com.poputchiki.dto.requestParam;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchingCriteria {
    private String fromTime;
    private String toTime;
    private String fromPoint;
    private String toPoint;
}
