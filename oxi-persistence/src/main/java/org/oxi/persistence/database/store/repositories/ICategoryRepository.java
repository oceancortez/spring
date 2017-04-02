package org.oxi.persistence.database.store.repositories;

import java.util.List;

import org.oxi.utils.entities.sale.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<CategoryEntity, Long>{
	
	public List<CategoryEntity> findByCategoryName(String categoryName);

}
