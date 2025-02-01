package com.jtsolv.jtsolvcurr.gamedices.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "lkdg_object_part")
public class GameObjectPartEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private final String name;
    private final String email;        
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
    		name = "game_object_id"
    		, referencedColumnName = "id")            
	private GameObjectEntity gameObject;
    
    public GameObjectPartEntity() {
        this.name = "";
        this.email = "";
    }
    
    public GameObjectPartEntity(String name, String email) {
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

	public GameObjectEntity getGameObject() {
		return gameObject;
	}

	public void setGameObject(GameObjectEntity gameObject) {
		this.gameObject = gameObject;
	}
}
