package com.jtsolv.jtsolvcurr.gamedices.service.admin;

import com.jtsolv.jtsolvcurr.gamedices.dto.GameStepDTO;
import com.jtsolv.jtsolvcurr.gamedices.mappers.crud.GameStepMapperCrud;
import com.jtsolv.jtsolvcurr.gamedices.mappers.entity.GameStepMapperEntity;
import com.jtsolv.jtsolvcurr.gamedices.model.crud.GameStepCrud;
import com.jtsolv.jtsolvcurr.gamedices.model.entity.GameStepEntity;
import com.jtsolv.jtsolvcurr.gamedices.repository.crud.GameStepRepositoryCrud;
import com.jtsolv.jtsolvcurr.gamedices.repository.entity.GameStepRepositoryEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GameStepService  {

    private GameStepRepositoryEntity gameStepRepositoryEntity;
    private GameStepRepositoryCrud gameStepRepositoryCrud;
    
    public GameStepService(
    		final GameStepRepositoryEntity gameStepRepository
    		,final GameStepRepositoryCrud gameStepRepositoryCrud) {
        this.gameStepRepositoryEntity = gameStepRepository;
        this.gameStepRepositoryCrud = gameStepRepositoryCrud;
    }
    
    public GameStepDTO create(final GameStepDTO gameStepDTO) {
    	try {    		
	    	final GameStepEntity objToSave =  GameStepMapperEntity.getMappedEntity(gameStepDTO);
			objToSave.setId(null);
	    	final GameStepEntity retObj =  this.gameStepRepositoryEntity.save(objToSave);
	    	final GameStepDTO retObjDTO =  GameStepMapperEntity.getMappedDTO(retObj,true);    	
	    	return retObjDTO;
    	}catch(Exception ex) {
    		throw ex;
    	}
    }
    
    public GameStepDTO createCrud(final GameStepDTO gameStepDTO) {
    	try {    		
	    	final GameStepCrud objToSave =  GameStepMapperCrud.getMappedEntity(gameStepDTO);
			objToSave.setId(null);
	    	final GameStepCrud retObj =  this.gameStepRepositoryCrud.save(objToSave);
	    	final GameStepDTO retObjDTO =  GameStepMapperCrud.getMappedDTO(retObj);    	
	    	return retObjDTO;
    	}catch(Exception ex) {
    		throw ex;
    	}
    }
    
    public List<GameStepDTO> findAll() {
		try {
			List<GameStepEntity> objs = gameStepRepositoryEntity.findAll();
			List<GameStepDTO> objsDTO =  GameStepMapperEntity.mapCollectionToDTO(objs);
			return objsDTO;
		}catch(Exception ex) {
			throw ex;
		}

    }
}
