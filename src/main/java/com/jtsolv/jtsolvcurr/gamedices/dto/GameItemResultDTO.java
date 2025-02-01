package com.jtsolv.jtsolvcurr.gamedices.dto;

public class GameItemResultDTO {
    
    private Long id;
    private String name;
    private String email;        
    private Long achieved; 
    private Long stateValue;    
    private Long stateValueAchieved;
    private Long stateCombinations;
    private Long numberOfAttempts;
    private Double stateValuePercentage;
    private Double percentageCumulatively;
    private GameStepResultDTO gameStepResult;        
    private String gameResultItemType;
    private Double hitsCumulatively;
    public GameItemResultDTO() {
        this.name = "";
        this.email = "";
    }
    
    public GameItemResultDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }
    
	public void setId(Long id) {
		this.id = id;
	}
	
    public String getName() {
        return name;
    }
    
	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
    public String getEmail() {
        return email;
    }

    
    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", email=" + email + '}';
    }

	public Long getAchieved() {
		return achieved;
	}

	public void setAchieved(Long achieved) {
		this.achieved = achieved;
	}

	public GameStepResultDTO getGameStepResult() {
		return gameStepResult;
	}

	public void setGameStepResult(GameStepResultDTO gameStepResult) {
		this.gameStepResult = gameStepResult;
	}

	public Long getStateValueAchieved() {
		return stateValueAchieved;
	}

	public void setStateValueAchieved(Long stateValueAchieved) {
		this.stateValueAchieved = stateValueAchieved;
	}

	public Long getStateCombinations() {
		return stateCombinations;
	}

	public void setStateCombinations(Long stateCombinations) {
		this.stateCombinations = stateCombinations;
	}

	public Double getStateValuePercentage() {
		return stateValuePercentage;
	}

	public void setStateValuePercentage(Double stateValuePercentage) {
		this.stateValuePercentage = stateValuePercentage;
	}

	public Long getStateValue() {
		return stateValue;
	}

	public void setStateValue(Long stateValue) {
		this.stateValue = stateValue;
	}

	public Double getPercentageCumulatively() {
		return percentageCumulatively;
	}

	public void setPercentageCumulatively(Double percentageCumulatively) {
		this.percentageCumulatively = percentageCumulatively;
	}

	public Long getNumberOfAttempts() {
		return numberOfAttempts;
	}

	public void setNumberOfAttempts(Long numberOfAttempts) {
		this.numberOfAttempts = numberOfAttempts;
	}

	public String getGameResultItemType() {
		return gameResultItemType;
	}

	public void setGameResultItemType(String gameResultItemType) {
		this.gameResultItemType = gameResultItemType;
	}

	public Double getHitsCumulatively() {
		return hitsCumulatively;
	}

	public void setHitsCumulatively(Double hitsCumulatively) {
		this.hitsCumulatively = hitsCumulatively;
	}

}
