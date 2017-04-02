package br.com.oxi.laicnanifnalpym.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.oxi.laicnanifnalpym.repository.domain.CreditCardEntity;

public interface CreditCardRepository extends JpaRepository<CreditCardEntity, Long> {

}
