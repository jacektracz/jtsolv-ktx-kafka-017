package com.jtsolv.jtsolvcurr.gamedices.dto.filters;

public class GameGenericFilterDTO {
	    
	    private GameGenericFilterValueDTO id;
	    private  GameGenericFilterValueDTO name;
	    private  GameGenericFilterValueDTO email;
	    
	    public GameGenericFilterDTO() {
	    }
	    
	    public GameGenericFilterValueDTO getId() {
	        return id;
	    }
	    
		public void setId(GameGenericFilterValueDTO id) {
			this.id = id;
		}
		
	    public GameGenericFilterValueDTO getName() {
	        return name;
	    }
	    
		public void setName(GameGenericFilterValueDTO name) {
			this.name = name;
		}

		public void setEmail(GameGenericFilterValueDTO email) {
			this.email = email;
		}
	    
	    public GameGenericFilterValueDTO getEmail() {
	        return email;
	    }
	    
	    @Override
	    public String toString() {
	        return "";
	    }
}


