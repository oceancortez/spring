/**
 * 
 */
package org.omc.dao.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author omc
 *
 */
@Entity
@Table(name = "usuario")
public class UsuarioEntity {
	
	@Id
	private Integer id;
	
	private String nome;
	
	public UsuarioEntity() {
		// TODO Auto-generated constructor stub
	}

	public UsuarioEntity(Integer id, String nome) {
		this.id = id;
		this.nome = nome;	}

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

}
