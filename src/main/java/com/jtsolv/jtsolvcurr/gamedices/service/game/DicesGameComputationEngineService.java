package com.jtsolv.jtsolvcurr.gamedices.service.game;

import com.jtsolv.jtsolvcurr.gamedices.model.crud.GameItemResultCrud;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DicesGameComputationEngineService {
	
	
	public GameItemResultCrud computeItemResult(final GameItemResultCrud resultToSave) {
		
	    Double percentage = (double)nLong(resultToSave.getStateValueAchieved())/(double)nLong(resultToSave.getNumberOfAttempts());
	    percentage = percentage * 100;
	    //resultToSave.setHitsCumulatively(nDouble(resultToSave.getHitsCumulatively()) + nLong(resultToSave.getStateValueAchieved()));
	    Double percentageCumulatively = ((double)nDouble(resultToSave.getHitsCumulatively())/(double)nLong(resultToSave.getNumberOfAttempts())) * 100;
	    resultToSave.setPercentageCumulatively(nDouble(resultToSave.getHitsCumulatively())/nLong(resultToSave.getNumberOfAttempts()));	    
	    resultToSave.setStateValuePercentage(percentage);
	    resultToSave.setPercentageCumulatively(percentageCumulatively);
	    return resultToSave;	    
	}
	
	private static Long nLong(Long value) {
		if (value == null) {
			return Long.valueOf(0);
		}
		return value;
	}
	
	private static Double nDouble(Double value) {
		if (value == null) {
			return Double.valueOf(0);
		}
		return value;
	}
	
}

