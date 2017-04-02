package br.com.oxi.laicnanifnalpym.repository.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import br.com.oxi.laicnanifnalpym.utils.enums.Status;

/***
 * 
 * @author Ocean Cortez
 *
 */
@Entity
@Table(name = "user")
public class UserEntity implements Serializable {

	private static final long serialVersionUID = -1091615985247544600L;

	@Id
	@Column(name = "id_user")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nam_user")
	@NotNull
	private String nameUser;

	@Column(name = "nam_email")
	@NotNull
	private String email;

	@Column(name = "nam_password")
	@NotNull
	private String password;

	@Column(name = "nam_role")
	private String role;

	/***
	 * @OneToMany - Quando tiver mais de um relacionamento, utilizar SET<T> pois
	 *            assim ganhará em performace e o spring não irá reclamar
	 */

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_credit_card", joinColumns = @JoinColumn(name = "id_user") , inverseJoinColumns = @JoinColumn(name = "id_credit_card") )
	private Set<CreditCardEntity> creditCards;

	// @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	// @JoinTable(name = "user_account", joinColumns = @JoinColumn(name =
	// "id_user"), inverseJoinColumns = @JoinColumn(name = "id_account"))
	// private Set<AccountEntity> accounts;

	// @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	// @JoinTable(name = "user_recipe_type", joinColumns = @JoinColumn(name =
	// "id_user"), inverseJoinColumns = @JoinColumn(name = "id_recipe_type"))
	// private Set<RecipeTypeEntity> recipeTypes;

	@Column(name = "ind_user_status")
	@Enumerated(EnumType.STRING)
	@NotNull
	private Status status;

	@Column(name = "dat_creation")
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date creationDate;

	@Column(name = "dat_last_login")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastLogin;

	public UserEntity() {
	}

	public UserEntity(Long id) {
		super();
		this.id = id;
	}

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

	public Set<CreditCardEntity> getCreditCards() {
		return creditCards;
	}

	public void setCreditCards(Set<CreditCardEntity> creditCards) {
		this.creditCards = creditCards;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", nameUser=" + nameUser + ", email=" + email + ", password=" + password
				+ ", role=" + role + ", creditCards=" + creditCards + ", status=" + status + ", creationDate="
				+ creationDate + ", lastLogin=" + lastLogin + "]";
	}

}
