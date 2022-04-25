package com.poputchiki.services;

import com.poputchiki.RequestContext;
import com.poputchiki.constants.ErrorMessages;
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
        User user = userRepository.findById(requestContext.getUserId()).orElseThrow(
                ()-> new PoputchikiAppException(ErrorMessages.UNKNOWN_ERROR)
        );
        userInfoResponse.setId(user.getId());
        userInfoResponse.setName(user.getName());
        userInfoResponse.setSurname(user.getSurname());
        userInfoResponse.setPhoneNumber(user.getPhoneNumber());
        userInfoResponse.setEmail(user.getEmail());

        return userInfoResponse;
    }

    public UserInfoResponse editInfo(EditUserRequest user){
        UserInfoResponse userInfoResponse= new UserInfoResponse();
        User editedUser = userRepository.findById(requestContext.getUserId()).orElseThrow(
                ()-> new PoputchikiAppException(ErrorMessages.UNKNOWN_ERROR)
        );

        editedUser.setName(user.getName());
        editedUser.setSurname(user.getSurname());
        editedUser.setPhoneNumber(user.getPhoneNumber());
        userRepository.save(editedUser);

        userInfoResponse.setName(editedUser.getName());
        userInfoResponse.setSurname(editedUser.getSurname());
        userInfoResponse.setPhoneNumber(editedUser.getPhoneNumber());
        userInfoResponse.setEmail(editedUser.getEmail());
        userInfoResponse.setId(editedUser.getId());
        userInfoResponse.setPassword(editedUser.getPassword());

        return userInfoResponse;
    }
}
