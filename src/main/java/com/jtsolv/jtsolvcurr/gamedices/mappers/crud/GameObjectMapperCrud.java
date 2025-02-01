package com.jtsolv.jtsolvcurr.gamedices.mappers.crud;

import com.jtsolv.jtsolvcurr.gamedices.dto.GameObjectDTO;
import com.jtsolv.jtsolvcurr.gamedices.model.entity.GameObjectEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class GameObjectMapperCrud {

	public static GameObjectEntity getMapedEntity(GameObjectDTO inObject) {
		if(inObject == null) {
			return null;
		}		
		GameObjectEntity outObject = new GameObjectEntity();
		mapToEntity(inObject, outObject);
		return outObject;
	}
	
	public static GameObjectDTO getMapedDTO(GameObjectEntity inObject) {
		if(inObject == null) {
			return null;
		}				
		GameObjectDTO outObject = new GameObjectDTO();
		mapToDTO(inObject, outObject);
		return outObject;
	}
	
	public static void mapToEntity(GameObjectDTO inObject, GameObjectEntity outObject) {
		if(inObject == null) {
			return;
		}
		outObject.setName(inObject.getName());
		outObject.setEmail(inObject.getEmail());
		outObject.setId(inObject.getId());	
	}
	
	
	public static void mapToDTO(GameObjectEntity inObject, GameObjectDTO outObject) {
		if(inObject == null) {
			return;
		}		
		outObject.setName(inObject.getName());
		outObject.setEmail(inObject.getEmail());
		outObject.setId(inObject.getId());		
	}
	
	public static List<GameObjectEntity> mapCollectionToEntities(List<GameObjectDTO> inObjects) {
		if(inObjects == null) {
			return new ArrayList<GameObjectEntity>();
		}
		List<GameObjectEntity> gameObjects = 		
				inObjects
				.stream()
				.map(u ->  GameObjectMapperCrud.getMapedEntity(u))
				.collect(Collectors.toList());
		return gameObjects;
	}
	
	public static List<GameObjectDTO> mapCollectionToDTO(List<GameObjectEntity> inObjects) {
		if(inObjects == null) {
			return new ArrayList<GameObjectDTO>();
		}		
		List<GameObjectDTO> gameObjects = 		
				inObjects
				.stream()
				.map(u ->  GameObjectMapperCrud.getMapedDTO(u))
				.collect(Collectors.toList());
		
		return gameObjects;
	}
	
}
