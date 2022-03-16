package com.poputchiki.repositories;

import com.poputchiki.entities.UserToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserTokenRepository extends JpaRepository<UserToken,Integer> {
    UserToken findByAccessToken(String accessToken);
    UserToken findByRefreshToken(String refreshToken);
    ArrayList<UserToken> findByUserId(int userId);
}
