/**
 * 
 */
package org.omc.dao.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * @author omc
 *
 */
@Entity
@Table(name = "usuario")
public class UsuarioEntity {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String nome;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_ult_alt")
	private Date dtUltAlt;
	
	@Transient
	private String message;
	
	public UsuarioEntity() {
		// TODO Auto-generated constructor stub
	}

	public UsuarioEntity(Integer id, String nome) {
		this.id = id;
		this.nome = nome;	}

	public UsuarioEntity(String message) {
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

}
