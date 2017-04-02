package br.com.oxi.laicnanifnalpym.middleware.service.recipe;

import java.math.BigDecimal;
import java.util.List;

import br.com.oxi.laicnanifnalpym.middleware.service.forms.RecipeForm;
import br.com.oxi.laicnanifnalpym.repository.domain.RecipeEntity;
import br.com.oxi.laicnanifnalpym.repository.domain.UserEntity;

public interface RecipeService {

    List<RecipeEntity> list();

    List<RecipeEntity> listRecipesByUser(UserEntity userEntity);

    boolean saveOrUpdateRecipe(RecipeForm recipeForm);
    
    RecipeEntity findOne(RecipeForm recipeForm);
    
    RecipeEntity findOne(Long id);
    
    boolean deleteRecipe(RecipeEntity recipeEntity);
    
    boolean deleteRecipe(Long id);
    
    BigDecimal sumValueRecipeReceivedForMonth(RecipeForm recipeForm);
    
    BigDecimal sumValueRecipeReceivableForMonth(RecipeForm recipeForm);
    
    BigDecimal sumValueRecipeConsolidatedForMonth(RecipeForm recipeForm);
    
    BigDecimal sumTotalRecipeToRecevedOfYear(RecipeForm recipeForm);
    
    Integer actualizeRecipe(RecipeForm recipeForm);
    
        

}
