package com.poputchiki.dto.registration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserToken {
    private String token;
    private String refreshToken;
}
