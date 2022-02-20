package com.poputchiki.controllers;

import com.poputchiki.constants.ApiConstants;
import com.poputchiki.dto.registration.LoginRequest;
import com.poputchiki.dto.registration.RegistrationRequest;
import com.poputchiki.dto.registration.UserTokenDto;
import com.poputchiki.services.AuthService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiConstants.API_AUTH_PATH)
public class AuthController {

    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(ApiConstants.API_AUTH_REGISTRATION_PATH)
    public UserTokenDto requestToRegister(@Valid @RequestBody RegistrationRequest user){
        return authService.requestToRegister(user);
    }

    @PostMapping(ApiConstants.API_AUTH_LOGIN_PATH)
    public UserTokenDto requestToLogin( @Valid @RequestBody LoginRequest user){
        return authService.requestToLogin(user);
    }

    @GetMapping(ApiConstants.API_AUTH_TOKEN_PATH)
    public UserTokenDto token(@RequestParam("refreshToken") String refreshToken){
        return authService.token(refreshToken);
    }

    @PostMapping(ApiConstants.API_AUTH_LOGOUT_PATH)
    public void logout(){
        authService.logout();
    }


}
