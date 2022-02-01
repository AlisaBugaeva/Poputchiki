package com.poputchiki.controllers;

import com.poputchiki.dto.registration.LoginRequest;
import com.poputchiki.dto.registration.RegistrationRequest;
import com.poputchiki.dto.registration.UserToken;
import com.poputchiki.services.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/registration")
    public UserToken requestToRegister(@RequestBody RegistrationRequest user){
        return authService.requestToRegister(user);
    }

    @PostMapping("/login")
    public UserToken requestToLogin(@RequestBody LoginRequest user){
        return authService.requestToLogin(user);
    }

    @GetMapping("/token")
    public UserToken token(@RequestParam("refreshToken") String refreshToken){
        return authService.token(refreshToken);
    }

    @PostMapping("/logout")
    public void logout(){
        authService.logout();
    }


}
