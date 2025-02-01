package com.jtsolv.jtsolvcurr.gamedices.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "lkdg_item_result")
public class GameItemResultEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;        
    private Long achieved;
    private Long stateValue;
    private Long stateValueAchieved;
    private Long stateCombinations;
    private Double stateValuePercentage;
    private Double percentageCumulatively;
    private Long numberOfAttempts;
    private String gameResultItemType;
    private Double hitsCumulatively;
    @ManyToOne(fetch = FetchType.LAZY)    
    @JoinColumn(
    		name = "game_step_result_id"
    		, referencedColumnName = "id")               
	private GameStepResultEntity gameStepResult;        

    @ManyToOne(fetch = FetchType.LAZY)    
    @JoinColumn(
    		name = "game_step_def_id"
    		, referencedColumnName = "id")               
	private GameStepDefEntity gameStepDef;        
    
    public GameItemResultEntity() {
        this.name = "";
        this.email = "";
    }
    
    public GameItemResultEntity(String name, String email) {
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

	public GameStepResultEntity getGameStepResult() {
		return gameStepResult;
	}

	public void setGameStepResult(GameStepResultEntity gameStepResult) {
		this.gameStepResult = gameStepResult;
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
