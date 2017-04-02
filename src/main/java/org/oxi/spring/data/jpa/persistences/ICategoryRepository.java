package org.oxi.spring.data.jpa.persistences;

import org.oxi.spring.data.jpa.domain.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<CategoryEntity, Long>{

}
