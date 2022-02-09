package com.poputchiki.controllers;

import com.poputchiki.constants.ApiConstants;
import com.poputchiki.dto.user.EditUserRequest;
import com.poputchiki.dto.user.UserInfoResponse;
import com.poputchiki.services.UserService;
import org.springframework.web.bind.annotation.*;

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
    public UserInfoResponse editInfo(@RequestBody EditUserRequest user){
        return userService.editInfo(user);
    }
}
