package com.jtsolv.jtsolvcurr.gamedices.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "lkdg_step")
public class GameStepEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private Long attempts;
    
    @ManyToOne(fetch = FetchType.LAZY )	
    @JoinColumn(
    		name = "game_step_def_id"
    		, referencedColumnName = "id")       
    private GameStepDefEntity gameStepDefEntity;
   
    public GameStepEntity() {
        this.name = "";
        this.email = "";
    }
    
    public GameStepEntity(String name, String email) {
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

	public GameStepDefEntity getGameStepDefEntity() {
		return gameStepDefEntity;
	}

	public void setGameStepDefEntity(GameStepDefEntity gameStepDefEntity) {
		this.gameStepDefEntity = gameStepDefEntity;
	}

	public Long getAttempts() {
		return attempts;
	}

	public void setAttempts(Long attempts) {
		this.attempts = attempts;
	}

}
