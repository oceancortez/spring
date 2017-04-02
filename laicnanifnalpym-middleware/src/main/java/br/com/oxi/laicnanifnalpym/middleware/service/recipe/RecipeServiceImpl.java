package br.com.oxi.laicnanifnalpym.middleware.service.recipe;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.oxi.laicnanifnalpym.middleware.service.forms.RecipeForm;
import br.com.oxi.laicnanifnalpym.repository.domain.AccountEntity;
import br.com.oxi.laicnanifnalpym.repository.domain.RecipeEntity;
import br.com.oxi.laicnanifnalpym.repository.domain.RecipeTypeEntity;
import br.com.oxi.laicnanifnalpym.repository.domain.UserEntity;
import br.com.oxi.laicnanifnalpym.repository.jpa.RecipeRepository;

@Component
public class RecipeServiceImpl implements RecipeService {
	private final Logger LOGGER = Logger.getLogger(RecipeServiceImpl.class);

	@Autowired
	private RecipeRepository recipesRepository;

	@Override
	public List<RecipeEntity> list() {
		LOGGER.info("INSIDE >> list()");
		return recipesRepository.findAll();
	}

	@Override
	public List<RecipeEntity> listRecipesByUser(UserEntity userEntity) {
		LOGGER.info("INSIDE >> listRecipesByUser()");
		List<RecipeEntity> recipeEntity = new ArrayList<>();
		try {
			recipeEntity = recipesRepository.findAllRecipeEntityByUser(userEntity);
		} catch (Exception e) {
			LOGGER.error("EXCEPTION >> saveRecipe()" + e.getMessage() + "recipeEntity = " + recipeEntity);
		}
		return recipeEntity;
	}

	@Override
	public boolean saveOrUpdateRecipe(RecipeForm recipeForm) {
		RecipeEntity entity = null;
		LOGGER.info("INSIDE >> saveRecipe()");
		try {
			if (recipeForm != null) {				
				recipeForm.setCreationDate(new Date());
				entity = parseRecipeForm(recipeForm);
				recipesRepository.saveAndFlush(entity);
				LOGGER.info("INSIDE >> saveRecipe()");
				return true;
			}

		} catch (Exception e) {
			LOGGER.info("EXCEPTION >> saveRecipe()" + e.getMessage() + "entity = " + entity);
		}

		return false;
	}

	public RecipeEntity parseRecipeForm(RecipeForm recipeForm) {
		RecipeEntity recipeEntity = new RecipeEntity();

		recipeEntity.setUser(new UserEntity(recipeForm.getIdUser()));
		recipeEntity.setRecipeType(new RecipeTypeEntity(recipeForm.getIdRecipeType()));
		recipeEntity.setAccount(new AccountEntity(recipeForm.getIdAccount()));

		recipeEntity.setCreationDate(recipeForm.getCreationDate());
		recipeEntity.setDescription(recipeForm.getDescription());
		recipeEntity.setRecipeStatus(recipeForm.getRecipeStatus());
		recipeEntity.setValue(recipeForm.getValue());
		return recipeEntity;
	}

	@Override
	public RecipeEntity findOne(RecipeForm recipeForm) {
		LOGGER.info("INSIDE >> saveRecipe()");
		try {
			if (recipeForm != null) {
				LOGGER.info("INSIDE >> findOne() recipeForm = " + recipeForm);
				return recipesRepository.findOne(recipeForm.getId());
			}

		} catch (Exception e) {
			LOGGER.info("EXCEPTION >> saveRecipe()" + e.getMessage() + "recipeForm = " + recipeForm);
		}

		return null;
	}



	@Override
	public BigDecimal sumTotalRecipeToRecevedOfYear(RecipeForm recipeForm) {
		BigDecimal recipe = BigDecimal.ZERO;
		try {
			recipe = recipesRepository.sumAllRecipeEntityByYearAndOpenAndFixed(getYearOfDateNow(), recipeForm.getIdUser());
		} catch (Exception e) {
			LOGGER.info("EXCEPTION >> sumTotalRecipeToRecevedOfYear()" + e.getMessage() + "recipeForm = " + recipeForm);
		}	
		return recipe; 
	}

	@Override
	public BigDecimal sumValueRecipeReceivedForMonth(RecipeForm recipeForm) {
		BigDecimal recipe = BigDecimal.ZERO;
		try {
				
			recipe = recipesRepository.sumAllRecipeEntityByMonthAndYearAndReceived(getMonthOfDateNow(), getYearOfDateNow(), recipeForm.getIdUser());
		} catch (Exception e) {
			LOGGER.info("EXCEPTION >>sumValueRecipeReceivedForMonth  recipesRepository.sumAllRecipeEntityByMonthAndYearAndReceivedStatusReceived()" + e.getMessage());
		}
		
		return recipe;
	}

	@Override
	public BigDecimal sumValueRecipeReceivableForMonth(RecipeForm recipeForm) {
		BigDecimal recipe = BigDecimal.ZERO;
		try {
			recipe = recipesRepository.sumAllRecipeEntityByMonthAndYearAndOpenAndFixed(getMonthOfDateNow(), getYearOfDateNow(), recipeForm.getIdUser());
			 
		} catch (Exception e) {
			LOGGER.info("EXCEPTION >>sumValueRecipeReceivableForMonth  recipesRepository.sumAllRecipeEntityByMonthAndYearAndReceivedStatusOpenAndFixed()" + e.getMessage());
		}
		
		return recipe;
	}

	@Override
	public BigDecimal sumValueRecipeConsolidatedForMonth(RecipeForm recipeForm) {
		BigDecimal recipe = BigDecimal.ZERO;
		
		try {
			BigDecimal receivable = recipesRepository.sumAllRecipeEntityByMonthAndYearAndOpenAndFixed(getMonthOfDateNow(), getYearOfDateNow(), recipeForm.getIdUser());
			BigDecimal received = recipesRepository.sumAllRecipeEntityByMonthAndYearAndReceived(getMonthOfDateNow(), getYearOfDateNow(), recipeForm.getIdUser());
			
			recipe = recipe.add(received);
			recipe = recipe.subtract(receivable);
			LOGGER.info("Consolidando a Receita = " + recipe);
		} catch (Exception e) {
			LOGGER.error("EXCEPTION >>sumValueRecipeConsolidatedForMonth  recipesRepository.sumAllRecipeEntityByMonthAndYearAndReceivedStatusOpenAndFixed()" + e.getMessage());
		}
		
		return recipe;
	}
	
	public Integer getMonthOfDateNow(){
		Integer month = null;
		try {
			Calendar calendar1 = Calendar.getInstance();		
			Date date1 = new Date();		
			calendar1.setTime(date1);		
			calendar1.add(Calendar.MONTH, 1);
			month = calendar1.get(Calendar.MONTH);
			
		} catch (Exception e) {
			LOGGER.info("EXCEPTION >> getMonthOfDateNow()" + e.getMessage()); 
		}
					
		return month;
	}
	
	public Integer getYearOfDateNow(){
		
		
		Integer year = null;
		try {
			Calendar calendar = Calendar.getInstance();		
			Date date = new Date();		
			calendar.setTime(date);		
			year = calendar.get(Calendar.YEAR);
			
		} catch (Exception e) {
			LOGGER.info("EXCEPTION >> getYearOfDateNow()" + e.getMessage()); 
		}
					
		return year;		
	
	}

	@Override
	public Integer actualizeRecipe(RecipeForm recipeForm) {
		try {
			return recipesRepository.actualizeRecipeEntityByRecipeStatus(recipeForm.getId());
		} catch (Exception e) {
			LOGGER.info("EXCEPTION >> actualizeRecipe()" + e.getMessage());
		}
		return 0;
	}

	@Override
	public RecipeEntity findOne(Long id) {
		LOGGER.info("INSIDE >> saveRecipe()");
		try {
			if (id != null) {
				LOGGER.info("INSIDE >> findOne(id) = " + id);
				return recipesRepository.findOne(id);
			}

		} catch (Exception e) {
			LOGGER.info("EXCEPTION >> findOne(id)" + e.getMessage() + "id = " + id);
		}

		return null;
	}

	@Override
	public boolean deleteRecipe(RecipeEntity recipeEntity) {
		LOGGER.info("INSIDE >> saveRecipe()");
		try {
			if (recipeEntity != null) {
				LOGGER.info("INSIDE >> deleteRecipe(recipeEntity) = " + recipeEntity);
				recipesRepository.delete(recipeEntity);
				LOGGER.info("EXITED >> deleteRecipe(recipeEntity) has deleted!");
				return true;
			}

		} catch (Exception e) {
			LOGGER.info("EXCEPTION >> deleteRecipe(recipeEntity) " + e.getMessage() +  recipeEntity);
			return false;
		}		
		
		return false;
	}

	@Override
	public boolean deleteRecipe(Long id) {
		LOGGER.info("INSIDE >> saveRecipe()");
		try {
			if (id != null) {
				LOGGER.info("INSIDE >> deleteRecipe(id) = " + id);
				recipesRepository.delete(id);
				LOGGER.info("EXITED >> deleteRecipe(id) has deleted!");
				return true;
			}

		} catch (Exception e) {
			LOGGER.info("EXCEPTION >> deleteRecipe(id) " + e.getMessage() +  id);
			return false;
		}		
		
		return false;
	}
	
	
	
	
	

}
