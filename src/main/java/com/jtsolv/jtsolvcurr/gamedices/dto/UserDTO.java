package com.jtsolv.jtsolvcurr.gamedices.dto;

public class UserDTO {
    
    private Long id;
    private final String name;
    private final String email;
    
    public UserDTO() {
        this.name = "";
        this.email = "";
    }
    
    public UserDTO(String name, String email) {
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
