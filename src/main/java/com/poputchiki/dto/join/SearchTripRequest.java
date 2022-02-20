package com.poputchiki.dto.join;

import com.poputchiki.constants.ValidationConstants;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Date;

@Getter
@Setter
public class SearchTripRequest {

    @NotBlank(message = ValidationConstants.NOT_EMPTY)
    private String start;

    @NotBlank(message = ValidationConstants.NOT_EMPTY)
    private String finish;

    @NotBlank(message = ValidationConstants.NOT_EMPTY)
    private LocalDate startDate;

    @NotBlank(message = ValidationConstants.NOT_EMPTY)
    private LocalDate finishDate;

}
