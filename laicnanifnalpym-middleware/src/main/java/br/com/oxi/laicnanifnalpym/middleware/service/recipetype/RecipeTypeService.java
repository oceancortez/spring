package br.com.oxi.laicnanifnalpym.middleware.service.recipetype;

import java.util.List;
import java.util.Set;

import br.com.oxi.laicnanifnalpym.middleware.service.forms.RecipeTypeForm;
import br.com.oxi.laicnanifnalpym.repository.domain.RecipeTypeEntity;
import br.com.oxi.laicnanifnalpym.repository.domain.UserEntity;

public interface RecipeTypeService {

    List<RecipeTypeEntity> list();

    boolean saveOrUpdateRecipeType(RecipeTypeForm recipeTypeForm, UserEntity userEntity);
    
    List<RecipeTypeEntity> listRecipeTypesByUser(Long idUser);
    
    Set<RecipeTypeEntity> listSetRecipeTypesByUser(Long idUser);

}
