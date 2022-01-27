package com.poputchiki.controllers;

import com.poputchiki.dto.registration.LoginRequest;
import com.poputchiki.dto.registration.UserToken;
import com.poputchiki.dto.registration.RegistrationRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class LoginController {

    @PostMapping("/registration")
    public UserToken requestToRegister(@RequestBody RegistrationRequest user){
        return null;
    }

    @PostMapping("/login")
    public UserToken requestToLogin(@RequestBody LoginRequest user){
        return null;
    }






}
