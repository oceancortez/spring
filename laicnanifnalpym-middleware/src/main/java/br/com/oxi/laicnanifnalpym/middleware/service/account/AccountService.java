package br.com.oxi.laicnanifnalpym.middleware.service.account;

import java.util.List;
import java.util.Set;

import br.com.oxi.laicnanifnalpym.middleware.service.forms.AccountForm;
import br.com.oxi.laicnanifnalpym.repository.domain.AccountEntity;
import br.com.oxi.laicnanifnalpym.repository.domain.UserEntity;

public interface AccountService {

    List<AccountEntity> list();

    Set<AccountEntity> listAccountByUser(UserEntity userEntity);

	boolean saveOrUpdate(AccountForm accountForm, UserEntity userEntity);

}
