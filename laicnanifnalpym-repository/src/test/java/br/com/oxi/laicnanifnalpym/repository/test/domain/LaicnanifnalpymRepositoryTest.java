package br.com.oxi.laicnanifnalpym.repository.test.domain;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;

import br.com.oxi.laicnanifnalpym.domain.Laicnanifnalpym;
import br.com.oxi.laicnanifnalpym.repository.LaicnanifnalpymRepository;
import br.com.oxi.laicnanifnalpym.repository.test.config.AbstractDatabaseTest;

public class LaicnanifnalpymRepositoryTest extends AbstractDatabaseTest {
	
	private final Logger LOGGER = Logger.getLogger(LaicnanifnalpymRepositoryTest.class);
	
	
	@Inject
	private LaicnanifnalpymRepository repositoryTest;
	
	@Test
	public void findAllTest(){
		List<Laicnanifnalpym> laicnanifnalpymList = repositoryTest.findAll();
		
		LOGGER.info(laicnanifnalpymList);
	}

}
