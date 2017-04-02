package br.com.oxi.laicnanifnalpym.repository.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import br.com.oxi.laicnanifnalpym.utils.enums.RecipeStatus;
/***
 * 
 * @author Ocean Cortez
 *
 */
@Entity
@Table(name = "recipe")
public class RecipeEntity implements Serializable {
	
	private static final long serialVersionUID = 5173454111565349243L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_recipe")
	private Long id;
		
	@NotNull
	@Column(name = "des_description")
	private String description;
	
	@NotNull
    @ManyToOne
    @JoinColumn(name="id_recipe_type")
    private RecipeTypeEntity recipeType;
	
	@NotNull
	@ManyToOne
    @JoinColumn(name="id_account")
	private AccountEntity account;	
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="id_user")
	private UserEntity user;	
	
	@Column(name = "ind_value")
	@NotNull
	private Double value;
	
	@Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "ind_recipe_status")
	private RecipeStatus recipeStatus;
	
    @Column(name = "dat_creation")
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date creationDate;
    

	public RecipeEntity() {
		
	}


	public RecipeEntity(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public RecipeTypeEntity getRecipeType() {
		return recipeType;
	}


	public void setRecipeType(RecipeTypeEntity recipeType) {
		this.recipeType = recipeType;
	}


	public AccountEntity getAccount() {
		return account;
	}


	public void setAccount(AccountEntity account) {
		this.account = account;
	}


	public UserEntity getUser() {
		return user;
	}


	public void setUser(UserEntity user) {
		this.user = user;
	}


	public Double getValue() {
		return value;
	}


	public void setValue(Double value) {
		this.value = value;
	}



	public Date getCreationDate() {
		return creationDate;
	}


	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}


	public RecipeStatus getRecipeStatus() {
		return recipeStatus;
	}


	public void setRecipeStatus(RecipeStatus recipeStatus) {
		this.recipeStatus = recipeStatus;
	}


	@Override
	public String toString() {
		return "RecipeEntity [id=" + id + ", description=" + description + ", recipeType=" + recipeType + ", account="
				+ account + ", user=" + user + ", value=" + value + ", recipeStatus=" + recipeStatus + ", creationDate="
				+ creationDate + "]";
	}



	

	
	
}
