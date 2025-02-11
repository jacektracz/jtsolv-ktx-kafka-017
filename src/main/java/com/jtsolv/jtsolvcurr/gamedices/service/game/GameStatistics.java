package com.jtsolv.jtsolvcurr.gamedices.service.game;

import com.jtsolv.jtsolvcurr.gamedices.engine.DiceRollResult;

public class GameStatistics {
	
	private Double hitsCumulatively;
	private Double percentageCumulatively;
	private Long gameStepResultId; 
	private int currentValue ;
	private  DiceRollResult distributionData ;
	private int resultsToAchieve;
	private int stateCombinations;
	private String strInfo;
	private int maxValueToAchieve;
	private int minValueToAchieve;
	private Long gameStepDefId;
	private Long numberOfAttempts;
	public Double getHitsCumulatively() {
		return hitsCumulatively;
	}
	public void setHitsCumulatively(Double hitsCumulatively) {
		this.hitsCumulatively = hitsCumulatively;
	}
	public Double getPercentageCumulatively() {
		return percentageCumulatively;
	}
	public void setPercentageCumulatively(Double percentageCumulatively) {
		this.percentageCumulatively = percentageCumulatively;
	}
	public Long getGameStepResultId() {
		return gameStepResultId;
	}
	public void setGameStepResultId(Long gameStepResultId) {
		this.gameStepResultId = gameStepResultId;
	}
	public int getCurrentValue() {
		return currentValue;
	}
	public void setCurrentValue(int currentValue) {
		this.currentValue = currentValue;
	}
	public DiceRollResult getDistributionData() {
		return distributionData;
	}
	public void setDistributionData(DiceRollResult distributionData) {
		this.distributionData = distributionData;
	}
	public int getResultsToAchieve() {
		return resultsToAchieve;
	}
	public void setResultsToAchieve(int resultsToAchieve) {
		this.resultsToAchieve = resultsToAchieve;
	}
	public int getStateCombinations() {
		return stateCombinations;
	}
	public void setStateCombinations(int stateCombinations) {
		this.stateCombinations = stateCombinations;
	}
	public String getStrInfo() {
		return strInfo;
	}
	public void setStrInfo(String strInfo) {
		this.strInfo = strInfo;
	}
	public int getMaxValueToAchieve() {
		return maxValueToAchieve;
	}
	public void setMaxValueToAchieve(int maxValueToAchieve) {
		this.maxValueToAchieve = maxValueToAchieve;
	}
	public int getMinValueToAchieve() {
		return minValueToAchieve;
	}
	public void setMinValueToAchieve(int minValueToAchieve) {
		this.minValueToAchieve = minValueToAchieve;
	}
	public Long getGameStepDefId() {
		return gameStepDefId;
	}
	public void setGameStepDefId(Long gameStepDefId) {
		this.gameStepDefId = gameStepDefId;
	}
	public Long getNumberOfAttempts() {
		return numberOfAttempts;
	}
	public void setNumberOfAttempts(Long numberOfAttempts) {
		this.numberOfAttempts = numberOfAttempts;
	}
}
