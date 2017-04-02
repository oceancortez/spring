package br.com.oxi.laicnanifnalpym.repository.jpa;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.oxi.laicnanifnalpym.repository.domain.AccountEntity;
import br.com.oxi.laicnanifnalpym.repository.domain.UserEntity;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

    public Set<AccountEntity> findAllAccountEntityByUser(UserEntity user);

}
