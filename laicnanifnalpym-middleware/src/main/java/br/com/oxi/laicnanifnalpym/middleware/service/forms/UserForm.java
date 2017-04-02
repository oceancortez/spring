package br.com.oxi.laicnanifnalpym.middleware.service.forms;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.ws.rs.FormParam;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.oxi.laicnanifnalpym.repository.domain.AccountEntity;
import br.com.oxi.laicnanifnalpym.repository.domain.CreditCardEntity;
import br.com.oxi.laicnanifnalpym.repository.domain.RecipeTypeEntity;

/***
 * 
 * @author Ocean Cortez
 *
 */

public class UserForm implements Serializable {

	private static final long serialVersionUID = 2992246800475811177L;

	@FormParam("id")
	private Long id;
	
	@NotNull(message = "Campo Obrigatório")
    @NotEmpty(message = "Campo Obrigatório")
	@FormParam("nameUser")
	private String nameUser;

	@NotNull(message = "Campo Obrigatório")
    @NotEmpty(message = "Campo Obrigatório")
	@FormParam("email")
	private String email;
	
	@NotNull(message = "Campo Obrigatório")
    @NotEmpty(message = "Campo Obrigatório")
	@FormParam("password")
	private String password;

	@NotNull(message = "Campo Obrigatório")
    @NotEmpty(message = "Campo Obrigatório")
	@FormParam("confirmPassword")
	private String confirmPassword;
	
    private Set<AccountEntity> accounts;
        
    private Set<CreditCardEntity> creditCards;
        
    private Set<RecipeTypeEntity> recipeTypes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Set<AccountEntity> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<AccountEntity> accounts) {
		this.accounts = accounts;
	}

	public Set<CreditCardEntity> getCreditCards() {
		return creditCards;
	}

	public void setCreditCards(Set<CreditCardEntity> creditCards) {
		this.creditCards = creditCards;
	}

	public Set<RecipeTypeEntity> getRecipeTypes() {
		return recipeTypes;
	}

	public void setRecipeTypes(Set<RecipeTypeEntity> recipeTypes) {
		this.recipeTypes = recipeTypes;
	}

	@Override
	public String toString() {
		return "UserForm [id=" + id + ", nameUser=" + nameUser + ", email=" + email + ", password=" + password
				+ ", confirmPassword=" + confirmPassword + ", accounts=" + accounts + ", creditCards=" + creditCards
				+ ", recipeTypes=" + recipeTypes + "]";
	}


	
	

}
