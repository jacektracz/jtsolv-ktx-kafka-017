package com.jtsolv.jtsolvcurr.gamedices.mappers.entity;


import com.jtsolv.jtsolvcurr.gamedices.dto.GameItemResultDTO;
import com.jtsolv.jtsolvcurr.gamedices.dto.GameStepResultDTO;
import com.jtsolv.jtsolvcurr.gamedices.model.entity.GameItemResultEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class GameItemResultMapperEntity {
    
	public static GameItemResultEntity getMappedEntity(final GameItemResultDTO inObject) {
		if(inObject == null) {
			return null;
		}		
		final GameItemResultEntity outObject = new GameItemResultEntity();
		mapToEntity(inObject, outObject);
		return outObject;
	}
	
	public static GameItemResultDTO getMappedDTO(final GameItemResultEntity inObject) {
		if(inObject == null) {
			return null;
		}		
		GameItemResultDTO outObject = new GameItemResultDTO();
		mapToDTO(inObject, outObject);
		return outObject;
	}
	
	public static GameItemResultDTO getMappedRowDTO(final GameItemResultEntity inObject) {
		if(inObject == null) {
			return null;
		}		
		GameItemResultDTO outObject = new GameItemResultDTO();
		mapRowToDTO(inObject, outObject);
		return outObject;
	}
	
	public static void mapToEntity(final GameItemResultDTO inObject, final GameItemResultEntity outObject) {		
		outObject.setName(inObject.getName());
		outObject.setEmail(inObject.getEmail());
		outObject.setId(inObject.getId());	
		outObject.setStateValue(inObject.getStateValue());
		outObject.setStateValueAchieved(inObject.getStateValueAchieved());
		outObject.setStateCombinations(inObject.getStateCombinations());
		outObject.setStateValuePercentage(inObject.getStateValuePercentage());	
		outObject.setNumberOfAttempts(inObject.getNumberOfAttempts());
		outObject.setGameResultItemType(inObject.getGameResultItemType());
		outObject.setHitsCumulatively(inObject.getHitsCumulatively());
	}
	
	public static void mapToDTO(final GameItemResultEntity inObject, final GameItemResultDTO outObject) {
		mapRowToDTO(inObject,outObject);
		mapRelationsToDTO(inObject,outObject);
	}
	
	public static void mapRowToDTO(final GameItemResultEntity inObject, final GameItemResultDTO outObject) {
		outObject.setName(inObject.getName());
		outObject.setEmail(inObject.getEmail());
		outObject.setId(inObject.getId());
		outObject.setStateValue(inObject.getStateValue());
		outObject.setStateValueAchieved(inObject.getStateValueAchieved());
		outObject.setStateCombinations(inObject.getStateCombinations());
		outObject.setStateValuePercentage(inObject.getStateValuePercentage());
		outObject.setPercentageCumulatively(inObject.getPercentageCumulatively());
		outObject.setNumberOfAttempts(inObject.getNumberOfAttempts());
		outObject.setGameResultItemType(inObject.getGameResultItemType());
		outObject.setHitsCumulatively(inObject.getHitsCumulatively());
	}
	
	public static void mapRelationsToDTO(final GameItemResultEntity inObject, final GameItemResultDTO outObject) {
		final GameStepResultDTO gameStepResultDTO = new GameStepResultDTO();
		GameStepResultMapperEntity.mapRowToDTO( 
				inObject.getGameStepResult()
				, gameStepResultDTO);
		outObject.setGameStepResult(gameStepResultDTO);
	}	
	
	public static List<GameItemResultEntity> mapCollectionToEntities(final List<GameItemResultDTO> inObjects) {
		if(inObjects == null) {
			return new ArrayList<GameItemResultEntity>();
		}				
		final List<GameItemResultEntity> objects = 		
				inObjects
				.stream()
				.map(u ->  GameItemResultMapperEntity.getMappedEntity(u))
				.collect(Collectors.toList());
		return objects;
	}
	
	public static List<GameItemResultDTO> mapCollectionToDTO(final List<GameItemResultEntity> inObjects) {
		if(inObjects == null) {
			return new ArrayList<GameItemResultDTO>();
		}		
		
		final List<GameItemResultDTO> objects = 		
				inObjects
				.stream()
				.map(u ->  GameItemResultMapperEntity.getMappedDTO(u))
				.collect(Collectors.toList());
		return objects;
	}	
}
