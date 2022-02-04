package com.poputchiki.services;

import com.poputchiki.dto.registration.LoginRequest;
import com.poputchiki.dto.registration.RegistrationRequest;
import com.poputchiki.dto.registration.UserTokenDto;
import com.poputchiki.entities.User;
import com.poputchiki.entities.UserToken;
import com.poputchiki.errors.PoputchikiAppException;
import com.poputchiki.repositories.UserRepository;
import com.poputchiki.repositories.UserTokenRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.UUID;

@Component
public class AuthService {

    private UserRepository userRepository;
    private UserTokenRepository userTokenRepository;

    public AuthService(UserRepository userRepository, UserTokenRepository userTokenRepository) {
        this.userRepository = userRepository;
        this.userTokenRepository = userTokenRepository;
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

            String token = DigestUtils.sha256Hex(UUID.randomUUID().toString());
            String refreshToken = DigestUtils.sha256Hex(UUID.randomUUID().toString());

            UserToken userToken = new UserToken();
            userToken.setUserId(newUser.getId());
            userToken.setAccessToken(token);
            userToken.setRefreshToken(refreshToken);
            userToken.setCreatedAt(OffsetDateTime.now());
            userToken.setExpiredAt(OffsetDateTime.now());

            userTokenRepository.save(userToken);
            return new UserTokenDto(token,refreshToken);

        }
        else throw new PoputchikiAppException("User with this email is already exists");
    }

    public UserTokenDto requestToLogin(LoginRequest user) throws PoputchikiAppException{
        if (userRepository.findByEmail(user.getEmail())==null){
            throw new PoputchikiAppException("User with this email is not exists");
        }
        else if(!userRepository.findByEmail(user.getEmail()).getPassword().equals(user.getPassword())){
            throw new PoputchikiAppException("Wrong password");
        }
        else{
            User newUser = userRepository.findByEmail(user.getEmail());

            String token = DigestUtils.sha256Hex(UUID.randomUUID().toString());
            String refreshToken = DigestUtils.sha256Hex(UUID.randomUUID().toString());
            UserToken userToken = new UserToken();
            userToken.setUserId(newUser.getId());
            userToken.setAccessToken(token);
            userToken.setRefreshToken(refreshToken);
            userTokenRepository.save(userToken);
            return new UserTokenDto(token,refreshToken);
        }
    }

    public UserTokenDto token(String refreshToken){
        return null;
    }

    public void logout(){

    }
}
