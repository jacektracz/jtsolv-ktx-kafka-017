package com.jtsolv.jtsolvcurr.gamedices.dto.filters;

public class GameGenericFilterValueDTO {
	    
	    private String id;
	    private  String name;
	    private  String value;
	    
	    public GameGenericFilterValueDTO() {
	    }
	    
	    public String getId() {
	        return id;
	    }
	    
		public void setId(String id) {
			this.id = id;
		}
		
	    public String getName() {
	        return name;
	    }
	    
		public void setName(String name) {
			this.name = name;
		}

		public void setValue(String email) {
			this.value = email;
		}
	    
	    public String getValue() {
	        return value;
	    }
	    
	    @Override
	    public String toString() {
	        return "User{" + "id=" + id + ", name=" + name + ", email=" + value + '}';
	    }
}


