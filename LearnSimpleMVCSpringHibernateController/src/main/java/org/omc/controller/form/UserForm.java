/**
 * 
 */
package org.omc.controller.form;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author omc
 *
 */

public class UserForm {
	

	private Integer idUsuario;
	
	private String nome;
	
	private String email;	

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private Date dtUltAlt;

	private String message;
	
	public UserForm() {
		
	}
	
	public UserForm(Integer idUsuario, String nome, String email) {
		this.setIdUsuario(idUsuario);
		this.nome = nome;
		this.email = email;
	}

	public UserForm(String message) {
		this.message = message;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}



	public Date getDtUltAlt() {
		return dtUltAlt;
	}

	public void setDtUltAlt(Date dtUltAlt) {
		this.dtUltAlt = dtUltAlt;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the idUsuario
	 */
	public Integer getIdUsuario() {
		return idUsuario;
	}

	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

}
