package com.poputchiki.services;

import com.poputchiki.RequestContext;
import com.poputchiki.dto.user.EditUserRequest;
import com.poputchiki.dto.user.UserInfoResponse;
import com.poputchiki.entities.User;
import com.poputchiki.errors.PoputchikiAppException;
import com.poputchiki.repositories.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    private RequestContext requestContext;
    private UserRepository userRepository;

    public UserService(RequestContext requestContext, UserRepository userRepository) {
        this.requestContext = requestContext;
        this.userRepository = userRepository;
    }

    public UserInfoResponse getInfo(){
        UserInfoResponse userInfoResponse= new UserInfoResponse();
        User user = userRepository.getById(requestContext.getUserId());
        userInfoResponse.setName(user.getName());
        userInfoResponse.setSurname(user.getSurname());
        userInfoResponse.setPhoneNumber(user.getPhoneNumber());
        userInfoResponse.setEmail(user.getEmail());

        return userInfoResponse;
    }

    public UserInfoResponse editInfo(EditUserRequest user){
        UserInfoResponse userInfoResponse= new UserInfoResponse();
        User editedUser = userRepository.findById(requestContext.getUserId()).orElseThrow(
                ()-> new PoputchikiAppException("Something went wrong!")
        );

        editedUser.setName(user.getName());
        editedUser.setSurname(user.getSurname());
        editedUser.setPhoneNumber(user.getPhoneNumber());
        userRepository.save(editedUser);

        userInfoResponse.setName(editedUser.getName());
        userInfoResponse.setSurname(editedUser.getSurname());
        userInfoResponse.setPhoneNumber(editedUser.getPhoneNumber());
        userInfoResponse.setEmail(editedUser.getEmail());

        return userInfoResponse;
    }
}
