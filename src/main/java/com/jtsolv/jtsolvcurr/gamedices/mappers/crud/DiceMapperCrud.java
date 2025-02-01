package com.jtsolv.jtsolvcurr.gamedices.mappers.crud;

import com.jtsolv.jtsolvcurr.gamedices.dto.DiceDTO;
import com.jtsolv.jtsolvcurr.gamedices.model.entity.DiceEntity;


public class DiceMapperCrud {
    
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
