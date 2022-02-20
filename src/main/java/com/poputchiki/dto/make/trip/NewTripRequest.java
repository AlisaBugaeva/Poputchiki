package com.poputchiki.dto.make.trip;

import com.poputchiki.constants.ValidationConstants;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Getter
@Setter
public class NewTripRequest {

    @NotBlank(message = ValidationConstants.NOT_EMPTY)
    private String start;

    @NotBlank(message = ValidationConstants.NOT_EMPTY)
    private String finish;

    @NotNull(message = ValidationConstants.NOT_EMPTY)
    private LocalDate startDate;

    @NotNull(message = ValidationConstants.NOT_EMPTY)
    private LocalDate finishDate;
}
