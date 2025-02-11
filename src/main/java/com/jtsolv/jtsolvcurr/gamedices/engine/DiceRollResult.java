package com.jtsolv.jtsolvcurr.gamedices.engine;

import java.util.HashMap;
import java.util.Map;

public class DiceRollResult {

	private Map<Integer,ResultEntry> results = new HashMap<>();
	private Integer dices;
	private Integer diceWalls;
	private Integer attempts;
	private Long gameStepDef;
	
	public Map<Integer,ResultEntry> getResults() {
		return results;
	}

	public Integer getDices() {
		return dices;
	}

	public void setDices(Integer dices) {
		this.dices = dices;
	}

	public Integer getDiceWalls() {
		return diceWalls;
	}

	public void setDiceWalls(Integer diceWalls) {
		this.diceWalls = diceWalls;
	}

	public Integer getAttempts() {
		return attempts;
	}

	public void setAttempts(Integer attempts) {
		this.attempts = attempts;
	}

	public void setResults(Map<Integer,ResultEntry> results) {
		this.results = results;
	}

	public Long getGameStepDef() {
		return gameStepDef;
	}

	public void setGameStepDef(Long gameStepDef) {
		this.gameStepDef = gameStepDef;
	}
	
}
