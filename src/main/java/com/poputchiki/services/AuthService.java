package com.poputchiki.services;

import com.poputchiki.RequestContext;
import com.poputchiki.constants.ErrorMessages;
import com.poputchiki.dto.registration.LoginRequest;
import com.poputchiki.dto.registration.RegistrationRequest;
import com.poputchiki.dto.registration.UserTokenDto;
import com.poputchiki.entities.User;
import com.poputchiki.entities.UserToken;
import com.poputchiki.errors.PoputchikiAppException;
import com.poputchiki.repositories.UserRepository;
import com.poputchiki.repositories.UserTokenRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.UUID;

@Component
public class AuthService {

    private Logger log = LoggerFactory.getLogger(AuthService.class);

    private UserRepository userRepository;
    private UserTokenRepository userTokenRepository;
    private RequestContext requestContext;

    public AuthService(UserRepository userRepository, UserTokenRepository userTokenRepository, RequestContext requestContext) {
        this.userRepository = userRepository;
        this.userTokenRepository = userTokenRepository;
        this.requestContext = requestContext;
    }

    public UserTokenDto requestToRegister(RegistrationRequest user) throws PoputchikiAppException {
        if (userRepository.findByEmail(user.getEmail())==null){
            User newUser = new User();
            newUser.setName(user.getName());
            newUser.setSurname(user.getSurname());
            newUser.setPhoneNumber(user.getPhoneNumber());
            newUser.setEmail(user.getEmail());
            newUser.setPassword(user.getPassword());
            newUser.setCreatedAt(OffsetDateTime.now());
            newUser.setModifiedAt(OffsetDateTime.now());

            userRepository.save(newUser);

            return generateToken(newUser.getId());

        }
        else {
            log.error("An ERROR Message: User with this email is already exists");
            throw new PoputchikiAppException(ErrorMessages.USER_EXISTS);
        }
    }

    public UserTokenDto requestToLogin(LoginRequest user) throws PoputchikiAppException{
        if (userRepository.findByEmail(user.getEmail())==null){
            log.error("User with this email is not exists");
            throw new PoputchikiAppException(ErrorMessages.USER_NOT_EXISTS);
        }
        else if(!userRepository.findByEmail(user.getEmail()).getPassword().equals(user.getPassword())){
            log.error("Wrong password");
            throw new PoputchikiAppException(ErrorMessages.WRONG_PASSWORD);
        }
        else{
            User newUser = userRepository.findByEmail(user.getEmail());
            return generateToken(newUser.getId());
        }
    }

    public UserTokenDto token(String refreshToken){
        return null;
    }

    public void logout(){
        UserToken userToken = loginByToken(requestContext.getToken());
        userTokenRepository.delete(userToken);
    }



    public UserToken loginByToken(String token){
        return userTokenRepository.findByAccessToken(token);
    }

    public UserTokenDto generateToken(int UserId){
        String token = DigestUtils.sha256Hex(UUID.randomUUID().toString());
        String refreshToken = DigestUtils.sha256Hex(UUID.randomUUID().toString());

        UserToken userToken = new UserToken();
        userToken.setUserId(UserId);
        userToken.setAccessToken(token);
        userToken.setRefreshToken(refreshToken);
        userToken.setCreatedAt(OffsetDateTime.now());
        userToken.setExpiredAt(OffsetDateTime.now());

        userTokenRepository.save(userToken);
        return new UserTokenDto(token,refreshToken);

    }
}
