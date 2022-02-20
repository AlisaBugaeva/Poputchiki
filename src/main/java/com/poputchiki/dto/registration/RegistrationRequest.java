package com.poputchiki.dto.registration;

import com.poputchiki.constants.ValidationConstants;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class RegistrationRequest {

    @NotBlank(message = ValidationConstants.NOT_EMPTY)
    private String name;

    @NotBlank(message = ValidationConstants.NOT_EMPTY)
    private String surname;


    private String phoneNumber;

    @NotBlank(message = ValidationConstants.NOT_EMPTY)
    @Email(message = ValidationConstants.EMAIL)
    private String email;

    @NotBlank(message = ValidationConstants.NOT_EMPTY)
    private String password;
}
