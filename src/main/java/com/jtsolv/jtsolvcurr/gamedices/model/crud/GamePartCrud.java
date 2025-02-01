package com.jtsolv.jtsolvcurr.gamedices.model.crud;

import jakarta.persistence.*;

@Entity
@Table(name = "lkdg_part")
public class GamePartCrud {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)	
    private Long id;
    private String name;
    private String email;
    
    public GamePartCrud() {
        this.name = "";
        this.email = "";
    }
    
    public GamePartCrud(String name, String email) {
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
}
