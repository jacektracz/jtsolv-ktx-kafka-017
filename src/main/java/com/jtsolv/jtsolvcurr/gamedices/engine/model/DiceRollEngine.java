package com.jtsolv.jtsolvcurr.gamedices.engine.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;


@Service
public class DiceRollEngine {
	
	private final static Logger log = LoggerFactory.getLogger(DiceRollEngine.class);
	
	public void collectDisecRollResults(final DiceRollResult  data) {
		final Map<Integer,ResultEntry> results = collectDisecRollResult(
				data.getDices(),
				data.getDiceWalls(),
				data.getAttempts());
		data.setResults(results);
	}
	
	public static final Map<Integer,ResultEntry> collectDisecRollResult(
			final Integer dices, 
			final Integer diceWalls, 
			final Integer attempts) {
		final Map<Integer,ResultEntry> results = new HashMap<>();
		for( int ii = 1; ii <= attempts ; ii++) {			
			Integer randomSum = getDicesRollResult(dices, diceWalls);
			if(randomSum < dices) {
				randomSum = dices;
			}
			if(randomSum > dices * diceWalls) {
				randomSum = dices * diceWalls;
			}			
			log.debug("result-ii ii:" + ii + " result:" + randomSum);
			fillResult(results, randomSum);
		}
		return results;
	}

	public static void fillResult(final Map<Integer,ResultEntry> result, Integer sum) {
		if(!result.containsKey(sum)) {
			ResultEntry entry = new ResultEntry();
			entry.setValue(Long.valueOf(1));
			result.put(sum,entry);				
		}else {
			final ResultEntry entry = result.get(sum);
			Long value = entry.getValue();
			value = value + 1;
			entry.setValue(value);
		}					
	}
	
	public static Integer getDicesRollResult(Integer dices, Integer diceWalls) {
		
		Integer sum = IntStream.range(0, dices)
				.boxed()
				 .mapToInt(x -> getDiceRollResult(diceWalls))
				 .sum();
		return sum;
	}
	
	public static Integer getDiceRollResult(Integer diceWalls) {

		int randomWall = getRandom(1, diceWalls);			
		return randomWall;
		
	}
	public static int getRandom(int min, int max) {
		return generateRandomInteger(min,max);
	}
	
	public static int getRandom2(int min, int max) {
	      int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
	      return random_int;
	}
	
	public static int generateRandomInteger(int min, int max) {
	    SecureRandom rand = new SecureRandom();
	    rand.setSeed(new Date().getTime());
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    if(randomNum < min) {
	    	randomNum = min;
	    }
	    if(randomNum > max ) {
	    	randomNum = max;
	    }	    
	    return randomNum;
	}	
}
