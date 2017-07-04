/**
 * 
 */
package org.omc.dao.entity;

/**
 * @author omc
 *
 */
public class UsuarioEntity {
	
	
	private Integer id;
	
	private String nome;

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
