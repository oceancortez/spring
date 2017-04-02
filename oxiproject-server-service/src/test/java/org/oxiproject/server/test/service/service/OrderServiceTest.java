package org.oxiproject.server.test.service.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.oxiproject.server.service.OrderService;
import org.oxiproject.server.test.service.AbstractDatabaseTest;
import org.oxiproject.server.utils.entities.OrderEntity;

public class OrderServiceTest extends AbstractDatabaseTest {

	private final Logger logger = Logger.getLogger(this.getClass());

	@Inject
	private OrderService orderService;

	
	
	@Test
	public void testCountOrdesToCustomer(){
		List<OrderEntity> orderEntity = this.orderService.findOrderByCustomerId("VINET");
		
		if(orderEntity.size() > 0){
			this.logger.debug("Total de Orders by Customer = " + orderEntity.size());	
		}
		
		this.logger.debug(orderEntity);
		
	}

}
