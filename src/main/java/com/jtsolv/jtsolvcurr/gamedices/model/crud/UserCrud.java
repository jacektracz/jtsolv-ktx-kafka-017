package com.jtsolv.jtsolvcurr.gamedices.model.crud;

import jakarta.persistence.*;

@Entity
@Table(name = "lkdg_user")
public class UserCrud {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)	
    private Long id;
    private final String name;
    private final String email;
    
    public UserCrud() {
        this.name = "";
        this.email = "";
    }
    
    public UserCrud(String name, String email) {
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
}
