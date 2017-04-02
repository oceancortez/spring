package br.com.oxi.laicnanifnalpym.utils.enums;

/**
 * 
 */
public enum RecipeStatus {
	FIXED("FIXO"),
	OPEN("OPEN"),
	RECEIVED("RECEIVED");
	
	public String status;
	
	private RecipeStatus(String s){
		status = s;
	}
	
    public String getStatus(){
    	return status;
    } 
}
