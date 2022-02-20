package com.poputchiki.repositories;

import com.poputchiki.entities.Place;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends JpaRepository<Place,Integer> {
    List<Place> findByCityContainingIgnoreCase(String cityName);
    List<Place> findByCity(String cityName);
}
