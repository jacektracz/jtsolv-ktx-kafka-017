package com.jtsolv.jtsolvcurr.gamedices.mappers.entity;

import com.jtsolv.jtsolvcurr.gamedices.dto.GameLoginDTO;
import com.jtsolv.jtsolvcurr.gamedices.model.entity.GameLoginEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class GameLoginMapperEntity {
    
	public static GameLoginEntity getMappedEntity(GameLoginDTO inObject) {
		if(inObject == null) {
			return null;
		}		
		GameLoginEntity outObject = new GameLoginEntity();
		mapToEntity(inObject, outObject);
		return outObject;
	}
	
	public static GameLoginDTO getMappedDTO(GameLoginEntity inObject) {
		if(inObject == null) {
			return null;
		}		
		GameLoginDTO outObject = new GameLoginDTO();
		mapToDTO(inObject, outObject);
		return outObject;
	}	
	
	public static void mapToEntity(GameLoginDTO inObject, GameLoginEntity outObject) {		
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
	
	public static void mapToDTO(GameLoginEntity inObject, GameLoginDTO outObject) {
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
	
	public static List<GameLoginEntity> mapCollectionToEntities(List<GameLoginDTO> inObjects) {
		if(inObjects == null) {
			return new ArrayList<GameLoginEntity>();
		}				
		List<GameLoginEntity> objects = 		
				inObjects
				.stream()
				.map(u ->  GameLoginMapperEntity.getMappedEntity(u))
				.collect(Collectors.toList());
		return objects;
	}
	
	public static List<GameLoginDTO> mapCollectionToDTO(List<GameLoginEntity> inObjects) {
		if(inObjects == null) {
			return new ArrayList<GameLoginDTO>();
		}		
		
		List<GameLoginDTO> objects = 		
				inObjects
				.stream()
				.map(u ->  GameLoginMapperEntity.getMappedDTO(u))
				.collect(Collectors.toList());
		return objects;
	}

}
