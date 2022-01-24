package com.poputchiki.controllers;

import com.poputchiki.dto.registration.RefreshToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rest")
public class TokenController {
    @GetMapping("/token?refreshToken={refreshToken}")
    public RefreshToken token(){
        return null;
    }
}
