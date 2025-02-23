package com.jtsolv.jtsolvcurr.gamedices.service.admin;

import com.jtsolv.jtsolvcurr.logging.JTSolvGenericLogger;
import com.jtsolv.jtsolvcurr.gamedices.dto.GameLoginDTO;
import com.jtsolv.jtsolvcurr.gamedices.mappers.crud.GameLoginMapperCrud;
import com.jtsolv.jtsolvcurr.gamedices.mappers.entity.GameLoginMapperEntity;
import com.jtsolv.jtsolvcurr.gamedices.model.crud.GameLoginCrud;
import com.jtsolv.jtsolvcurr.gamedices.model.entity.GameLoginEntity;
import com.jtsolv.jtsolvcurr.gamedices.repository.crud.GameLoginRepositoryCrud;
import com.jtsolv.jtsolvcurr.gamedices.repository.entity.GameLoginRepositoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GameLoginService  {

    private final GameLoginRepositoryEntity gameLoginRepositoryEntity;
    private final GameLoginRepositoryCrud gameLoginRepositoryCrud;
    
	
	private final PasswordEncoder bcryptEncoder;

	@Autowired
    public GameLoginService(
    		final GameLoginRepositoryEntity gameLoginRepository,
    		final GameLoginRepositoryCrud gameLoginRepositoryCrud,
    		final PasswordEncoder bcryptEncoder) {
        this.gameLoginRepositoryEntity = gameLoginRepository;
        this.gameLoginRepositoryCrud = gameLoginRepositoryCrud;
        this.bcryptEncoder = bcryptEncoder;
    }
    
    public GameLoginDTO create(final GameLoginDTO gameLoginDTO) {
    	try {    		
	    	final GameLoginEntity objToSave =  GameLoginMapperEntity.getMappedEntity(gameLoginDTO);
	    	String encoded = bcryptEncoder.encode(gameLoginDTO.getPassword());
	    	objToSave.setPassword(encoded);	    	
	    	objToSave.setLogin(objToSave.getName());
	    	objToSave.setEmail(objToSave.getName());
	    	objToSave.setFirstName(objToSave.getName());
	    	objToSave.setLastName(objToSave.getName());
	    	objToSave.setUsername(objToSave.getName());
	    	objToSave.setLangKey("pl");
			objToSave.setId(null);
	    	final GameLoginEntity retObj =  this.gameLoginRepositoryEntity.save(objToSave);
	    	final GameLoginDTO retObjDTO =  GameLoginMapperEntity.getMappedDTO(retObj);    	
	    	return retObjDTO;
    	}catch(Exception ex) {
    		throw ex;
    	}
    }
    
    public GameLoginDTO createCrud(final GameLoginDTO gameLoginDTO) {
    	try {
    		String sMethod = "createCrud";
	    	logInfoEx(sMethod, "start");    		
	    	final GameLoginCrud objToSave =  GameLoginMapperCrud.getMappedEntity(gameLoginDTO);
	    	String passwd = gameLoginDTO.getPassword();
	    	String passwdEncoded = bcryptEncoder.encode(passwd);
	    	
	    	
	    	 
	    	logInfoEx(sMethod, "passwd" + passwd);
	    	logInfoEx(sMethod, "passwdEncoded:" + passwdEncoded);

	    	String passwdEncoded2 = bcryptEncoder.encode(passwd);
	    	 
	    	logInfoEx(sMethod, "passwd" + passwd);
	    	logInfoEx(sMethod, "passwdEncoded2:" + passwdEncoded);
	    	
	    	objToSave.setPassword(passwdEncoded);
	    	objToSave.setLogin(objToSave.getName());
	    	objToSave.setEmail(objToSave.getName());
	    	objToSave.setFirstName(objToSave.getName());
	    	objToSave.setLastName(objToSave.getName());
	    	objToSave.setUsername(objToSave.getName());
	    	objToSave.setLangKey("pl");
			objToSave.setId(null);
	    	final GameLoginCrud retObj =  this.gameLoginRepositoryCrud.save(objToSave);
	    	final GameLoginDTO retObjDTO =  GameLoginMapperCrud.getMappedDTO(retObj);
	    	logInfoEx(sMethod, "end");    		
	    	return retObjDTO;
    	}catch(Exception ex) {
    		throw ex;
    	}
    }
    
    public List<GameLoginDTO> findAll() {
        List<GameLoginEntity> objs = gameLoginRepositoryEntity.findAll();
        List<GameLoginDTO> objsDTO =  GameLoginMapperEntity.mapCollectionToDTO(objs);
        return objsDTO;
    }
    
    private String getDbgClassName() {
		return "com.lakida.gamedices.service.admin.GameLoginService";
	}
    
    public String logInfoEx(String p_fun, String p_cc)
    {
        
        String ss = "";
        JTSolvGenericLogger.logInfo(getDbgClassName() + ";" + p_fun + ":" + p_cc);
        return ss;
    }
    
}
