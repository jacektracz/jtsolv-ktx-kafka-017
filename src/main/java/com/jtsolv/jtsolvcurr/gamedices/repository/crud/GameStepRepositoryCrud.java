package com.jtsolv.jtsolvcurr.gamedices.repository.crud;

import com.jtsolv.jtsolvcurr.gamedices.model.crud.GameStepCrud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameStepRepositoryCrud extends JpaRepository<GameStepCrud, Long>{
	List<GameStepCrud> findByGameStepDefId(Long pvalue );
	
}
