package com.poputchiki.repositories;

import com.poputchiki.entities.Poputchik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoputchikRepository extends JpaRepository<Poputchik,Integer> {

}
