package com.jtsolv.jtsolvcurr.gamedices.service.game;

import com.jtsolv.jtsolvcurr.gamedices.repository.crud.*;
import com.jtsolv.jtsolvcurr.logging.JTSolvGenericLogger;
import com.jtsolv.jtsolvcurr.gamedices.engine.DiceRollEngine;
import com.jtsolv.jtsolvcurr.gamedices.model.crud.GameItemResultCrud;
import com.jtsolv.jtsolvcurr.gamedices.model.crud.GameStepCrud;
import com.jtsolv.jtsolvcurr.gamedices.model.crud.GameStepDefCrud;
import com.jtsolv.jtsolvcurr.gamedices.model.crud.GameStepResultCrud;
import com.jtsolv.jtsolvcurr.gamedices.model.entity.GameStepEntity;

import com.jtsolv.jtsolvcurr.gamedices.repository.entity.GameStepRepositoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional
public class DicesGameDataCollectorService {
	
	private final GameStepRepositoryCrud gameStepRepositoryCrud;
	private final GameStepDefRepositoryCrud gameStepDefRepositoryCrud;
	private final GameStepResultRepositoryCrud gameStepResultRepositoryCrud;
	
	private final GameStepRepositoryEntity gameStepRepositoryEntity;
	private final GameItemResultRepositoryCrud gameItemResultRepositoryCrud;
	
	
	@Autowired
	public DicesGameDataCollectorService(    	
   		final GameStepRepositoryCrud gameStepRepositoryCrud,
   		final GameStepRepositoryEntity gameStepRepositoryEntity,
   		final DiceRollEngine diceRollEngine,
   		final GameStepResultRepositoryCrud gameStepResultRepositoryCrud,
   		final GameItemResultRepositoryCrud  gameItemResultRepositoryCrud,
   		final GameStepDefRepositoryCrud gameStepDefRepositoryCrud,
   		final GameObjectRepositoryCrud gameObjectRepositoryCrud,
   		final DicesGameExecutorService dicesGameExecutorService) {        
        this.gameStepRepositoryCrud = gameStepRepositoryCrud;
        this.gameStepRepositoryEntity = gameStepRepositoryEntity;
        this.gameStepResultRepositoryCrud = gameStepResultRepositoryCrud;
        this.gameItemResultRepositoryCrud = gameItemResultRepositoryCrud;
        this.gameStepDefRepositoryCrud = gameStepDefRepositoryCrud;
    }
	
	public void executeDicesGameCollector( final Long gameStepResultId) {
		final Optional<GameStepDefCrud> defId = getGameStepDefByGameStepResultId(gameStepResultId);
		if(defId.isEmpty()) {
			return ;
		}
		final List<GameItemResultCrud> collectedResults = collectDicesGame(defId.get().getId(), gameStepResultId);
		if(collectedResults == null) {
			return;
		}
		this.gameItemResultRepositoryCrud.deleteByGameStepResultId(gameStepResultId);
		for (GameItemResultCrud resultToSave: collectedResults ) {
			try {
				this.gameItemResultRepositoryCrud.save(resultToSave);
			}catch(Exception ex) {
				JTSolvGenericLogger.logGenericException(ex,"saveItem");
			}
		}			
		return ;		
	}
	
	
	public List<GameItemResultCrud> collectDicesGame( final Long gameDefinitionId, final Long gameStepResultId) {
		
		final Optional<GameStepDefCrud> stepDef = gameStepDefRepositoryCrud.findById(gameDefinitionId);
		if(stepDef.isEmpty()) {
			return null;
		}
				
		final List<GameItemResultCrud> stepItemResultCrud = mapStepDefToStepItemResult(stepDef.get());
		
		final Map<Long,List<GameItemResultCrud>> mapStateValueToItems = stepItemResultCrud.stream()
				.collect(Collectors.groupingBy(GameItemResultCrud::getStateValue));
		
		final List<GameItemResultCrud> resultsByValue = new ArrayList<>(); 
		
		for (Map.Entry<Long, List<GameItemResultCrud>> entry: mapStateValueToItems.entrySet()) {
			
			List<GameItemResultCrud> allItems = entry.getValue();
			
			final GameItemResultCrud resultValues = new GameItemResultCrud();
			
			allItems.stream()
				.filter(item -> gameItemResultisNotComputed(item))
				.forEach(item -> mapCollectedData(item, resultValues, gameStepResultId));
			
			resultsByValue.add(resultValues);			
			
		}
		return resultsByValue;
	}

	private boolean gameItemResultisNotComputed(GameItemResultCrud item) {
	
		return item.getGameResultItemType()!= null && !item.getGameResultItemType().equals("c");
	}
	
	private GameItemResultCrud mapCollectedData(final GameItemResultCrud item,GameItemResultCrud resultValues,final Long gameStepResultId) {
		resultValues.setStateValue( nLong(item.getStateValue()));
		resultValues.setStateValueAchieved(nLong(resultValues.getStateValueAchieved()) + nLong(item.getStateValueAchieved()));
		resultValues.setAchieved(nLong(resultValues.getAchieved()) + nLong(item.getAchieved()));
		
		if(nDouble(item.getNumberOfAttempts()) == 0){
			item.setNumberOfAttempts(Long.valueOf(1));
		}
		
		Double percent = nDouble(item.getAchieved())/nDouble(item.getNumberOfAttempts());
		resultValues.setStateValuePercentage(percent);
		
		resultValues.setHitsCumulatively(nDouble(resultValues.getHitsCumulatively()) + nDouble(item.getHitsCumulatively()));
		resultValues.setNumberOfAttempts(nLong(resultValues.getNumberOfAttempts()) + nLong(item.getNumberOfAttempts()));
		
		Double percentCumulatively = nDouble(resultValues.getHitsCumulatively())/nDouble(resultValues.getNumberOfAttempts())* 100;
		
		resultValues.setPercentageCumulatively(percentCumulatively);
		resultValues.setGameStepDefId(item.getGameStepDefId());
		resultValues.setGameStepResultId(gameStepResultId);
		resultValues.setGameResultItemType("c");
		return resultValues;
	}
	
	private static Double nDouble(Double value) {
		if (value == null) {
			return Double.valueOf(0);
		}
		return value;
	}
	
	private static Double nDouble(Long value) {
		if (value == null) {
			return Double.valueOf(0);
		}
		return  Double.valueOf(value);
	}
	
	private static Long nLong(Long value) {
		if (value == null) {
			return Long.valueOf(0);
		}
		return value;
	}
	
	public static Map<Long,Long> getSummedValue(List<GameItemResultCrud> resultItems) {
		Map<Long,Long> mappedValues = resultItems.stream()
				.collect(Collectors.groupingBy(
						GameItemResultCrud::getStateValue,			
				Collectors.summingLong (GameItemResultCrud::getStateValue)));
		return mappedValues;	
	}
		
	public List<GameItemResultCrud> mapStepResultsToItemResults(final GameStepResultCrud step) {
		List<GameItemResultCrud> outList = this.gameItemResultRepositoryCrud.findByGameStepResultId(step.getId());
		return outList;
	}
	
	public Stream<GameItemResultCrud> mapStepResultsToItemResultsStream(final GameStepResultCrud step) {
		List<GameItemResultCrud> outList = this.gameItemResultRepositoryCrud.findByGameStepResultId(step.getId());
		return outList.stream();
	}
	
	public List<GameStepResultCrud> mapStepDefToStepResult(final GameStepDefCrud stepDef) {
		List<GameStepResultCrud> outList = this.gameStepResultRepositoryCrud.findByGameStepDefId(stepDef.getId());
		return outList;
	}
	
	public List<GameItemResultCrud> mapStepDefToStepItemResult(final GameStepDefCrud stepDef) {
		List<GameItemResultCrud> outList = this.gameItemResultRepositoryCrud.findByGameStepDefId(stepDef.getId());
		return outList;
	}
	
	public Optional<GameStepDefCrud> getGameStepDefByGameStepResultId(Long gameStepResultId) {

		final Optional<GameStepResultCrud> gameStepResultCrud = gameStepResultRepositoryCrud.findById(gameStepResultId);
		if(gameStepResultCrud.isEmpty()) {
			return null;
		}
		
		if(gameStepResultCrud.get().getGameStepId() == null) {
			return null;
		}
		
		final Optional<GameStepCrud> gameStepCrud = gameStepRepositoryCrud.findById(gameStepResultCrud.get().getGameStepId());
		if(gameStepCrud.isEmpty()) {
			return null;
		}
		
		final Optional<GameStepEntity> gameStep =  this.gameStepRepositoryEntity.findById(gameStepCrud.get().getId());
		if(gameStep.isEmpty()) {
			return null;
		}
		
		if(gameStepCrud.get().getGameStepDefId() == null) {
			return null;
		}
		
		final Optional<GameStepDefCrud> gameStepDef =  this.gameStepDefRepositoryCrud.findById(gameStepCrud.get().getGameStepDefId());
		if(gameStepDef.isEmpty()) {
			return null;
		}
		return gameStepDef;		
	}
}

