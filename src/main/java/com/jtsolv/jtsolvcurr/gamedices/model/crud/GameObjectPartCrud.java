package com.jtsolv.jtsolvcurr.gamedices.model.crud;

import jakarta.persistence.*;

@Entity
@Table(name = "lkdg_object_part")
public class GameObjectPartCrud {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)	
    private Long id;
    private final String name;
    private final String email;        

    @Column(
    		name = "game_object_id")    
	private Long gameObjectId;
    
    public GameObjectPartCrud() {
        this.name = "";
        this.email = "";
    }
    
    public GameObjectPartCrud(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
    
    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", email=" + email + '}';
    }

	public Long getGameObjectId() {
		return gameObjectId;
	}

	public void setGameObjectId(Long gameObjectId) {
		this.gameObjectId = gameObjectId;
	}

}
