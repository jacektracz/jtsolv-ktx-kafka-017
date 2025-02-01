package com.jtsolv.jtsolvcurr.gamedices.dto;

public class GameStepDTO {
    
    private Long id;
    private String name;
    private String email;
    private Long attempts;
    private GameStepDefDTO gameStepDef;
     
    public GameStepDTO() {
        this.name = "";
        this.email = "";
    }
    
    public GameStepDTO(String name, String email) {
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

	public Long getAttempts() {
		return attempts;
	}

	public void setAttempts(Long attempts) {
		this.attempts = attempts;
	}
}
