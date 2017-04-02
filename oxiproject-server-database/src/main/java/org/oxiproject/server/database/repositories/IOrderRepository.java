package org.oxiproject.server.database.repositories;

import java.util.List;

import org.oxiproject.server.utils.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IOrderRepository extends JpaRepository<OrderEntity, Long> {
	
	public List<OrderEntity> findOrderByCustomerId(String customerId);
	
	
	
	@Query(value = "select oe from OrderEntity oe where oe.customerId = :customerId")
	List<OrderEntity> findAllByCustomerId(@Param("customerId") String customerId);
	
	@Query(value = "select oe from OrderEntity oe where oe.customerId = ?1")
	List<OrderEntity> findAllByCustomer(String customerId);	
	

}
