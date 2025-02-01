package com.jtsolv.jtsolvcurr.gamedices.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "lkdg_commerce_user")
public class UserEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private final String name;
    private final String email;
    
    public UserEntity() {
        this.name = "";
        this.email = "";
    }
    
    public UserEntity(String name, String email) {
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
