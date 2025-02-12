package com.jtsolv.jtsolvcurr.gamedices.service.admin;

import com.jtsolv.jtsolvcurr.gamedices.dto.GameStepResultDTO;
import com.jtsolv.jtsolvcurr.gamedices.dto.filters.GameGenericFilterDTO;
import com.jtsolv.jtsolvcurr.gamedices.mappers.crud.GameStepResultMapperCrud;
import com.jtsolv.jtsolvcurr.gamedices.mappers.entity.GameStepResultMapperEntity;
import com.jtsolv.jtsolvcurr.gamedices.mappers.lib.MapperUtils;
import com.jtsolv.jtsolvcurr.gamedices.model.crud.GameStepResultCrud;
import com.jtsolv.jtsolvcurr.gamedices.model.entity.GameStepResultEntity;
import com.jtsolv.jtsolvcurr.gamedices.repository.crud.GameStepResultRepositoryCrud;
import com.jtsolv.jtsolvcurr.gamedices.repository.entity.GameStepResultRepositoryEntity;
import com.jtsolv.jtsolvcurr.gamedices.service.game.DicesGameExecutorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GameStepResultService  {

    private final GameStepResultRepositoryEntity gameStepResultRepositoryEntity;
    private final GameStepResultRepositoryCrud gameStepResultRepositoryCrud;
    private final DicesGameExecutorService dicesGameExecutorService;
    public GameStepResultService(
    		final GameStepResultRepositoryEntity gameStepResultRepository,
    		final GameStepResultRepositoryCrud gameStepResultRepositoryCrud,
    		final DicesGameExecutorService dicesGameExecutorService) {
        this.gameStepResultRepositoryEntity = gameStepResultRepository;
        this.gameStepResultRepositoryCrud = gameStepResultRepositoryCrud;
        this.dicesGameExecutorService = dicesGameExecutorService;
    }
    
    public GameStepResultDTO create(final GameStepResultDTO gameStepResultDTO) {
    	try {    		
	    	final GameStepResultEntity objToSave =  GameStepResultMapperEntity.getMappedEntity(gameStepResultDTO);
			objToSave.setId(null);
	    	final GameStepResultEntity retObj =  this.gameStepResultRepositoryEntity.save(objToSave);
	    	final GameStepResultDTO retObjDTO =  GameStepResultMapperEntity.getMappedDTO(retObj,true);    	
	    	return retObjDTO;
    	}catch(Exception ex) {
    		throw ex;
    	}
    }
    
    public GameStepResultDTO createCrud(final GameStepResultDTO gameStepResultDTO) {
    	try {    		
	    	final GameStepResultCrud objToSave =  GameStepResultMapperCrud.getMappedEntity(gameStepResultDTO);
			objToSave.setId(null);
	    	final GameStepResultCrud retObj =  this.gameStepResultRepositoryCrud.save(objToSave);
	    	final GameStepResultDTO retObjDTO =  GameStepResultMapperCrud.getMappedDTO(retObj);    	
	    	return retObjDTO;
    	}catch(Exception ex) {
    		throw ex;
    	}
    }
    
    public List<GameStepResultDTO> findAll() {
        final List<GameStepResultEntity> objs = gameStepResultRepositoryEntity.findAll();
        final List<GameStepResultDTO> objsDTO =  GameStepResultMapperEntity.mapCollectionToDTO(objs);
        return objsDTO;
    }
    
    
    public List<GameStepResultDTO> findByGenericFilter(final GameGenericFilterDTO filter) {        
        List<GameStepResultDTO> objsDTO =  findItemsById(filter);
        return objsDTO;
    }
    
    public List<GameStepResultDTO> findItemsById(final GameGenericFilterDTO filter) {
    	final List<GameStepResultDTO> emptyListDTO = new ArrayList<>();
    	Long id = MapperUtils.getIdFromGenericFilter(filter); 
    	if(id == 0) {
    		return emptyListDTO;
    	}
    	final Optional<GameStepResultEntity> entity = gameStepResultRepositoryEntity.findById(id);
    	if(!entity.isPresent()) {
    		return emptyListDTO;
    	}
    	
    	final List<GameStepResultEntity> objsEntity = new ArrayList<>();
    	objsEntity.add(entity.get());
    	final List<GameStepResultDTO>objsDTO =  GameStepResultMapperEntity.mapCollectionToDTO(objsEntity);
        return objsDTO;
        
    }
    
}
