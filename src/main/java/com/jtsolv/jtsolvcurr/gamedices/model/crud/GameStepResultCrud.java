package com.jtsolv.jtsolvcurr.gamedices.model.crud;

import jakarta.persistence.*;

@Entity
@Table(name = "lkdg_step_result")
public class GameStepResultCrud {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)	
    private Long id;
    private String name;
    private String email;
    
    @Column(name = "game_step_def_id")
    private Long gameStepDefId;
    
    @Column(name = "game_step_id")
    private Long gameStepId;
    
    public GameStepResultCrud() {
        this.name = "";
        this.email = "";
    }
    
    public GameStepResultCrud(String name, String email) {
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

	public Long getGameStepDefId() {
		return gameStepDefId;
	}

	public void setGameStepDefId(Long gameStepDefId) {
		this.gameStepDefId = gameStepDefId;
	}

	public Long getGameStepId() {
		return gameStepId;
	}

	public void setGameStepId(Long gameStepId) {
		this.gameStepId = gameStepId;
	}
}
