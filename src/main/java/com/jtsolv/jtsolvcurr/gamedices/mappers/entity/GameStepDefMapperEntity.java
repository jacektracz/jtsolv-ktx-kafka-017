package com.jtsolv.jtsolvcurr.gamedices.mappers.entity;

import com.jtsolv.jtsolvcurr.gamedices.dto.GameObjectDTO;
import com.jtsolv.jtsolvcurr.gamedices.dto.GameStepDefDTO;
import com.jtsolv.jtsolvcurr.gamedices.mappers.lib.MapperUtils;
import com.jtsolv.jtsolvcurr.gamedices.model.entity.GameObjectEntity;
import com.jtsolv.jtsolvcurr.gamedices.model.entity.GameStepDefEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameStepDefMapperEntity {
    
	public static GameStepDefEntity getMappedEntity(GameStepDefDTO inObject) {
		if(inObject == null) {
			return null;
		}		
		GameStepDefEntity outObject = new GameStepDefEntity();
		mapToEntity(inObject, outObject);
		return outObject;
	}
	
	public static GameStepDefDTO getMappedDTO(GameStepDefEntity inObject, boolean mapRelations) {
		if(inObject == null) {
			return null;
		}		
		GameStepDefDTO outObject = new GameStepDefDTO();
		mapToDTO(inObject, outObject, mapRelations);
		return outObject;
	}
	
	
	public static GameStepDefDTO getMappedRowDTO(GameStepDefEntity inObject) {
		if(inObject == null) {
			return null;
		}		
		GameStepDefDTO outObject = new GameStepDefDTO();
		mapRowToDTO(inObject, outObject);
		return outObject;
	}
	
	public static void mapToEntity(GameStepDefDTO inObject, GameStepDefEntity outObject) {
		outObject.setAttempts(inObject.getAttempts());
		outObject.setName(inObject.getName());
		outObject.setEmail(inObject.getEmail());
		outObject.setObjectsNumber(inObject.getObjectsNumber());
		outObject.setId(MapperUtils.getMappedId(inObject.getId()));
		
		outObject.setPrimaryGameObject(
				GameObjectMapperEntity.getMapedEntity(inObject.getPrimaryGameObject()));
				
		List<GameObjectEntity> objects = GameObjectMapperEntity.mapCollectionToEntities(
				inObject.getGameObjects());
		
		outObject.setGameObjects(objects);
	}
	
	public static void mapToDTO(GameStepDefEntity inObject, GameStepDefDTO outObject, boolean mapRelations) {
		mapRowToDTO(inObject,outObject);
		if(mapRelations) {
			mapRelationsToDTO(inObject,outObject);
		}
	}
	
	public static void mapRowToDTO(GameStepDefEntity inObject, GameStepDefDTO outObject) {
		outObject.setAttempts(inObject.getAttempts());
		outObject.setEmail(inObject.getEmail());
		outObject.setName(inObject.getName());
		outObject.setId(MapperUtils.getMappedId(inObject.getId()));		
		outObject.setObjectsNumber(inObject.getObjectsNumber());
	}
	
	public static void mapRelationsToDTO(GameStepDefEntity inObject, GameStepDefDTO outObject) {
		List<GameObjectDTO> objects = GameObjectMapperEntity.mapCollectionToDTO(
				inObject.getGameObjects());
		outObject.setGameObjects(objects);
		
		GameObjectDTO gameObjectDTO = GameObjectMapperEntity.getMapedRowDTO(
				inObject.getPrimaryGameObject()); 
		outObject.setPrimaryGameObject(gameObjectDTO);		
	}
	
	public static List<GameStepDefEntity> mapCollectionToEntities(List<GameStepDefDTO> inObjects) {
		if(inObjects == null) {
			return new ArrayList<GameStepDefEntity>();
		}				
		List<GameStepDefEntity> objects = 		
				inObjects
				.stream()
				.map(u ->  GameStepDefMapperEntity.getMappedEntity(u))
				.collect(Collectors.toList());
		return objects;
	}
	
	public static List<GameStepDefDTO> mapCollectionToDTO(List<GameStepDefEntity> inObjects) {
		if(inObjects == null) {
			return new ArrayList<GameStepDefDTO>();
		}		
		
		List<GameStepDefDTO> objects = 		
				inObjects
				.stream()
				.map(u ->  GameStepDefMapperEntity.getMappedDTO(u,true))
				.collect(Collectors.toList());
		return objects;
	}
	
}
