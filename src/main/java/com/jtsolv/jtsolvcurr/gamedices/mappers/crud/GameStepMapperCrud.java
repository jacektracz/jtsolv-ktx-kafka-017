package com.jtsolv.jtsolvcurr.gamedices.mappers.crud;

import com.jtsolv.jtsolvcurr.gamedices.dto.GameStepDTO;
import com.jtsolv.jtsolvcurr.gamedices.mappers.lib.MapperUtils;
import com.jtsolv.jtsolvcurr.gamedices.model.crud.GameStepCrud;

public class GameStepMapperCrud {
    
	public static GameStepCrud getMappedEntity(GameStepDTO inObject) {
		if(inObject == null) {
			return null;
		}		
		GameStepCrud outObject = new GameStepCrud();
		mapToEntity(inObject, outObject);
		return outObject;
	}
	
	public static GameStepDTO getMappedDTO(GameStepCrud inObject) {
		if(inObject == null) {
			return null;
		}		
		GameStepDTO outObject = new GameStepDTO();
		mapToDTO(inObject, outObject);
		return outObject;
	}
	
	public static void mapToEntity(GameStepDTO inObject, GameStepCrud outObject) {
		
		outObject.setName(inObject.getName());
		outObject.setEmail(inObject.getEmail());
		outObject.setAttempts(inObject.getAttempts());
		outObject.setId(MapperUtils.getMappedId(inObject.getId()));		
		if(inObject.getGameStepDef() != null) {
			outObject.setGameStepDefId(MapperUtils.getMappedId(inObject.getGameStepDef().getId()));
		}
	}
	
	public static void mapToDTO(GameStepCrud inObject, GameStepDTO outObject) {
		
		outObject.setEmail(inObject.getEmail());
		outObject.setName(inObject.getName());
		outObject.setId(MapperUtils.getMappedId(inObject.getId()));		
		outObject.setGameStepDef(null);
		outObject.setAttempts(inObject.getAttempts());
	}
    
}
