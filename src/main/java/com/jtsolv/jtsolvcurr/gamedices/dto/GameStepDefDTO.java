package com.jtsolv.jtsolvcurr.gamedices.dto;

import java.util.List;

public class GameStepDefDTO {
    
    private Long id;
    private String name;
    private String email;
    private Long attempts;
    private Long objectsNumber;    
    private List<GameObjectDTO> gameObjects;
    
    private GameObjectDTO primaryGameObject;
    
    public GameStepDefDTO() {
        this.name = "";
        this.email = "";
    }
    
    public GameStepDefDTO(String name, String email) {
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
        return "User{" + "id=" + getId() + ", name=" + getName() + ", email=" + email + '}';
    }

	public Long getAttempts() {
		return attempts;
	}

	public void setAttempts(Long attempts) {
		this.attempts = attempts;
	}

	public List<GameObjectDTO> getGameObjects() {
		return gameObjects;
	}

	public void setGameObjects(List<GameObjectDTO> gameObjects) {
		this.gameObjects = gameObjects;
	}

	public GameObjectDTO getPrimaryGameObject() {
		return primaryGameObject;
	}

	public void setPrimaryGameObject(GameObjectDTO primaryGameObjectDTO) {
		this.primaryGameObject = primaryGameObjectDTO;
	}

	public Long getObjectsNumber() {
		return objectsNumber;
	}

	public void setObjectsNumber(Long objectsNumber) {
		this.objectsNumber = objectsNumber;
	}

	
}
