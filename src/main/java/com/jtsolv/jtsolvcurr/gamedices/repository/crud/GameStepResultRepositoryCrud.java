package com.jtsolv.jtsolvcurr.gamedices.repository.crud;

import com.jtsolv.jtsolvcurr.gamedices.model.crud.GameStepResultCrud;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameStepResultRepositoryCrud extends CrudRepository<GameStepResultCrud, Long>{
	public List<GameStepResultCrud> findByGameStepDefId(Long gameStepResultId );
	
}
