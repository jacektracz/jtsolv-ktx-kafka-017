package com.jtsolv.jtsolvcurr.gamedices.mappers.entity;

import com.jtsolv.jtsolvcurr.gamedices.dto.GameItemDTO;
import com.jtsolv.jtsolvcurr.gamedices.model.entity.GameItemEntity;


public class GameItemMapperEntity {
    
	public void mapToEntity(GameItemDTO inObject, GameItemEntity outObject) {		
		outObject.setName(inObject.getName());
		outObject.setEmail(inObject.getEmail());
		outObject.setId(inObject.getId());	
	}
	
	public void mapToDTO(GameItemEntity inObject, GameItemDTO outObject) {
		outObject.setName(inObject.getName());
		outObject.setEmail(inObject.getEmail());
		outObject.setId(inObject.getId());		
	}

}
