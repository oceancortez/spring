package org.omc.util;

import java.util.ArrayList;
import java.util.List;

public class UserOut {
	
	private UserForm userForm;

	private String message;
	
	private List<UserForm> users;
	
	private Integer codStatus;
	
	public UserOut(String message, List<UserForm> users, Integer codStatus) {
		this.message = message;
		this.users = users;
		this.codStatus = codStatus;
	}
	
	public UserOut() {
	}

	/**
	 * @return the userForm
	 */
	public UserForm getUserForm() {
		return userForm;
	}

	/**
	 * @param userForm the userForm to set
	 */
	public void setUserForm(UserForm userForm) {
		this.userForm = userForm;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the users
	 */
	public List<UserForm> getUsers() {
		if(users == null){
			users = new ArrayList<UserForm>();
		}
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(List<UserForm> users) {
		this.users = users;
	}

	/**
	 * @return the codStatus
	 */
	public Integer getCodStatus() {
		return codStatus;
	}

	/**
	 * @param codStatus the codStatus to set
	 */
	public void setCodStatus(Integer codStatus) {
		this.codStatus = codStatus;
	}

}
