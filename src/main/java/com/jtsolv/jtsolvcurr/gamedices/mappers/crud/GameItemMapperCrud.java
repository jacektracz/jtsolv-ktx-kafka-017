package com.jtsolv.jtsolvcurr.gamedices.mappers.crud;

import com.jtsolv.jtsolvcurr.gamedices.dto.GameItemDTO;
import com.jtsolv.jtsolvcurr.gamedices.model.crud.GameItemCrud;


public class GameItemMapperCrud {
    
	public void mapToEntity(GameItemDTO inObject, GameItemCrud outObject) {		
		outObject.setName(inObject.getName());
		outObject.setEmail(inObject.getEmail());
		outObject.setId(inObject.getId());	
	}
	
	public void mapToDTO(GameItemCrud inObject, GameItemDTO outObject) {
		outObject.setName(inObject.getName());
		outObject.setEmail(inObject.getEmail());
		outObject.setId(inObject.getId());		
	}

}
