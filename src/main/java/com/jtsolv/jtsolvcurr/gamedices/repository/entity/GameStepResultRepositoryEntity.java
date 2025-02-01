package com.jtsolv.jtsolvcurr.gamedices.repository.entity;

import com.jtsolv.jtsolvcurr.gamedices.model.entity.GameStepResultEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameStepResultRepositoryEntity extends JpaRepository<GameStepResultEntity, Long>{}
