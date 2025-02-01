package com.jtsolv.jtsolvcurr.gamedices.dto;

public class DiceDTO {
    
    private Long id;
    private  String name;
    private  String email;
    
    public DiceDTO() {
        this.name = "";
        this.email = "";
    }
    
    public DiceDTO(String name, String email) {
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
