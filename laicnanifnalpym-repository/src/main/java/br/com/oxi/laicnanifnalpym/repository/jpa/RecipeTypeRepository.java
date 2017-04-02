package br.com.oxi.laicnanifnalpym.repository.jpa;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.oxi.laicnanifnalpym.repository.domain.RecipeTypeEntity;

public interface RecipeTypeRepository extends JpaRepository<RecipeTypeEntity, Long> {

    public List<RecipeTypeEntity> findAllRecipeTypeEntityById(Long id); 
    
    @Query(value = "SELECT * FROM recipe_type rt "
    		+ "WHERE rt.id_user = ?1", nativeQuery = true)
    public List<RecipeTypeEntity> findAllRecipeTypeEntityByIdUser(Long idUser);

    @Query(value = "SELECT * FROM recipe_type rt "
    		+ "WHERE rt.id_user = ?1", nativeQuery = true)
    public Set<RecipeTypeEntity> findRecipeTypeEntityByIdUser(Long idUser);
    

}
