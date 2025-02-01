package com.jtsolv.jtsolvcurr.gamedices.mappers.crud;

import com.jtsolv.jtsolvcurr.gamedices.dto.GameStepDefDTO;
import com.jtsolv.jtsolvcurr.gamedices.mappers.lib.MapperUtils;
import com.jtsolv.jtsolvcurr.gamedices.model.crud.GameStepDefCrud;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameStepDefMapperCrud {
    
	public static GameStepDefCrud getMappedEntity(GameStepDefDTO inObject) {
		if(inObject == null) {
			return null;
		}		
		GameStepDefCrud outObject = new GameStepDefCrud();
		mapToEntity(inObject, outObject);
		return outObject;
	}
	
	public static GameStepDefDTO getMappedDTO(GameStepDefCrud inObject) {
		if(inObject == null) {
			return null;
		}		
		GameStepDefDTO outObject = new GameStepDefDTO();
		mapToDTO(inObject, outObject);
		return outObject;
	}
	
	public static void mapToEntity(GameStepDefDTO inObject, GameStepDefCrud outObject) {
		
		outObject.setAttempts(inObject.getAttempts());
		outObject.setName(inObject.getName());
		outObject.setEmail(inObject.getEmail());
		outObject.setObjectsNumber(inObject.getObjectsNumber());
		outObject.setId(MapperUtils.getMappedId(inObject.getId()));
		
		if(inObject.getPrimaryGameObject()!= null 
				&& inObject.getPrimaryGameObject().getId() != null
				&& inObject.getPrimaryGameObject().getId() != 0) {
			
			outObject.setPrimaryGameObject(
					inObject.getPrimaryGameObject().getId());			
		}
		
	}
	
	public static void mapToDTO(GameStepDefCrud inObject, GameStepDefDTO outObject) {
		outObject.setAttempts(inObject.getAttempts());
		outObject.setEmail(inObject.getEmail());
		outObject.setName(inObject.getName());
		outObject.setId(inObject.getId());	
		outObject.setObjectsNumber(inObject.getObjectsNumber());
	}
	
	public static List<GameStepDefCrud> mapCollectionToEntities(List<GameStepDefDTO> inObjects) {
		if(inObjects == null) {
			return new ArrayList<GameStepDefCrud>();
		}				
		List<GameStepDefCrud> objects = 		
				inObjects
				.stream()
				.map(u ->  GameStepDefMapperCrud.getMappedEntity(u))
				.collect(Collectors.toList());
		return objects;
	}
	
	public static List<GameStepDefDTO> mapCollectionToDTO(List<GameStepDefCrud> inObjects) {
		if(inObjects == null) {
			return new ArrayList<GameStepDefDTO>();
		}		
		
		List<GameStepDefDTO> objects = 		
				inObjects
				.stream()
				.map(u ->  GameStepDefMapperCrud.getMappedDTO(u))
				.collect(Collectors.toList());
		return objects;
	}
	
}
