package br.com.oxi.laicnanifnalpym.middleware.service.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.oxi.laicnanifnalpym.repository.domain.LaicnanifnalpymEntity;
import br.com.oxi.laicnanifnalpym.repository.jpa.LaicnanifnalpymRepository;

@Component
public class LaicnanifnalpymServiceImpl implements LaicnanifnalpymService {
	private final Logger LOGGER = Logger.getLogger(LaicnanifnalpymServiceImpl.class);
	
	@Autowired
	private LaicnanifnalpymRepository laicnanifnalpymRepository;

	@Override
	public List<LaicnanifnalpymEntity> list() {
		LOGGER.info("INSIDE >> list()");
		return laicnanifnalpymRepository.findAll();
	}
	
	
	

}
