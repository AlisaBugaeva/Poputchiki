package com.poputchiki.dto.registration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationRequest {
    private String name;
    private String surname;
    private String telephone;
    private String email;
    private String password;
}
