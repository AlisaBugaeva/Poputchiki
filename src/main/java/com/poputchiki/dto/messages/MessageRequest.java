package com.poputchiki.dto.messages;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.poputchiki.constants.ValidationConstants;
import lombok.Getter;
import lombok.Setter;
import org.springframework.messaging.handler.annotation.Payload;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown=true)
public class MessageRequest {

    int idPoputchik;

    @NotBlank(message = ValidationConstants.NOT_EMPTY)
    private String text;

    int userId;


}
