package br.com.oxi.laicnanifnalpym.middleware.service.forms;

import java.io.Serializable;

import br.com.oxi.laicnanifnalpym.utils.enums.AccountType;

/***
 *
 * @author Ocean Cortez
 *
 */
public class AccountForm implements Serializable {

	private static final long serialVersionUID = -641355850883157385L;

	private Long id;

	private String numberAgencyAccount;

	private String name;

	private AccountType accountType;

	public AccountForm() {
	}

	public AccountForm(Long id) {
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

	@Override
	public String toString() {
		return "AccountForm [id=" + id + ", numberAgencyAccount=" + numberAgencyAccount + ", name=" + name
				+ ", accountType=" + accountType + "]";
	}

}
