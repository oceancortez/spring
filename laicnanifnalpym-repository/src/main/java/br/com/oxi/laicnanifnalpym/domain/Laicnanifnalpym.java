package br.com.oxi.laicnanifnalpym.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("restriction")
@Entity
@XmlRootElement
@Table(name = "test_laicnanifnalpym")
public class Laicnanifnalpym implements Serializable {	
	/**
	 *@Ocean Cortez 
	 */
	private static final long serialVersionUID = -9137792318272327201L;
	
	@Id
	@GeneratedValue
	@Column(name = "idTest", nullable = false, unique  = true)
	private Long idTest;
	
	

	public Long getIdTest() {
		return idTest;
	}

	public void setIdTest(Long idTest) {
		this.idTest = idTest;
	}

	@Override
	public String toString() {
		return "TestLaicnanifnalpym [idTest=" + idTest + "]";
	}	
	
	

}
