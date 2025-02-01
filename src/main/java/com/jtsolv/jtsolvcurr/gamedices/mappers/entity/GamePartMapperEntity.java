package com.jtsolv.jtsolvcurr.gamedices.mappers.entity;

import com.jtsolv.jtsolvcurr.gamedices.dto.GamePartDTO;
import com.jtsolv.jtsolvcurr.gamedices.model.entity.GamePartEntity;


public class GamePartMapperEntity {
    
	public void mapToEntity(GamePartDTO inObject, GamePartEntity outObject) {
		
		outObject.setName(inObject.getName());
		outObject.setEmail(inObject.getEmail());
		outObject.setId(inObject.getId());	
	}
	
	public void mapToDTO(GamePartEntity inObject, GamePartDTO outObject) {
		outObject.setName(inObject.getName());
		outObject.setEmail(inObject.getEmail());
		outObject.setId(inObject.getId());		
	}
}
