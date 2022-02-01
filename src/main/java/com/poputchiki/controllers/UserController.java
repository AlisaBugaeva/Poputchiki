package com.poputchiki.controllers;

import com.poputchiki.dto.user.UserInfoResponse;
import com.poputchiki.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/info")
    public UserInfoResponse getInfo(){
        return userService.getInfo();
    }

    @PatchMapping("/edit")
    public void editInfo(){

    }
}
