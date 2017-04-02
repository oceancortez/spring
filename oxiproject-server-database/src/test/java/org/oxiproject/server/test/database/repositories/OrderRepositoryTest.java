package org.oxiproject.server.test.database.repositories;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.oxiproject.server.database.repositories.IOrderRepository;
import org.oxiproject.server.test.database.AbstractDatabaseTest;
import org.oxiproject.server.utils.entities.OrderEntity;

public class OrderRepositoryTest extends AbstractDatabaseTest {

	private final Logger logger = Logger.getLogger(this.getClass());

	@Inject
	private IOrderRepository orderRepository;

	@Test
	public void testOrderRepository() {
		List<OrderEntity> orderEntities = this.orderRepository.findAll();

		this.logger.debug(orderEntities);
	}
	
	@Test
	public void testOrderByCustomerId(){
		List<OrderEntity> orderEntity = this.orderRepository.findAllByCustomerId("VINET");
		
		this.logger.debug(orderEntity);
		
	}
	
	@Test
	public void testCountOrdesToCustomer(){
		List<OrderEntity> orderEntity = this.orderRepository.findAllByCustomer("VINET");
		
		if(orderEntity.size() > 0){
			this.logger.debug("Total de Orders by Customer = " + orderEntity.size());	
		}
		
		this.logger.debug(orderEntity);
		
	}

}
