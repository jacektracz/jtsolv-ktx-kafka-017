package com.jtsolv.jtsolvcurr.gamedices.dto;

public class GameObjectDTO {
    
    private Long id;
    private String name;
    private String email;
    private Long numberOfParts;
    
    
	private GameStepDefDTO gameStepDef;
        
    public GameObjectDTO() {
        this.name = "";
        this.email = "";
    }
    
    public GameObjectDTO(String name, String email) {
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

	public void setGameStepDef(GameStepDefDTO gameStepDef) {
		this.gameStepDef = gameStepDef;
	}

	public Long getNumberOfParts() {
		return numberOfParts;
	}

	public void setNumberOfParts(Long numberOfParts) {
		this.numberOfParts = numberOfParts;
	}
}
