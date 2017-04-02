package org.omc.repositories;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.omc.AbstractDataBaseTest;
import org.omc.model.UserEntity;
import org.omc.model.repositories.IUserRepository;
import org.springframework.security.core.userdetails.User;

import javax.inject.Inject;
import java.util.List;


public class UserRepositoryTest extends AbstractDataBaseTest {

    private static final Logger LOGGER = Logger.getLogger(UserRepositoryTest.class);

    @Inject
    private IUserRepository userRepository;

    @Test
    public void findAllUsersTest(){
        List<UserEntity> list =  userRepository.findAll();

        LOGGER.info(list);
    }

}
