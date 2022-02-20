package com.poputchiki.dto.requestParam;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LimitCriteria {

    private int limit = 10;
    private int page = 0;
}
