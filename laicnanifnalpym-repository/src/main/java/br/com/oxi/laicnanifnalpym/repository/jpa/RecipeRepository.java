package br.com.oxi.laicnanifnalpym.repository.jpa;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import br.com.oxi.laicnanifnalpym.repository.domain.RecipeEntity;
import br.com.oxi.laicnanifnalpym.repository.domain.UserEntity;

public interface RecipeRepository extends JpaRepository<RecipeEntity, Long> {
	
	@Query("SELECT r FROM RecipeEntity r WHERE r.user = :user")
	public List<RecipeEntity> findAllRecipeEntityByUser(@Param("user") UserEntity user);
	
	@Query(value = "SELECT SUM(r.ind_value) FROM recipe r", nativeQuery = true)
	public BigDecimal sumAllRecipeEntity();
	
	@Query(value = "SELECT SUM(r.ind_value) FROM recipe r "
			+ "WHERE YEAR(r.dat_creation) in (?1)"
			+ "AND r.id_user = ?2 "
			+ "AND r.ind_recipe_status != 'RECEIVED' ", nativeQuery = true)
	public BigDecimal sumAllRecipeEntityByYearAndOpenAndFixed(Integer month, Long idUser);
	
	@Query(value = "SELECT SUM(r.ind_value) FROM recipe r "
			+ "WHERE MONTH(r.dat_creation) in (?1) "
			+ "AND YEAR(r.dat_creation) in (?2)"
			+ "AND r.id_user = ?3 "
			+ "AND r.ind_recipe_status != 'RECEIVED' ", nativeQuery = true)
	public BigDecimal sumAllRecipeEntityByMonthAndYearAndOpenAndFixed(Integer month, Integer year, Long idUser);
	
	@Query(value = "SELECT SUM(r.ind_value) FROM recipe r "
			+ "WHERE MONTH(r.dat_creation) in (?1) "
			+ "AND YEAR(r.dat_creation) in (?2)"
			+ "AND r.id_user = ?3 "
			+ "AND r.ind_recipe_status = 'RECEIVED' ", nativeQuery = true)
	public BigDecimal sumAllRecipeEntityByMonthAndYearAndReceived(Integer month, Integer year, Long idUser);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE recipe r SET r.ind_recipe_status = 'RECEIVED' "
			+ "WHERE r.id_recipe = ?1", nativeQuery = true)
	public Integer actualizeRecipeEntityByRecipeStatus(Long idRecipe);
		
	

}
