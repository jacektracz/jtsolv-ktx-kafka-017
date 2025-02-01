package com.jtsolv.jtsolvcurr.gamedices.model.crud;


import jakarta.persistence.*;

@Entity
@Table(name = "lkdg_object")
public class GameObjectCrud {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)		
    private Long id;
    private String name;
    private String email;
    private Long numberOfParts;
    
    @Column(
    		name = "game_step_def_id")    
	private Long gameStepDef;
        
    public GameObjectCrud() {
        this.name = "";
        this.email = "";
    }
    
    public GameObjectCrud(String name, String email) {
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

	public Long getGameStepDef() {
		return gameStepDef;
	}

	public void setGameStepDef(Long gameStepDef) {
		this.gameStepDef = gameStepDef;
	}

	public Long getNumberOfParts() {
		return numberOfParts;
	}

	public void setNumberOfParts(Long numberOfParts) {
		this.numberOfParts = numberOfParts;
	}
}
