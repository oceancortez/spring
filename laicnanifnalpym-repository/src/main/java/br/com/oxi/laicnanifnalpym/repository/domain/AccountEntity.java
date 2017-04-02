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

import br.com.oxi.laicnanifnalpym.utils.enums.AccountType;
import br.com.oxi.laicnanifnalpym.utils.enums.Status;

/***
 *
 * @author Ocean Cortez
 *
 */
@Entity
@Table(name = "account")
public class AccountEntity implements Serializable {

	private static final long serialVersionUID = -641355850883157385L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_account")
	private Long id;

	@Column(name = "num_agency_account")
	@NotNull
	private String numberAgencyAccount;

	@NotNull
	@Column(name = "nam_account")
	private String name;

	@Enumerated(EnumType.STRING)
	@NotNull
	@Column(name = "ind_account_type")
	private AccountType accountType;

	@Enumerated(EnumType.STRING)
	@NotNull
	@Column(name = "ind_account_status")
	private Status status;

	@Column(name = "dat_creation")
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date creationDate;

	@Column(name = "dat_update")
	@Temporal(TemporalType.TIMESTAMP)	
	private Date updateDate;

	@ManyToOne
	@JoinColumn(name = "id_user")
	private UserEntity user;

	public AccountEntity() {
	}

	public AccountEntity(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public String getNumberAgencyAccount() {
		return numberAgencyAccount;
	}

	public void setNumberAgencyAccount(String numberAgencyAccount) {
		this.numberAgencyAccount = numberAgencyAccount;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "AccountEntity [id=" + id + ", numberAgencyAccount=" + numberAgencyAccount + ", name=" + name
				+ ", accountType=" + accountType + ", status=" + status + ", creationDate=" + creationDate
				+ ", updateDate=" + updateDate + ", user=" + user + "]";
	}

}
