package com.poputchiki.dto.registration;

import com.poputchiki.constants.ValidationConstants;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class LoginRequest {

    @NotBlank(message = ValidationConstants.NOT_EMPTY)
    @Email(message = ValidationConstants.EMAIL)
    private String email;

    @NotBlank(message = ValidationConstants.NOT_EMPTY)
    private String password;
}
