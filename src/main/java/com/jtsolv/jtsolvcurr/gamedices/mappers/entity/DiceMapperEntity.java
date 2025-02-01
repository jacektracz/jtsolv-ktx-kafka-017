package com.jtsolv.jtsolvcurr.gamedices.mappers.entity;

import com.jtsolv.jtsolvcurr.gamedices.dto.DiceDTO;
import com.jtsolv.jtsolvcurr.gamedices.model.entity.DiceEntity;


public class DiceMapperEntity {
    
	public void mapToEntity(DiceDTO inObject, DiceEntity outObject) {		
		outObject.setName(inObject.getName());
		outObject.setEmail(inObject.getEmail());
		outObject.setId(inObject.getId());	
	}
	
	public void mapToDTO(DiceEntity inObject, DiceDTO outObject) {
		outObject.setName(inObject.getName());
		outObject.setEmail(inObject.getEmail());
		outObject.setId(inObject.getId());		
	}

}
