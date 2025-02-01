package com.jtsolv.jtsolvcurr.gamedices.dto;

import java.util.List;

public class GameItemDTO {
    
    private Long id;
    private String name;
    private String email;        
    private Long attempts;
    
    private List<GameItemResultDTO> gameItemResult;
    
    public GameItemDTO() {
        this.name = "";
        this.email = "";
    }
    
    public GameItemDTO(String name, String email) {
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

	public Long getAttempts() {
		return attempts;
	}

	public void setAttempts(Long attempts) {
		this.attempts = attempts;
	}

	public List<GameItemResultDTO> getGameItemResult() {
		return gameItemResult;
	}

	public void setGameItemResult(List<GameItemResultDTO> gameItemResult) {
		this.gameItemResult = gameItemResult;
	}
}
