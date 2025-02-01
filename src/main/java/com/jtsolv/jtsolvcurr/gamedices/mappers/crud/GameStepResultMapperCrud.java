package com.jtsolv.jtsolvcurr.gamedices.mappers.crud;

import com.jtsolv.jtsolvcurr.gamedices.dto.GameStepResultDTO;
import com.jtsolv.jtsolvcurr.gamedices.mappers.lib.MapperUtils;
import com.jtsolv.jtsolvcurr.gamedices.model.crud.GameStepResultCrud;

public class GameStepResultMapperCrud {
    
	public static GameStepResultCrud getMappedEntity(final GameStepResultDTO inObject) {
		if(inObject == null) {
			return null;
		}		
		final GameStepResultCrud outObject = new GameStepResultCrud();
		mapToEntity(inObject, outObject);
		return outObject;
	}
	
	public static GameStepResultDTO getMappedDTO(final GameStepResultCrud inObject) {
		if(inObject == null) {
			return null;
		}		
		final GameStepResultDTO outObject = new GameStepResultDTO();
		mapToDTO(inObject, outObject);
		return outObject;
	}
	
	public static void mapToEntity(final GameStepResultDTO inObject, final GameStepResultCrud outObject) {
		
		outObject.setName(inObject.getName());
		outObject.setEmail(inObject.getEmail());
		outObject.setId(MapperUtils.getMappedId(inObject.getId()));
		if(inObject.getGameStepDef() != null) {
			outObject.setGameStepDefId(MapperUtils.getMappedId(inObject.getGameStepDef().getId()));
		}
		if(inObject.getGameStep() != null) {
			outObject.setGameStepId(MapperUtils.getMappedId(inObject.getGameStep().getId()));
		}
		
	}
	
	public static void mapToDTO(final GameStepResultCrud inObject, final GameStepResultDTO outObject) {
		
		outObject.setEmail(inObject.getEmail());
		outObject.setName(inObject.getName());
		outObject.setId(MapperUtils.getMappedId(inObject.getId()));
		outObject.setGameStepDef(null);		
		outObject.setGameStep(null);		
	}
    
}
