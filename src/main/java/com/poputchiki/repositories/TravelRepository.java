package com.poputchiki.repositories;

import com.poputchiki.entities.Travel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TravelRepository extends JpaRepository<Travel,Integer> {
    List<Travel> findByUserId(int userId);
}
