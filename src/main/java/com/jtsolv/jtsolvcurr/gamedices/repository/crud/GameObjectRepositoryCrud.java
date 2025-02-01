package com.jtsolv.jtsolvcurr.gamedices.repository.crud;

import com.jtsolv.jtsolvcurr.gamedices.model.crud.GameObjectCrud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameObjectRepositoryCrud extends JpaRepository<GameObjectCrud, Long>{}
