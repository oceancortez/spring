package br.com.oxi.laicnanifnalpym.utils.enums;

/**
 * 
 */
public enum Status {
	
	ACTIVE("ACTIVE"),
	INACTIVE("INACTIVE"),
	CANCELLED("CANCELLED");
	
	public String status;
	
	private Status(String s){
		status = s;
	}
	
    public String getStatus(){
    	return status;
    } 
	
}
