package br.com.oxi.laicnanifnalpym.middleware.service.forms;

import java.io.Serializable;

/***
 *
 * @author Ocean Cortez
 *
 */

public class RecipeTypeForm implements Serializable {

    private static final long serialVersionUID = -4811644933092970338L;
    
	private Long id;
	
	private String type;
	
	private String subType;
	
	private Long userId;
	
	public RecipeTypeForm(){
		
	}	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}	
	

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "RecipeTypeForm [id=" + id + ", type=" + type + ", subType=" + subType + ", userId=" + userId + "]";
	}
	
}
