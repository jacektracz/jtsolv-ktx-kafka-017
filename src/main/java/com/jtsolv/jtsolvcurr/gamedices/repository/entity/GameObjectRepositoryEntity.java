package com.jtsolv.jtsolvcurr.gamedices.repository.entity;

import com.jtsolv.jtsolvcurr.gamedices.model.entity.GameObjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameObjectRepositoryEntity extends JpaRepository<GameObjectEntity, Long>{}
