package com.jtsolv.jtsolvcurr.gamedices.model.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "lkdg_step_result")
public class GameStepResultEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
   

    @OneToOne(fetch = FetchType.LAZY )	
    @JoinColumn(
    		name = "game_step_id"
    		, referencedColumnName = "id")       
    private GameStepEntity gameStep;
    
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(
    		name = "game_step_result_id", 
    		referencedColumnName = "id")           
    private List<GameItemResultEntity> gameItemResults;

    public GameStepResultEntity() {
        this.name = "";
        this.email = "";
    }
    
    public GameStepResultEntity(String name, String email) {
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

	public List<GameItemResultEntity> getGameItemResults() {
		return gameItemResults;
	}

	public void setGameItemResults(List<GameItemResultEntity> gameItemResults) {
		this.gameItemResults = gameItemResults;
	}

	public GameStepEntity getGameStep() {
		return gameStep;
	}

	public void setGameStep(GameStepEntity gameStep) {
		this.gameStep = gameStep;
	}
}
