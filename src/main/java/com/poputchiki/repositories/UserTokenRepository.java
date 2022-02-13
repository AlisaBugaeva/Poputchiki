package com.poputchiki.repositories;

import com.poputchiki.entities.UserToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTokenRepository extends JpaRepository<UserToken,Integer> {
    UserToken findByAccessToken(String accessToken);
    UserToken findByRefreshToken(String refreshToken);
}
