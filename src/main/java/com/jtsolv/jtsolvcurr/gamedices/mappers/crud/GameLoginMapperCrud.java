package com.jtsolv.jtsolvcurr.gamedices.mappers.crud;

import com.jtsolv.jtsolvcurr.gamedices.dto.GameLoginDTO;
import com.jtsolv.jtsolvcurr.gamedices.model.crud.GameLoginCrud;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class GameLoginMapperCrud {
   
	public static GameLoginCrud getMappedEntity(GameLoginDTO inObject) {
		if(inObject == null) {
			return null;
		}		
		GameLoginCrud outObject = new GameLoginCrud();
		mapToEntity(inObject, outObject);
		return outObject;
	}
	
	public static GameLoginDTO getMappedDTO(GameLoginCrud inObject) {
		if(inObject == null) {
			return null;
		}		
		GameLoginDTO outObject = new GameLoginDTO();
		mapToDTO(inObject, outObject);
		return outObject;
	}	
	
	public static void mapToEntity(GameLoginDTO inObject, GameLoginCrud outObject) {		
		outObject.setName(inObject.getName());
		outObject.setEmail(inObject.getEmail());
		outObject.setPassword(inObject.getPassword());
		outObject.setId(inObject.getId());
	    outObject.setLogin(inObject.getPassword());
	    outObject.setFirstName(inObject.getFirstName());
	    outObject.setLastName(inObject.getLastName());
	    outObject.setActivated(inObject.getActivated());
	    outObject.setLangKey(inObject.getLangKey());
	    outObject.setImageUrl(inObject.getImageUrl());
	    outObject.setActivationKey(inObject.getActivationKey());
	    outObject.setResetKey(inObject.getResetKey());
	    outObject.setResetDate(inObject.getResetDate());
	    outObject.setUsername(inObject.getUsername());		
	}
	
	public static void mapToDTO(GameLoginCrud inObject, GameLoginDTO outObject) {
		outObject.setName(inObject.getName());
		outObject.setEmail(inObject.getEmail());
		outObject.setPassword(inObject.getPassword());
		outObject.setId(inObject.getId());
		
	    outObject.setLogin(inObject.getPassword());
	    outObject.setFirstName(inObject.getFirstName());
	    outObject.setLastName(inObject.getLastName());
	    outObject.setActivated(inObject.getActivated());
	    outObject.setLangKey(inObject.getLangKey());
	    outObject.setImageUrl(inObject.getImageUrl());
	    outObject.setActivationKey(inObject.getActivationKey());
	    outObject.setResetKey(inObject.getResetKey());
	    outObject.setResetDate(inObject.getResetDate());
	    outObject.setUsername(inObject.getUsername());	    
	    
	}
	
	public static List<GameLoginCrud> mapCollectionToEntities(List<GameLoginDTO> inObjects) {
		if(inObjects == null) {
			return new ArrayList<GameLoginCrud>();
		}				
		List<GameLoginCrud> objects = 		
				inObjects
				.stream()
				.map(u ->  GameLoginMapperCrud.getMappedEntity(u))
				.collect(Collectors.toList());
		return objects;
	}
	
	public static List<GameLoginDTO> mapCollectionToDTO(List<GameLoginCrud> inObjects) {
		if(inObjects == null) {
			return new ArrayList<GameLoginDTO>();
		}		
		
		List<GameLoginDTO> objects = 		
				inObjects
				.stream()
				.map(u ->  GameLoginMapperCrud.getMappedDTO(u))
				.collect(Collectors.toList());
		return objects;
	}

}
