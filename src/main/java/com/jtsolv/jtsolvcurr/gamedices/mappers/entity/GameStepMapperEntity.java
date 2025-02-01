package com.jtsolv.jtsolvcurr.gamedices.mappers.entity;

import com.jtsolv.jtsolvcurr.gamedices.dto.GameStepDTO;
import com.jtsolv.jtsolvcurr.gamedices.dto.GameStepDefDTO;
import com.jtsolv.jtsolvcurr.gamedices.mappers.lib.MapperUtils;
import com.jtsolv.jtsolvcurr.gamedices.model.entity.GameStepEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameStepMapperEntity {
    
	public static GameStepEntity getMappedEntity(GameStepDTO inObject) {
		if(inObject == null) {
			return null;
		}		
		GameStepEntity outObject = new GameStepEntity();
		mapToEntity(inObject, outObject);
		return outObject;
	}
	
	public static GameStepDTO getMappedDTO(GameStepEntity inObject, boolean mapRelations) {
		if(inObject == null) {
			return null;
		}		
		GameStepDTO outObject = new GameStepDTO();
		mapToDTO(inObject, outObject,mapRelations);
		return outObject;
	}
	
	public static GameStepDTO getMappedRowDTO(GameStepEntity inObject) {
		if(inObject == null) {
			return null;
		}		
		GameStepDTO outObject = new GameStepDTO();
		mapRowToDTO(inObject, outObject);
		return outObject;
	}
		
	public static void mapToEntity(GameStepDTO inObject, GameStepEntity outObject) {
		
		outObject.setName(inObject.getName());
		outObject.setEmail(inObject.getEmail());
		outObject.setId(MapperUtils.getMappedId(inObject.getId()));
		outObject.setAttempts(inObject.getAttempts());
	}
	
	public static void mapToDTO(GameStepEntity inObject, GameStepDTO outObject, boolean mapRelations) {
		mapRowToDTO(inObject,outObject);
		mapRelationsToDTO(inObject, outObject);
	}
	
	public static void mapRowToDTO(GameStepEntity inObject, GameStepDTO outObject) {
		outObject.setEmail(inObject.getEmail());
		outObject.setName(inObject.getName());
		outObject.setId(MapperUtils.getMappedId(inObject.getId()));	
		outObject.setAttempts(inObject.getAttempts());
	}    
	
	public static void mapRelationsToDTO(GameStepEntity inObject, GameStepDTO outObject) {
		GameStepDefDTO stepDefDTO = GameStepDefMapperEntity.getMappedRowDTO(
				inObject.getGameStepDefEntity());
		outObject.setGameStepDef(stepDefDTO);
	}    
	
	public static List<GameStepDTO> mapCollectionToDTO(List<GameStepEntity> inObjects) {
		if(inObjects == null) {
			return new ArrayList<GameStepDTO>();
		}		
		
		List<GameStepDTO> objects = 		
				inObjects
				.stream()
				.map(u ->  GameStepMapperEntity.getMappedDTO(u,true))
				.collect(Collectors.toList());
		return objects;
	}
	
}
