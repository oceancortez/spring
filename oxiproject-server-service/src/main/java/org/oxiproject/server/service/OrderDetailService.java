package org.oxiproject.server.service;

import javax.inject.Inject;
import javax.inject.Named;

import org.oxiproject.server.database.repositories.IOrderDetailRepository;
import org.oxiproject.server.service.utils.AbstractGenericService;
import org.oxiproject.server.utils.entities.OrderDetailEntity;
import org.oxiproject.server.utils.entities.keys.OrderDetailKeyEntity;
import org.oxiproject.server.utils.service.interfaces.IOrderDetailService;
import org.springframework.data.jpa.repository.JpaRepository;

@Named
public class OrderDetailService extends AbstractGenericService<OrderDetailEntity, OrderDetailKeyEntity> implements IOrderDetailService {

	@Inject
	private IOrderDetailRepository orderDetailRepository;

	@Override
	protected JpaRepository<OrderDetailEntity, OrderDetailKeyEntity> getGenericRepository() {
		return this.orderDetailRepository;
	}

	@Override
	public OrderDetailEntity findOne(Long pk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDetailEntity findByOrderDetailId(Long orderId) {
		// TODO Auto-generated method stub
		return null;
	}

}
