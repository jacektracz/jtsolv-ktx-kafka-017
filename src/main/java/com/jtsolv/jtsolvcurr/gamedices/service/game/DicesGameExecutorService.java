package com.jtsolv.jtsolvcurr.gamedices.service.game;

import com.jtsolv.jtsolvcurr.gamedices.engine.model.DiceRollEngine;
import com.jtsolv.jtsolvcurr.gamedices.engine.model.DiceRollResult;
import com.jtsolv.jtsolvcurr.gamedices.engine.model.ResultEntry;
import com.jtsolv.jtsolvcurr.gamedices.model.crud.*;
import com.jtsolv.jtsolvcurr.gamedices.repository.crud.*;

import com.jtsolv.jtsolvcurr.gamedices.model.entity.GameStepEntity;

import com.jtsolv.jtsolvcurr.gamedices.repository.entity.GameStepRepositoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class DicesGameExecutorService {
	
	private final GameStepRepositoryCrud gameStepRepositoryCrud;
	private final GameStepDefRepositoryCrud gameStepDefRepositoryCrud;
	private final GameStepResultRepositoryCrud gameStepResultRepositoryCrud;
	private final GameObjectRepositoryCrud gameObjectRepositoryCrud;
	
	private final GameStepRepositoryEntity gameStepRepositoryEntity;
	private final GameItemResultRepositoryCrud gameItemResultRepositoryCrud;
	private final DiceRollEngine diceRollEngine;
	private final DicesGameComputationEngineService dicesGameComputationEngineService;
	@Autowired
	public DicesGameExecutorService(    	
   		final GameStepRepositoryCrud gameStepRepositoryCrud,
   		final GameStepRepositoryEntity gameStepRepositoryEntity,
   		final DiceRollEngine diceRollEngine,
   		final GameStepResultRepositoryCrud gameStepResultRepositoryCrud,
   		final GameItemResultRepositoryCrud  gameItemResultRepositoryCrud,
   		final GameStepDefRepositoryCrud gameStepDefRepositoryCrud,
   		final GameObjectRepositoryCrud gameObjectRepositoryCrud,
   		final DicesGameComputationEngineService dicesGameComputationEngineService) {        
        this.gameStepRepositoryCrud = gameStepRepositoryCrud;
        this.gameStepRepositoryEntity = gameStepRepositoryEntity;
        this.diceRollEngine = diceRollEngine;
        this.gameStepResultRepositoryCrud = gameStepResultRepositoryCrud;
        this.gameItemResultRepositoryCrud = gameItemResultRepositoryCrud;
        this.gameStepDefRepositoryCrud = gameStepDefRepositoryCrud;
        this.gameObjectRepositoryCrud = gameObjectRepositoryCrud;
        this.dicesGameComputationEngineService = dicesGameComputationEngineService;
    }
	
	public DiceRollResult executeDicesGame( final Long gameStepResultId) {

		final DiceRollResult param = getDicesRollParam(gameStepResultId);
		if(param == null) {
			return null;
		}
		diceRollEngine.collectDisecRollResults(param);
		this.saveDicesGame(param,gameStepResultId);
		return param;
	}
	
	public void saveDicesGame( final DiceRollResult param, final Long gameStepResultId) {
		
		final GameStatistics game = prepareComputationParameters(param,gameStepResultId);
		
		this.gameItemResultRepositoryCrud.deleteByGameStepResultId(gameStepResultId);
		game.setHitsCumulatively(Double.valueOf(0));
		for (int currentValue = game.getMinValueToAchieve(); currentValue <= game.getMaxValueToAchieve(); currentValue++) {
			game.setCurrentValue(currentValue);			
			final GameItemResultCrud resultToSave = computeItemResult(game);
			this.dicesGameComputationEngineService.computeItemResult(resultToSave);			
		    this.gameItemResultRepositoryCrud.save(resultToSave);			
		}		
	}
	
	public GameStatistics prepareComputationParameters( final DiceRollResult param, final Long gameStepResultId) {
		
		final int maxValueToAchieve = param.getDices() * param.getDiceWalls();
		final int minValueToAchieve = param.getDices() ;
		int resultsToAchieve = param.getAttempts();
		int stateCombinations = maxValueToAchieve - minValueToAchieve;
		String strInfo = "";
		strInfo = strInfo + " attempts:" + param.getAttempts() ;
		strInfo = strInfo + " dices:" + param.getDices() ;
		strInfo = strInfo + " walls:" + param.getDiceWalls() ;
		strInfo = strInfo + " min:" + minValueToAchieve;
		strInfo = strInfo + " max:" + maxValueToAchieve;
		final GameStatistics gameStatistics =  new GameStatistics();
		gameStatistics.setDistributionData(param);
		gameStatistics.setMaxValueToAchieve(maxValueToAchieve);
		gameStatistics.setMinValueToAchieve(minValueToAchieve);
		gameStatistics.setStrInfo(strInfo);
		gameStatistics.setResultsToAchieve(resultsToAchieve);
		gameStatistics.setStateCombinations(stateCombinations);
		gameStatistics.setResultsToAchieve(resultsToAchieve);
		gameStatistics.setHitsCumulatively(Double.valueOf(0));
		gameStatistics.setPercentageCumulatively(Double.valueOf(0));
		gameStatistics.setGameStepResultId(gameStepResultId);
		gameStatistics.setGameStepDefId(param.getGameStepDef());
		gameStatistics.setNumberOfAttempts(Long.valueOf(param.getAttempts()));
		
		
		return gameStatistics;
	}
	
	public static GameItemResultCrud computeItemResult(final GameStatistics data) {
		
	    final GameItemResultCrud resultToSave = new GameItemResultCrud();
	    resultToSave.setGameStepResultId(data.getGameStepResultId());
	    Integer currentHits = 0;
	    if(data.getDistributionData().getResults().containsKey(data.getCurrentValue())) {
	    	final ResultEntry entry = data.getDistributionData().getResults().get(data.getCurrentValue());
	    	currentHits = entry.getValue().intValue();
	    }
	    
	    resultToSave.setAchieved(Long.valueOf(currentHits));
	    resultToSave.setStateValue(Long.valueOf(data.getCurrentValue()));
	    resultToSave.setStateValueAchieved(Long.valueOf(currentHits));		    
	    resultToSave.setStateCombinations(Long.valueOf(data.getStateCombinations()));
	    resultToSave.setGameStepDefId(data.getGameStepDefId());
	    resultToSave.setNumberOfAttempts(data.getNumberOfAttempts());
	    resultToSave.setGameResultItemType("g");
	    
	    
	    Double percentage = (double)currentHits/(double)data.getResultsToAchieve();
	    percentage = percentage * 100;
	    resultToSave.setStateValuePercentage(percentage);
	    
	    
	    Double hitsCumulatively = data.getHitsCumulatively() + currentHits;
	    data.setHitsCumulatively(hitsCumulatively);
	    resultToSave.setHitsCumulatively(hitsCumulatively);
	    
	    Double percentageCumulatively = ((double)data.getHitsCumulatively()/(double)data.getResultsToAchieve()) * 100;
	    data.setPercentageCumulatively(percentageCumulatively);
	    resultToSave.setPercentageCumulatively(percentageCumulatively);
	    
	    String strInfoCurr = data.getStrInfo() + " Percentage cumulatively :" + Math.round(data.getPercentageCumulatively());	    
	    strInfoCurr = strInfoCurr +  " hits cumulatively:" + hitsCumulatively;
	    resultToSave.setName(strInfoCurr);
	    
	    return resultToSave;	    
	}
	
	public DiceRollResult getDicesRollParam( final Long gameStepResultId) {
		
		final DiceRollResult diceRollParam = new DiceRollResult();
		
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
		if(gameStepDef.isEmpty()) {
			return null;
		}
		diceRollParam.setGameStepDef(gameStepDef.get().getId());
		
		if(gameStepDef.get().getAttempts() == null) {
			return null;
		}
		
		diceRollParam.setAttempts(gameStepDef.get().getAttempts().intValue());
		if(gameStep.get().getAttempts() != null && gameStep.get().getAttempts() > 0) {
			diceRollParam.setAttempts(gameStep.get().getAttempts().intValue());	
		}
		
		final Optional<GameObjectCrud> gameObject = this.gameObjectRepositoryCrud.findById(gameStepDef.get().getPrimaryGameObject());
		if(gameObject.isEmpty()) {
			return null;
		}
		
		diceRollParam.setDiceWalls(gameObject.get().getNumberOfParts().intValue());
		if(gameStepDef.get().getObjectsNumber() != null) {
			diceRollParam.setDices(gameStepDef.get().getObjectsNumber().intValue());
		}else {
			diceRollParam.setDices(3);
		}
		return diceRollParam;
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

