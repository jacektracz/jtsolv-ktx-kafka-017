package com.jtsolv.jtsolvcurr.gamedices.repository.crud;

import com.jtsolv.jtsolvcurr.gamedices.model.crud.GameItemResultCrud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameItemResultRepositoryCrud extends JpaRepository<GameItemResultCrud, Long>{
	
	@Modifying
	@Query("DELETE FROM GameItemResultCrud bi WHERE bi.gameStepResultId = :gameStepResultId")
	void deleteByGameStepResultId(final Long gameStepResultId);
	
	public List<GameItemResultCrud> findByGameStepResultId(Long gameStepResultId );
	public List<GameItemResultCrud> findByGameStepDefId(Long gameStepDefId );
	
	
}
