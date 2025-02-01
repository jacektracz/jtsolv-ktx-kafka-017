package com.jtsolv.jtsolvcurr.gamedices.mappers.entity;

import com.jtsolv.jtsolvcurr.gamedices.dto.GameItemResultDTO;
import com.jtsolv.jtsolvcurr.gamedices.dto.GameStepResultDTO;
import com.jtsolv.jtsolvcurr.gamedices.mappers.lib.MapperUtils;
import com.jtsolv.jtsolvcurr.gamedices.model.entity.GameStepResultEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameStepResultMapperEntity {
	
	public static GameStepResultEntity getMappedEntity(final GameStepResultDTO inObject) {
		if(inObject == null) {
			return null;
		}		
		GameStepResultEntity outObject = new GameStepResultEntity();
		mapToEntity(inObject, outObject,true);
		return outObject;
	}
	
	public static GameStepResultDTO getMappedDTO(final GameStepResultEntity inObject, boolean mapRelations) {
		if(inObject == null) {
			return null;
		}		
		GameStepResultDTO outObject = new GameStepResultDTO();
		mapToDTO(inObject, outObject,mapRelations);
		return outObject;
	}
	
	public static GameStepResultDTO getMappedRowDTO(final GameStepResultEntity inObject) {
		if(inObject == null) {
			return null;
		}		
		GameStepResultDTO outObject = new GameStepResultDTO();
		mapRowToDTO(inObject, outObject);
		return outObject;
	}	
	
	public static void mapToEntity(final GameStepResultDTO inObject, final GameStepResultEntity outObject,boolean withChilds) {		
		outObject.setName(inObject.getName());
		outObject.setEmail(inObject.getEmail());
		outObject.setId(MapperUtils.getMappedId(inObject.getId()));
	}
	
	public static void mapToDTO(final GameStepResultEntity inObject, final GameStepResultDTO outObject, boolean mapRelations) {
		mapRowToDTO(inObject,outObject);
		mapRelationsToDTO(inObject,outObject);
	}
	
	public static void mapRowToDTO(final GameStepResultEntity inObject, final GameStepResultDTO outObject) {
		
		outObject.setEmail(inObject.getEmail());
		outObject.setName(inObject.getName());
		outObject.setId(MapperUtils.getMappedId(inObject.getId()));
	}
	
	public static void mapRelationsToDTO(final GameStepResultEntity inObject, final GameStepResultDTO outObject) {		
		List<GameItemResultDTO> gameItemResults = GameItemResultMapperEntity.mapCollectionToDTO(
				inObject.getGameItemResults());
		outObject.setGameItemResults(gameItemResults);		
		outObject.setGameStep(GameStepMapperEntity.getMappedRowDTO(inObject.getGameStep()));
	}
		
	public static List<GameStepResultDTO> mapCollectionToDTO(List<GameStepResultEntity> inObjects) {
		if(inObjects == null) {
			return new ArrayList<GameStepResultDTO>();
		}		
		
		List<GameStepResultDTO> objects = 		
				inObjects
				.stream()
				.map(u ->  GameStepResultMapperEntity.getMappedDTO(u,true))
				.collect(Collectors.toList());
		return objects;
	}
	
}
