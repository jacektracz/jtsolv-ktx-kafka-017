package com.jtsolv.jtsolvcurr.gamedices.model.crud;

import jakarta.persistence.*;

@Entity
@Table(name = "lkdg_step")
public class GameStepCrud {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)	
    private Long id;
    private String name;
    private String email;
    private Long attempts;
    
    @Column(name = "game_step_def_id")
    private Long gameStepDefId;
    
    public GameStepCrud() {
        this.name = "";
        this.email = "";
    }
    
    public GameStepCrud(String name, String email) {
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

	public Long getAttempts() {
		return attempts;
	}

	public void setAttempts(Long attempts) {
		this.attempts = attempts;
	}
}
