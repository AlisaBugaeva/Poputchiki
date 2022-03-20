package com.poputchiki.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfoResponse {
    private int id;
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    private String password;
}
