package br.com.oxi.laicnanifnalpym.middleware.service.account;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.oxi.laicnanifnalpym.middleware.service.forms.AccountForm;
import br.com.oxi.laicnanifnalpym.repository.domain.AccountEntity;
import br.com.oxi.laicnanifnalpym.repository.domain.UserEntity;
import br.com.oxi.laicnanifnalpym.repository.jpa.AccountRepository;
import br.com.oxi.laicnanifnalpym.utils.enums.Status;

@Component
public class AccountServiceImpl implements AccountService {
	private final Logger LOGGER = Logger.getLogger(AccountServiceImpl.class);

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public List<AccountEntity> list() {
		LOGGER.info("INSIDE >> list()");
		return accountRepository.findAll();
	}

	@Override
	public Set<AccountEntity> listAccountByUser(UserEntity userEntity) {
		LOGGER.info("INSIDE >> listAccountByUser()");
		return accountRepository.findAllAccountEntityByUser(userEntity);
	}

	@Override
	public boolean saveOrUpdate(AccountForm accountForm, UserEntity userEntity) {
		boolean isSaved = false;
		LOGGER.info("Entrou no método [saveRecipeType] com =" + accountForm);
		try {
			isSaved = accountRepository.saveAndFlush(parseRecipeTypeForm(accountForm, userEntity)) != null;
			if (isSaved) {
				return isSaved;
			}
		} catch (Exception e) {
			LOGGER.error("Erro no método [saveRecipeType]" + e.getMessage());
		}
		return isSaved;
	}

	private AccountEntity parseRecipeTypeForm(AccountForm accountForm, UserEntity userEntity) {
		AccountEntity accountEntity = new AccountEntity();
		try {
			accountEntity.setId(accountForm.getId());
			accountEntity.setName(accountForm.getName());
			accountEntity.setNumberAgencyAccount(accountForm.getNumberAgencyAccount());
			accountEntity.setStatus(Status.ACTIVE);
			accountEntity.setAccountType(accountForm.getAccountType());
			accountEntity.setUser(userEntity);
			accountEntity.setCreationDate(new Date());
		} catch (Exception e) {
			LOGGER.error("Erro no método [parseRecipeTypeForm]" + e.getMessage());
		}
		return accountEntity;
	}

}
