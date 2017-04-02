package br.com.oxi.laicnanifnalpym.middleware.service.user;

import java.util.List;

import br.com.oxi.laicnanifnalpym.middleware.service.forms.UserForm;
import br.com.oxi.laicnanifnalpym.repository.domain.UserEntity;

public interface UserService {
	
	List<UserEntity> list();
	
	boolean isAlreadyUser(UserEntity user);
	
	UserEntity findUser(UserEntity user);
	
	UserEntity findUser(Long id);
	
	UserEntity findUserByEmail(String email);
	
	UserEntity findUserByEmailAndPassword(String email, String password);
	
	boolean saveUser(UserForm userForm, UserEntity user);

}
