package com.poputchiki.repositories;

import com.poputchiki.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessagesRepository extends JpaRepository<Message,Integer> {

    List<Message> findByDialogId(int dialogId);

    int countByUserIdAndStatusEquals(int userId,String status);
}
