package com.jtsolv.jtsolvcurr.gamedices.dto;

import java.util.List;


public class GameStepResultDTO {
    
    private Long id;
    private String name;
    private String email;
    private GameStepDefDTO gameStepDef;
    private GameStepDTO gameStep;
    private List<GameItemResultDTO> gameItemResults;
    
    public GameStepResultDTO() {
        this.name = "";
        this.email = "";
    }
    
    public GameStepResultDTO(String name, String email) {
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

	public GameStepDefDTO getGameStepDef() {
		return gameStepDef;
	}

	public void setGameStepDef(GameStepDefDTO gameStepDefDTO) {
		this.gameStepDef = gameStepDefDTO;
	}

	public List<GameItemResultDTO> getGameItemResults() {
		return gameItemResults;
	}

	public void setGameItemResults(List<GameItemResultDTO> gameItemResults) {
		this.gameItemResults = gameItemResults;
	}

	public GameStepDTO getGameStep() {
		return gameStep;
	}

	public void setGameStep(GameStepDTO gameStep) {
		this.gameStep = gameStep;
	}
}
