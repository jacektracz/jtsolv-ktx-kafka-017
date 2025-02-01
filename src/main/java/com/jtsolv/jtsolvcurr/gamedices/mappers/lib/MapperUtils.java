package com.jtsolv.jtsolvcurr.gamedices.mappers.lib;



import com.jtsolv.jtsolvcurr.gamedices.dto.filters.GameGenericFilterDTO;

public class MapperUtils {
	
	public static Long getMappedId(Long id) {
		if(id != null && id != 0) {
			return id;
		}
		return Long.valueOf(0);		
	}
	
	public static Long getMappedId(int id) {
		return Long.valueOf(id);
	}
	
	public static int getMappedId2Int(Long id) {
		return id.intValue();
	}
	
	public static Long getIdFromGenericFilter(final GameGenericFilterDTO filter) {
    	Long idEmpty = Long.valueOf(0);
    	if(filter.getId() == null 
    			|| filter.getId().getId() == null){
    		return idEmpty;
    	}
    	Long id = Long.valueOf(filter.getId().getId());
    	return id;
	}
}
