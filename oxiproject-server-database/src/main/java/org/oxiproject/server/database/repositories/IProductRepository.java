package org.oxiproject.server.database.repositories;

import java.util.List;

import org.oxiproject.server.utils.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<ProductEntity, Long> {
	
	
	
	//List<ProductEntity> findAllProductsWithoutCategory();

}
