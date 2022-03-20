package com.poputchiki.repositories;

import com.poputchiki.entities.Travel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TravelRepository extends JpaRepository<Travel,Integer> {
    List<Travel> findByUserId(int userId);
    List<Travel> findByCreatedAtGreaterThanAndStatusEquals(LocalDateTime date, String status,Pageable pageable);
    List<Travel> findByDepartureDateAndDeparturePointAndDestinationPoint
            (LocalDate fromTime, String fromPoint, String toPoint, Pageable pageable);
}
