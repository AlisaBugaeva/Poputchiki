package com.poputchiki.repositories;

import com.poputchiki.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessagesRepository extends JpaRepository<Message,Integer> {

    List<Message> findByDialogIdOrderByCreatedAt(int dialogId);

    int countByUserIdNotAndStatus(int userId,String status);

    @Query(value = "select * from( select *, dense_rank() over (order by created_at desc) as time_message from messages where dialog_id = :dialogId ) as l limit 1 ", nativeQuery = true)
    Message lastMessage(@Param("dialogId") int dialogId);
}
