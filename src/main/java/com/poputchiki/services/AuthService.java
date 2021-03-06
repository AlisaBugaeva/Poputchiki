package com.poputchiki.services;

import com.poputchiki.RequestContext;
import com.poputchiki.constants.ErrorMessages;
import com.poputchiki.constants.PoputchikiProperties;
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
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class AuthService {

    private Logger log = LoggerFactory.getLogger(AuthService.class);

    private UserRepository userRepository;
    private UserTokenRepository userTokenRepository;
    private RequestContext requestContext;
    private PoputchikiProperties poputchikiProperties;

    public AuthService(UserRepository userRepository, UserTokenRepository userTokenRepository, RequestContext requestContext, PoputchikiProperties poputchikiProperties) {
        this.userRepository = userRepository;
        this.userTokenRepository = userTokenRepository;
        this.requestContext = requestContext;
        this.poputchikiProperties = poputchikiProperties;
    }


    public UserTokenDto requestToRegister(RegistrationRequest user) throws PoputchikiAppException {
        if (userRepository.findByEmail(user.getEmail())==null){
            User newUser = new User();
            newUser.setName(user.getName());
            newUser.setSurname(user.getSurname());
            newUser.setPhoneNumber(user.getPhoneNumber());
            newUser.setEmail(user.getEmail());
            newUser.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
            newUser.setCreatedAt(LocalDateTime.now());
            newUser.setModifiedAt(LocalDateTime.now());

            userRepository.save(newUser);

            return generateToken(newUser.getId());

        }
        else {
            log.error("An ERROR Message: User with this email is already exists");
            throw new PoputchikiAppException(ErrorMessages.USER_EXISTS);
        }
    }

    public UserTokenDto requestToLogin(LoginRequest user) throws PoputchikiAppException{
        User newUser = userRepository.findByEmail(user.getEmail());
        if (newUser==null){
            log.error("User with this email is not exists");
            throw new PoputchikiAppException(ErrorMessages.USER_NOT_EXISTS);
        }
        else if(!BCrypt.checkpw(user.getPassword(), newUser.getPassword())){
            log.error("Wrong password");
            throw new PoputchikiAppException(ErrorMessages.WRONG_PASSWORD);
        }
        else{
            return generateToken(newUser.getId());
        }
    }

    public UserTokenDto token(String refreshToken){
        UserToken userToken = userTokenRepository.findByRefreshToken(refreshToken);
        log.info("user token " + userToken);
        int userId = requestContext.getUserId();
        userTokenRepository.delete(userToken);
        return generateToken(userId);
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

        if(userTokenRepository.findByUserId(UserId).isEmpty()) {
            userToken.setUserId(UserId);
            userToken.setAccessToken(token);
            userToken.setRefreshToken(refreshToken);
            userToken.setCreatedAt(LocalDateTime.now());
            userToken.setExpiredAt(LocalDateTime.now().plusHours(poputchikiProperties.getExpire()));
            log.info("expire: " + poputchikiProperties.getExpire());
        }
        else{
            userToken = userTokenRepository.findByUserId(UserId).get(0);
            userToken.setUserId(UserId);
            userToken.setAccessToken(token);
            userToken.setRefreshToken(refreshToken);
            userToken.setCreatedAt(LocalDateTime.now());
            userToken.setExpiredAt(LocalDateTime.now().plusHours(poputchikiProperties.getExpire()));
        }


        userTokenRepository.save(userToken);
        return new UserTokenDto(token,refreshToken);

    }
}
