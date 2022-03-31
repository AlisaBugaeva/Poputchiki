package com.poputchiki.repositories;

import com.poputchiki.entities.Dialog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DialogRepository extends JpaRepository<Dialog,Integer> {

    Dialog findByPoputchikiId(int poputchikiId);
}
