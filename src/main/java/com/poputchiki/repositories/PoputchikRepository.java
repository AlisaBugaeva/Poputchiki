package com.poputchiki.repositories;

import com.poputchiki.constants.ApiConstants;
import com.poputchiki.constants.PopitchikiStatus;
import com.poputchiki.entities.Poputchik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface PoputchikRepository extends JpaRepository<Poputchik,Integer> {
    List<Poputchik> findByPoputchikIdAndAndTravelId(int poputchikId, int travelId );

    int countPoputchikByTravelIdAndStatusEquals(int travelId, String status);

    List<Poputchik> findByTravelId(int travelId);

    List<Poputchik> findByPoputchikId(int myId);


    @Query(value = "select p.* from users u_p join poputchiki p on u_p.id = p.poputchik_id join travels t on t.id = p.travel_id where t.user_id = :myId", nativeQuery = true)
    List<Poputchik> userRequests(@Param("myId") int myId);

    @Query(value = "select p.* from dialogs d join poputchiki p on p.id = d.poputchiki_id join travels t on t.id = p.travel_id where t.user_id = :myId or p.poputchik_id = :myId order by d.created_at desc", nativeQuery = true)
    List<Poputchik> viewAllDialogs(@Param("myId") int myId);



}
