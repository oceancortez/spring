package org.oxiproject.server.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.oxiproject.server.utils.entities.OrderDetailEntity;
import org.oxiproject.server.utils.entities.keys.OrderDetailKeyEntity;

public interface IOrderDetailRepository extends JpaRepository<OrderDetailEntity, OrderDetailKeyEntity> {

}
