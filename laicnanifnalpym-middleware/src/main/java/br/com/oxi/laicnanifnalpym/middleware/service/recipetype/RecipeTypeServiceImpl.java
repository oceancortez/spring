package br.com.oxi.laicnanifnalpym.middleware.service.recipetype;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.oxi.laicnanifnalpym.middleware.service.forms.RecipeTypeForm;
import br.com.oxi.laicnanifnalpym.repository.domain.RecipeTypeEntity;
import br.com.oxi.laicnanifnalpym.repository.domain.UserEntity;
import br.com.oxi.laicnanifnalpym.repository.jpa.RecipeTypeRepository;
import br.com.oxi.laicnanifnalpym.repository.jpa.UserRepository;

@Component
public class RecipeTypeServiceImpl implements RecipeTypeService {
    private final Logger LOGGER = Logger.getLogger(RecipeTypeServiceImpl.class);

    @Autowired
    private RecipeTypeRepository recipeTypeRepository;
    
    
    @Autowired 
    private UserRepository userRepository;

    @Override
    public List<RecipeTypeEntity> list() {
        LOGGER.info("INSIDE >> list()");
        return recipeTypeRepository.findAll();
    }

	@Override
	public boolean saveOrUpdateRecipeType(RecipeTypeForm recipeTypeForm, UserEntity userEntity) {
		boolean isSaved = false;
		LOGGER.info("Entrou no método [saveRecipeType] com =" + recipeTypeForm);
		try {
			 isSaved = recipeTypeRepository.saveAndFlush(parseRecipeTypeForm(recipeTypeForm, userEntity)) != null;
			if(isSaved){
				//TODO - Salvar o relacionar
				return isSaved;
			}
		} catch (Exception e) {
			LOGGER.error("Erro no método [saveRecipeType]" + e.getMessage());
		}
		return isSaved;
	}
	
	public RecipeTypeEntity parseRecipeTypeForm(RecipeTypeForm recipeTypeForm, UserEntity userEntity){
		RecipeTypeEntity recipeTypeEntity = new RecipeTypeEntity();
		recipeTypeEntity.setId(recipeTypeForm.getId());
		recipeTypeEntity.setType(recipeTypeForm.getType());
		recipeTypeEntity.setSubType(recipeTypeForm.getType());
		recipeTypeEntity.setIdUser(userEntity);
		return recipeTypeEntity; 
	}

	@Override
	public List<RecipeTypeEntity> listRecipeTypesByUser(Long idUser) {		
		return recipeTypeRepository.findAllRecipeTypeEntityByIdUser(idUser);
	}

	@Override
	public Set<RecipeTypeEntity> listSetRecipeTypesByUser(Long idUser) {
		return recipeTypeRepository.findRecipeTypeEntityByIdUser(idUser);
	}



}
