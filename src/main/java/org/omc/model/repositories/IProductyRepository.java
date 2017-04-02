package org.omc.model.repositories;

import org.omc.model.ProductyEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IProductyRepository extends JpaRepository<ProductyEntity, Long> {
}
