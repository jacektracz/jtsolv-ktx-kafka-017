package com.jtsolv.jtsolvcurr.gamedices.model.crud;

import jakarta.persistence.*;

@Entity
@Table(name = "lkdg_item_result")
public class GameItemResultCrud {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)	
	private Long id;
    private String name;
    private String email;    
    private Long achieved;
    private Long stateValue;
    private Long stateValueAchieved;
    private Long numberOfAttempts;
    private Long stateCombinations;
    private Double stateValuePercentage;
    private Double percentageCumulatively;
    private Double hitsCumulatively;
    private String gameResultItemType;
    
	@Column(name = "game_step_result_id")  
	private Long gameStepResultId;
	
	@Column(name = "game_step_def_id")  
	private Long gameStepDefId;
	
    public GameItemResultCrud() {
        this.name = "";
        this.email = "";
        this.stateValue = Long.valueOf(0);        
    }
    
    public GameItemResultCrud(String name, String email) {
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

	public Long getGameStepResultId() {
		return gameStepResultId;
	}

	public void setGameStepResultId(Long gameStepResultId) {
		this.gameStepResultId = gameStepResultId;
	}

	public Long getStateValue() {
		return stateValue;
	}

	public void setStateValue(Long stateValue) {
		this.stateValue = stateValue;
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

	public Long getStateValueAchieved() {
		return stateValueAchieved;
	}

	public void setStateValueAchieved(Long stateValueAchieved) {
		this.stateValueAchieved = stateValueAchieved;
	}

	public Double getPercentageCumulatively() {
		return percentageCumulatively;
	}

	public void setPercentageCumulatively(Double percentageCumulatively) {
		this.percentageCumulatively = percentageCumulatively;
	}

	public Long getGameStepDefId() {
		return gameStepDefId;
	}

	public void setGameStepDefId(Long gameStepDefResultId) {
		this.gameStepDefId = gameStepDefResultId;
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
