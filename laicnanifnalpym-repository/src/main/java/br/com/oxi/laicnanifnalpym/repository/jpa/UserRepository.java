package br.com.oxi.laicnanifnalpym.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.oxi.laicnanifnalpym.repository.domain.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	
	public UserEntity findUserByEmail(String email);
	
	@Query(value = "SELECT * FROM user "
			+ "WHERE nam_email = ?1 "
			+ "AND nam_password = ?2", nativeQuery = true)
	public UserEntity findUserByEmailAndPassword(String email, String password);

}
