package br.com.oxi.laicnanifnalpym.repository.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

/***
 * 
 * @author Ocean Cortez
 *
 */
@Entity
@Table(name = "recipe_type")
public class RecipeTypeEntity implements Serializable {

	private static final long serialVersionUID = 3033488069889205112L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_recipe_type")
	private Long id;

	@NotNull
	@Column(name = "nam_recipe_type")
	private String type;

	@NotNull
	@Column(name = "nam_recipe_subtype")
	private String subType;

	@ManyToOne
	@JoinColumn(name = "id_user")
	private UserEntity idUser;

	@Transient
	private Set<RecipeTypeEntity> listRecipeTypeEntities;

	public RecipeTypeEntity() {

	}

	public RecipeTypeEntity(Long id) {
		super();
		this.id = id;
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

	public Set<RecipeTypeEntity> getListRecipeTypeEntities() {
		return listRecipeTypeEntities;
	}

	public void setListRecipeTypeEntities(Set<RecipeTypeEntity> listRecipeTypeEntities) {
		this.listRecipeTypeEntities = listRecipeTypeEntities;
	}

	public UserEntity getIdUser() {
		return idUser;
	}

	public void setIdUser(UserEntity idUser) {
		this.idUser = idUser;
	}

	@Override
	public String toString() {
		return "RecipeTypeEntity [id=" + id + ", type=" + type + ", subType=" + subType + ", idUser=" + idUser
				+ ", listRecipeTypeEntities=" + listRecipeTypeEntities + "]";
	}

}
