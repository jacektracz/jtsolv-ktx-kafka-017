package com.jtsolv.jtsolvcurr.gamedices.model.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "lkdg_step_def")
public class GameStepDefEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private Long attempts;
    private Long objectsNumber;
    @OneToMany(
    		fetch = FetchType.LAZY)
    @JoinColumn(
    		name = "game_step_def_id"
    		, referencedColumnName = "id")      
    private List<GameObjectEntity> gameObjects;
    
    @OneToOne(fetch = FetchType.LAZY )	
    @JoinColumn(
    		name = "primary_game_object_id"
    		, referencedColumnName = "id")
    private GameObjectEntity primaryGameObject;
    
    @OneToMany
    @JoinColumn(
    		name = "game_step_def_id"
    		, referencedColumnName = "id")  
    private List<GameStepEntity> referencedGameSteps;
    
    @OneToMany(fetch = FetchType.LAZY)    
    @JoinColumn(
    		name = "game_step_def_id"
    		, referencedColumnName = "id")              
    private List<GameItemResultEntity> gameItemResults;
    
    public GameStepDefEntity() {
        this.setName("");
        this.email = "";
    }
    
    public GameStepDefEntity(String name, String email) {
        this.setName(name);
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
        return "User{" + "id=" + id + ", name=" + getName() + ", email=" + email + '}';
    }

	public Long getAttempts() {
		return attempts;
	}

	public void setAttempts(Long attempts) {
		this.attempts = attempts;
	}

	public List<GameObjectEntity> getGameObjects() {
		return gameObjects;
	}

	public void setGameObjects(List<GameObjectEntity> gameObjects) {
		this.gameObjects = gameObjects;
	}

	public GameObjectEntity getPrimaryGameObject() {
		return primaryGameObject;
	}

	public void setPrimaryGameObject(GameObjectEntity primaryGameObject) {
		this.primaryGameObject = primaryGameObject;
	}

	public List<GameStepEntity> getReferencedGameSteps() {
		return referencedGameSteps;
	}

	public void setReferencedGameSteps(List<GameStepEntity> referencedGameSteps) {
		this.referencedGameSteps = referencedGameSteps;
	}

	public Long getObjectsNumber() {
		return objectsNumber;
	}

	public void setObjectsNumber(Long objectsNumber) {
		this.objectsNumber = objectsNumber;
	}

	public List<GameItemResultEntity> getGameItemResults() {
		return gameItemResults;
	}

	public void setGameItemResults(List<GameItemResultEntity> gameItemResults) {
		this.gameItemResults = gameItemResults;
	}

	
}
