package com.poputchiki.controllers;

import com.poputchiki.constants.ApiConstants;
import com.poputchiki.dto.user.UserInfoResponse;
import com.poputchiki.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiConstants.API_USER_PATH)
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(ApiConstants.API_USER_INFO_PATH)
    public UserInfoResponse getInfo(){
        return userService.getInfo();
    }

    @PatchMapping(ApiConstants.API_USER_EDIT_PATH)
    public UserInfoResponse editInfo(){
        return userService.editInfo();
    }
}
