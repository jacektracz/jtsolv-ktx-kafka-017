package com.jtsolv.jtsolvcurr.gamedices.mappers.crud;


import com.jtsolv.jtsolvcurr.gamedices.dto.GameItemResultDTO;
import com.jtsolv.jtsolvcurr.gamedices.mappers.lib.MapperUtils;
import com.jtsolv.jtsolvcurr.gamedices.model.crud.GameItemResultCrud;


public class GameItemResultMapperCrud {
    
	public static GameItemResultCrud getMappedEntity(final GameItemResultDTO inObject) {
		if(inObject == null) {
			return null;
		}		
		final GameItemResultCrud outObject = new GameItemResultCrud();
		mapToEntity(inObject, outObject);
		return outObject;
	}
	
	public static GameItemResultDTO getMappedDTO(final GameItemResultCrud inObject) {
		if(inObject == null) {
			return null;
		}		
		final GameItemResultDTO outObject = new GameItemResultDTO();
		mapToDTO(inObject, outObject);
		return outObject;
	}
	
	public static void mapToEntity(GameItemResultDTO inObject, GameItemResultCrud outObject) {		
		outObject.setName(inObject.getName());
		outObject.setEmail(inObject.getEmail());
		outObject.setId(MapperUtils.getMappedId(inObject.getId()));
		outObject.setStateValue(inObject.getStateValue());
		outObject.setStateValueAchieved(inObject.getStateValueAchieved());
		outObject.setStateCombinations(inObject.getStateCombinations());
		outObject.setStateValuePercentage(inObject.getStateValuePercentage());			
		outObject.setPercentageCumulatively(inObject.getPercentageCumulatively());
		outObject.setNumberOfAttempts(inObject.getNumberOfAttempts());
		outObject.setGameResultItemType(inObject.getGameResultItemType());
		outObject.setHitsCumulatively(inObject.getHitsCumulatively());
		if(inObject.getGameStepResult() != null 
				&& inObject.getGameStepResult().getId() != null
				&& inObject.getGameStepResult().getId() != 0) {
			
			outObject.setGameStepResultId(
					inObject.getGameStepResult().getId());			
		}		
	}
	
	public static void mapToDTO(GameItemResultCrud inObject, GameItemResultDTO outObject) {
		outObject.setName(inObject.getName());
		outObject.setEmail(inObject.getEmail());
		outObject.setId(MapperUtils.getMappedId(inObject.getId()));
		outObject.setGameStepResult(null);
		outObject.setStateValue(inObject.getStateValue());
		outObject.setStateValueAchieved(inObject.getStateValueAchieved());
		outObject.setStateCombinations(inObject.getStateCombinations());
		outObject.setStateValuePercentage(inObject.getStateValuePercentage());
		outObject.setPercentageCumulatively(inObject.getPercentageCumulatively());
		outObject.setNumberOfAttempts(inObject.getNumberOfAttempts());
		outObject.setGameResultItemType(inObject.getGameResultItemType());
		outObject.setHitsCumulatively(inObject.getHitsCumulatively());
		
	}
	
}
