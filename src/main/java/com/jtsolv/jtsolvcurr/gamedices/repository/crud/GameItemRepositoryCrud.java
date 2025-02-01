package com.jtsolv.jtsolvcurr.gamedices.repository.crud;

import com.jtsolv.jtsolvcurr.gamedices.model.crud.GameItemCrud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameItemRepositoryCrud extends JpaRepository<GameItemCrud, Long>{}
