package com.jtsolv.jtsolvcurr.gamedices.model.crud;


import jakarta.persistence.*;


@Entity
@Table(name = "lkdg_step_def")
public class GameStepDefCrud {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)	
    private Long id;
    private String name;
    private String email;
    private Long attempts;        
    private Long objectsNumber;
    
    @Column(name = "primary_game_object_id")        
    private Long primaryGameObject;
    
    public GameStepDefCrud() {
        this.setName("");
        this.email = "";
    }
    
    public GameStepDefCrud(String name, String email) {
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

	public void setPrimaryGameObject(Long primaryGameObject) {
		this.primaryGameObject = primaryGameObject;
	}

	public Long getPrimaryGameObject() {
		return this.primaryGameObject ;
	}

	public Long getObjectsNumber() {
		return objectsNumber;
	}

	public void setObjectsNumber(Long objectsNumber) {
		this.objectsNumber = objectsNumber;
	}

	
}
