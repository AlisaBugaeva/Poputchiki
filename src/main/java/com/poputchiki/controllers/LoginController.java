package com.poputchiki.controllers;

import com.poputchiki.dto.registration.LoginRequest;
import com.poputchiki.dto.registration.RefreshToken;
import com.poputchiki.dto.registration.RegistrationRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class LoginController {

    @PostMapping("/user/registration")
    public RefreshToken requestToRegister(@RequestBody RegistrationRequest user){
        return null;
    }

    @PostMapping("/user/login")
    public RefreshToken requestToLogin(@RequestBody LoginRequest user){
        return null;
    }






}
