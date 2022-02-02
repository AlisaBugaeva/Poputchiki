package com.poputchiki.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditUserRequest {
    private String name;
    private String surname;
    private String phoneNumber;
}
