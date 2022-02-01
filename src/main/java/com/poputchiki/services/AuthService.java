package com.poputchiki.services;

import com.poputchiki.dto.registration.LoginRequest;
import com.poputchiki.dto.registration.RegistrationRequest;
import com.poputchiki.dto.registration.UserToken;
import org.springframework.stereotype.Component;

@Component
public class AuthService {

    public UserToken requestToRegister(RegistrationRequest user){
        return null;
    }

    public UserToken requestToLogin(LoginRequest user){
        return null;
    }

    public UserToken token(String refreshToken){
        return null;
    }

    public void logout(){

    }
}
