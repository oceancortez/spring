package br.com.oxi.laicnanifnalpym.middleware.service.user;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.oxi.laicnanifnalpym.middleware.service.forms.UserForm;
import br.com.oxi.laicnanifnalpym.repository.domain.UserEntity;
import br.com.oxi.laicnanifnalpym.repository.jpa.UserRepository;
import br.com.oxi.laicnanifnalpym.utils.enums.Role;
import br.com.oxi.laicnanifnalpym.utils.enums.Status;

@Component
@Transactional
public class UserServiceImpl implements UserService {
    private final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserEntity> list() {
        LOGGER.info("INSIDE >> list()");
        return userRepository.findAll();
    }

    @Override
    public boolean isAlreadyUser(UserEntity user) {
        LOGGER.info("INSIDE >> isAlreadyUser()");
        UserEntity u = userRepository.findOne(user.getId());
        if (u != null) {
            LOGGER.info("EXITED >> isAlreadyUser() user = true = " + u);
            return true;
        }
        LOGGER.info("EXITED >> isAlreadyUser() user = false");
        return false;
    }

    @Override
    public UserEntity findUser(UserEntity user) {
        LOGGER.info("INSIDE >> findUser()");
        UserEntity u = userRepository.findOne(user.getId());
        LOGGER.info("EXITED >> findUser() user = " + u);
        return u;
    }

    @Override
    public UserEntity findUserByEmail(String email) {
        LOGGER.info("INSIDE >> findUserByEmail()");
        UserEntity user = new UserEntity();
        if(!email.isEmpty()){        
        user = userRepository.findUserByEmail(email);
        LOGGER.info("EXITED >> findUserByEmail() user = " + user);
        }
        return user;
    }

    @Override
    public boolean saveUser(UserForm userForm, UserEntity user) {
        try {
            LOGGER.info("INSIDE >> saveUser()");
            if (userForm != null) {
                userRepository.save(parseUserFormToUser(userForm));
                LOGGER.info("INSIDE >> userRepository.save(user)");
                return true;
            }
        } catch (Exception e) {
            LOGGER.info("ERROR >> saveUser() user = " + user + " e = " + e.getMessage());
            return false;
        }

        LOGGER.info("EXITED >> saveUser() user = " + user + " não foi salvo!");
        return false;
    }

    @Override
    public UserEntity findUserByEmailAndPassword(String email, String password) {
        LOGGER.info("INSIDE >> findUserByEmailAndPassword()");
        UserEntity user = new UserEntity();
        user = userRepository.findUserByEmailAndPassword(email, password);
        LOGGER.info("EXITED >> findUserByEmailAndPassword() user = " + user);
        return user;
    }

    public UserEntity parseUserFormToUser(UserForm userForm) {
        UserEntity user = new UserEntity();
        user.setNameUser(userForm.getNameUser());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setCreationDate(new Date());
        user.setStatus(Status.ACTIVE);
        user.setRole(Role.USER_COMMOM.toString());
        return user;
    }

    @Override
    public UserEntity findUser(Long id) {
        LOGGER.info("INSIDE >> findUser()");
        UserEntity u = null;
        try {
        	u = userRepository.findOne(id);
            LOGGER.info("EXITED >> findUser() user = " + u);	
		} catch (Exception e) {
			LOGGER.error("Exception >> findUser() user = " + u);
		}        
        
        return u;
    }	
}
