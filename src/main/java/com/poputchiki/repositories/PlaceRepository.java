package com.poputchiki.repositories;

import com.poputchiki.entities.Place;
import com.poputchiki.entities.Poputchik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends JpaRepository<Place,Integer> {
    List<Place> findByCityContainingIgnoreCase(String cityName);
    List<Place> findByCity(String cityName);

    @Query(value = "select p.*, count(*) as count, dense_rank() over (order by count(*) desc) as top from travels t right join places p on p.city = t.destination_point group by t.destination_point, p.id", nativeQuery = true)
    List<Place> topOfCities();
}

