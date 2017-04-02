package org.omc.model.repositories;

import org.omc.model.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICategoryRepository extends JpaRepository<CategoryEntity, Long> {

     @Query("SELECT c FROM CategoryEntity c WHERE c.categoryName LIKE concat('%',:categoryName,'%')")
     List<CategoryEntity> findByCategoryNameContaining(@Param("categoryName") String categoryName);

     @Query("select c from CategoryEntity c where c.id = ?1")
     CategoryEntity findById(Long id);
}
