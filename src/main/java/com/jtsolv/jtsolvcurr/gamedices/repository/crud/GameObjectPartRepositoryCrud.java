package com.jtsolv.jtsolvcurr.gamedices.repository.crud;

import com.jtsolv.jtsolvcurr.gamedices.model.crud.GameObjectPartCrud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameObjectPartRepositoryCrud extends JpaRepository<GameObjectPartCrud, Long>{}
