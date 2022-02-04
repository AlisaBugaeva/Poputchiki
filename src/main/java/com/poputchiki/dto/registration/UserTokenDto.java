package com.poputchiki.dto.registration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserTokenDto {
    private String token;
    private String refreshToken;

    public UserTokenDto(String token, String refreshToken) {
        this.token = token;
        this.refreshToken = refreshToken;
    }
}
