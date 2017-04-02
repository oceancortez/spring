package br.com.oxi.laicnanifnalpym.utils.enums;

import java.io.Serializable;

public class MessageForm implements Serializable {
	
	
	private static final long serialVersionUID = -8736072952132192827L;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "MessageForm [message=" + message + "]";
	}
	
	
	
	
	

}
