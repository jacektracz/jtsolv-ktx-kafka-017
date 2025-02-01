package com.jtsolv.jtsolvcurr.gamedices.service.admin;

import com.jtsolv.jtsolvcurr.gamedices.dto.GameItemResultDTO;
import com.jtsolv.jtsolvcurr.gamedices.mappers.crud.GameItemResultMapperCrud;
import com.jtsolv.jtsolvcurr.gamedices.mappers.entity.GameItemResultMapperEntity;
import com.jtsolv.jtsolvcurr.gamedices.model.crud.GameItemResultCrud;
import com.jtsolv.jtsolvcurr.gamedices.model.entity.GameItemResultEntity;
import com.jtsolv.jtsolvcurr.gamedices.repository.crud.GameItemResultRepositoryCrud;
import com.jtsolv.jtsolvcurr.gamedices.repository.entity.GameItemResultRepositoryEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GameItemResultService  {

    private GameItemResultRepositoryEntity gameItemResultRepositoryEntity;
    private GameItemResultRepositoryCrud gameItemResultRepositoryCrud;
    
    public GameItemResultService(
    		final GameItemResultRepositoryEntity gameItemResultRepository
    		,final GameItemResultRepositoryCrud gameItemResultRepositoryCrud) {
        this.gameItemResultRepositoryEntity = gameItemResultRepository;
        this.gameItemResultRepositoryCrud = gameItemResultRepositoryCrud;
    }
    
    public GameItemResultDTO create(final GameItemResultDTO gameItemResultDTO) {
    	try {    		
	    	final GameItemResultEntity objToSave =  GameItemResultMapperEntity.getMappedEntity(gameItemResultDTO);
	    	final GameItemResultEntity retObj =  this.gameItemResultRepositoryEntity.save(objToSave);
	    	final GameItemResultDTO retObjDTO =  GameItemResultMapperEntity.getMappedDTO(retObj);    	
	    	return retObjDTO;
    	}catch(Exception ex) {
    		throw ex;
    	}
    }
    
    public GameItemResultDTO createCrud(final GameItemResultDTO gameItemResultDTO) {
    	try {    		
	    	final GameItemResultCrud objToSave =  GameItemResultMapperCrud.getMappedEntity(gameItemResultDTO);
	    	final GameItemResultCrud retObj =  this.gameItemResultRepositoryCrud.save(objToSave);
	    	final GameItemResultDTO retObjDTO =  GameItemResultMapperCrud.getMappedDTO(retObj);    	
	    	return retObjDTO;
    	}catch(Exception ex) {
    		throw ex;
    	}
    }
    
    public List<GameItemResultDTO> findAll() {
        List<GameItemResultEntity> objs = gameItemResultRepositoryEntity.findAll();
        List<GameItemResultDTO> objsDTO =  GameItemResultMapperEntity.mapCollectionToDTO(objs);
        return objsDTO;
    }
}
