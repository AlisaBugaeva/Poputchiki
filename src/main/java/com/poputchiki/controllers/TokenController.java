package com.poputchiki.controllers;

import com.poputchiki.dto.registration.UserToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TokenController {
    @GetMapping("/token")
    public UserToken token(@RequestParam("refreshToken") String refreshToken){
        return null;
    }
}
