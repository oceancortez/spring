package org.oxiproject.server.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.oxiproject.server.database.repositories.IOrderRepository;
import org.oxiproject.server.service.utils.AbstractGenericService;
import org.oxiproject.server.utils.entities.OrderEntity;
import org.oxiproject.server.utils.service.interfaces.IOrderService;
import org.springframework.data.jpa.repository.JpaRepository;

@Named
public class OrderService extends AbstractGenericService<OrderEntity, Long> implements IOrderService {

	@Inject
	private IOrderRepository orderRepository;

	@Override
	protected JpaRepository<OrderEntity, Long> getGenericRepository() {
		return this.orderRepository;
	}

	@Override
	public OrderEntity findOne(Long pk) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String countByOrderCustomer(String customerId) {		
		if(customerId != null){
			 List<OrderEntity> listCutomers = orderRepository.findAllByCustomerId(customerId);
			 if(listCutomers.size() > 0){
				 int count = listCutomers.size();
				 return String.valueOf(count);
			 }
			 if(listCutomers.size() == 0){
				 return "Não existem Orders para este Customer!";
			 }
		}
		return "Favor digitar um Customer Válido";
	}

	@Override
	public List<OrderEntity> findOrderByCustomerId(String customerId) {
			
		if(!customerId.isEmpty()){
			return this.orderRepository.findOrderByCustomerId(customerId);
		}
		return null;
	}

}
