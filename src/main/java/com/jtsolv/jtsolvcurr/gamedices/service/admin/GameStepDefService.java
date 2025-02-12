package com.jtsolv.jtsolvcurr.gamedices.service.admin;

import com.jtsolv.jtsolvcurr.gamedices.dto.GameStepDefDTO;
import com.jtsolv.jtsolvcurr.gamedices.mappers.crud.GameStepDefMapperCrud;
import com.jtsolv.jtsolvcurr.gamedices.mappers.entity.GameStepDefMapperEntity;
import com.jtsolv.jtsolvcurr.gamedices.model.crud.GameStepDefCrud;
import com.jtsolv.jtsolvcurr.gamedices.model.entity.GameStepDefEntity;
import com.jtsolv.jtsolvcurr.gamedices.repository.crud.GameStepDefRepositoryCrud;
import com.jtsolv.jtsolvcurr.gamedices.repository.entity.GameStepDefRepositoryEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GameStepDefService  {

    private GameStepDefRepositoryEntity gameStepDefRepositoryEntity;
    private GameStepDefRepositoryCrud gameStepDefRepositoryCrud;
    
    public GameStepDefService(
    		final GameStepDefRepositoryEntity gameStepDefRepository
    		,final GameStepDefRepositoryCrud gameStepDefRepositoryCrud) {
        this.gameStepDefRepositoryEntity = gameStepDefRepository;
        this.gameStepDefRepositoryCrud = gameStepDefRepositoryCrud;
    }
    
    public GameStepDefDTO create(final GameStepDefDTO gameStepDefDTO) {
    	try {    		
	    	final GameStepDefEntity objToSave =  GameStepDefMapperEntity.getMappedEntity(gameStepDefDTO);
			objToSave.setId(null);
	    	final GameStepDefEntity retObj =  this.gameStepDefRepositoryEntity.save(objToSave);
	    	final GameStepDefDTO retObjDTO =  GameStepDefMapperEntity.getMappedDTO(retObj,true);    	
	    	return retObjDTO;
    	}catch(Exception ex) {
    		throw ex;
    	}
    }
    
    public GameStepDefDTO createCrud(final GameStepDefDTO gameStepDefDTO) {
    	try {    		
	    	final GameStepDefCrud objToSave =  GameStepDefMapperCrud.getMappedEntity(gameStepDefDTO);
			objToSave.setId(null);
	    	final GameStepDefCrud retObj =  this.gameStepDefRepositoryCrud.save(objToSave);
	    	final GameStepDefDTO retObjDTO =  GameStepDefMapperCrud.getMappedDTO(retObj);    	
	    	return retObjDTO;
    	}catch(Exception ex) {
    		throw ex;
    	}
    }
    
    public List<GameStepDefDTO> findAll() {
		try {
			List<GameStepDefEntity> objs = gameStepDefRepositoryEntity.findAll();
			List<GameStepDefDTO> objsDTO =  GameStepDefMapperEntity.mapCollectionToDTO(objs);
			return objsDTO;
		} catch(Exception ex) {
			throw ex;
		}
    }
}
