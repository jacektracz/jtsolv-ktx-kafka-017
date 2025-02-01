package com.jtsolv.jtsolvcurr.gamedices.mappers.entity;

import com.jtsolv.jtsolvcurr.gamedices.dto.GameDTO;
import com.jtsolv.jtsolvcurr.gamedices.model.entity.GameEntity;


public class GameMapperEntity {
    
	public void mapToEntity(GameDTO inObject, GameEntity outObject) {		
		outObject.setName(inObject.getName());
		outObject.setEmail(inObject.getEmail());
		outObject.setId(inObject.getId());	
	}
	
	public void mapToDTO(GameEntity inObject, GameDTO outObject) {
		outObject.setName(inObject.getName());
		outObject.setEmail(inObject.getEmail());
		outObject.setId(inObject.getId());		
	}
}
