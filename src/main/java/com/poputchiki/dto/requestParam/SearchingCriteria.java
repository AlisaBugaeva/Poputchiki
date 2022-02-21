package com.poputchiki.dto.requestParam;

import com.poputchiki.constants.ValidationConstants;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class SearchingCriteria {

    @NotNull(message = ValidationConstants.NOT_EMPTY)
    private String fromTime;

    @NotNull(message = ValidationConstants.NOT_EMPTY)
    private String toTime;

    @NotBlank(message = ValidationConstants.NOT_EMPTY)
    private String fromPoint;

    @NotBlank(message = ValidationConstants.NOT_EMPTY)
    private String toPoint;
}
