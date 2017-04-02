package org.oxi.stok.repository;

import org.oxi.stok.domain.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<CategoryEntity, Long> {

    public CategoryEntity findCategoryEntityByCategoryName(String categoryName);

}
