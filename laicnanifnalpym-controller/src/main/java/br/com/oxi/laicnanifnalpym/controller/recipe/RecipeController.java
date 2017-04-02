package br.com.oxi.laicnanifnalpym.controller.recipe;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.oxi.laicnanifnalpym.controller.AbstractController;
import br.com.oxi.laicnanifnalpym.middleware.service.account.AccountService;
import br.com.oxi.laicnanifnalpym.middleware.service.forms.RecipeForm;
import br.com.oxi.laicnanifnalpym.middleware.service.recipe.RecipeService;
import br.com.oxi.laicnanifnalpym.middleware.service.recipetype.RecipeTypeService;
import br.com.oxi.laicnanifnalpym.middleware.service.user.UserService;
import br.com.oxi.laicnanifnalpym.repository.domain.AccountEntity;
import br.com.oxi.laicnanifnalpym.repository.domain.RecipeEntity;
import br.com.oxi.laicnanifnalpym.repository.domain.RecipeTypeEntity;
import br.com.oxi.laicnanifnalpym.repository.domain.UserEntity;
import br.com.oxi.laicnanifnalpym.utils.enums.Message;
import br.com.oxi.laicnanifnalpym.utils.enums.Route;

@Controller
@RequestMapping("recipe")
public class RecipeController extends AbstractController {
	private final Logger LOGGER = Logger.getLogger(RecipeController.class);

	@Autowired
	private RecipeService recipeService;

	@Autowired
	private UserService userService;

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private RecipeTypeService recipeTypeService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView recipeView(@ModelAttribute("recipeForm") RecipeForm recipeForm, BindingResult bindingResult) {
		LOGGER.info("INSIDE >> home()");
		ModelAndView modelAndView = getModelAndView();
		modelAndView.setViewName(Route.RECIPE_VIEW.toString());
		final UserEntity userEntity = userService.findUser(getUserLogado());
		final List<RecipeEntity> listRecipes = recipeService.listRecipesByUser(userEntity);
		final Set<AccountEntity> listAccounts = accountService.listAccountByUser(userEntity);
		final List<RecipeTypeEntity> listRecipeTypeEntities = recipeTypeService.listRecipeTypesByUser(userEntity.getId());
		buildRecipeTableView(recipeForm, modelAndView, listRecipes, userEntity, listAccounts, listRecipeTypeEntities);
		LOGGER.info("OUT >> home()");
		return modelAndView;
	}

	@RequestMapping(value = "table", method = RequestMethod.GET)
	public ModelAndView recipeViewTable(@ModelAttribute("recipeForm") RecipeForm recipeForm,
			BindingResult bindingResult) {
		LOGGER.info("INSIDE >> home()");
		ModelAndView modelAndView = getModelAndView();

		modelAndView.setViewName(Route.RECIPE_TABLE.toString());
		final UserEntity userEntity = getUserLogado();
		final List<RecipeEntity> listRecipes = recipeService.listRecipesByUser(userEntity);
		buildRecipeTableView(recipeForm, modelAndView, listRecipes, userEntity);
		LOGGER.info("OUT >> home()");
		return modelAndView;

	}


	@RequestMapping(value = "create", method = RequestMethod.GET)
	public ModelAndView createForm(@ModelAttribute("recipeForm") RecipeForm recipeForm, BindingResult bindingResult) {
		ModelAndView modelAndView = getModelAndView();
		LOGGER.info("INSIDE >> create()");
		try {
			validForm(bindingResult, modelAndView);
			final UserEntity userEntity = getUserLogado();
			final Set<RecipeTypeEntity> recipeTypeEntities = recipeTypeService.listSetRecipeTypesByUser(userEntity.getId());
			recipeForm.setRecipeTypes(recipeTypeEntities);
			recipeForm.setAccounts(accountService.listAccountByUser(userEntity));			
				LOGGER.info("INSIDE >> userService.add()");
				modelAndView.setViewName(Route.RECIPE_CREATE.toString());
				LOGGER.info("EXITED >> userService.saveUser()");
				return modelAndView;
		} catch (Exception e) {
			LOGGER.info("INSIDE >> create() Exception = " + e.getMessage());
		}
		return modelAndView;
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public ModelAndView create(@Valid RecipeForm recipeForm, BindingResult bindingResult) {
		ModelAndView modelAndView = getModelAndView();
		modelAndView.setViewName(Route.RECIPE_CREATE.toString());
		LOGGER.info("INSIDE >> create()");
		try {
			validForm(bindingResult, modelAndView);
			RecipeEntity recipeEntity = new RecipeEntity();
			if (recipeForm != null) {
				recipeForm.setIdUser(getUserLogado().getId());
				LOGGER.info("INSIDE >> userService.add()");
				recipeEntity = recipeService.findOne(recipeForm);
				final boolean isSave = recipeService.saveOrUpdateRecipe(recipeForm);
				if (recipeEntity == null && isSave) {
					modelAndView.setViewName(Route.RECIPE_CREATE.toString());
					modelAndView.addObject("message", Message.RECIPE_CREATE.toString());
					LOGGER.info("EXITED >> userService.saveUser()");
					return recipeView(recipeForm, bindingResult);
				} else {
					modelAndView.setViewName(Route.RECIPE_VIEW.toString());
					modelAndView.addObject("message", Message.RECIPE_UPDATE.toString());
					LOGGER.info("EXITED >> create = USER_ALREADY");
					return recipeView(recipeForm, bindingResult);
				}
			}
		} catch (Exception e) {
			LOGGER.info("INSIDE >> create() Exception = " + e.getMessage());
		}
		return modelAndView.addObject("message", Message.RECIPE_CREATE_ERROR.toString());
	}

	

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("recipeForm") RecipeForm recipeForm, BindingResult bindingResult) {
		ModelAndView modelAndView = getModelAndView();

		LOGGER.info("INSIDE >> update()");
		try {
			recipeForm.setIdUser(getUserLogado().getId());
			final boolean isHasSaved = recipeService.saveOrUpdateRecipe(recipeForm);
			if(isHasSaved){
			modelAndView.setViewName(Route.RECIPE_VIEW.toString());
			modelAndView.addObject("message", Message.RECIPE_UPDATE.toString());
			LOGGER.info("EXITED >> create = USER_ALREADY");
			return recipeView(recipeForm, bindingResult);
			}
		} catch (Exception e) {
			LOGGER.info("INSIDE >> update() Exception = " + e.getMessage());
		}
		return modelAndView;

	}

	@RequestMapping(value = "actualize/{id}", method = RequestMethod.GET)
	public ModelAndView actualizeGet(@PathVariable("id") Long id, RecipeForm recipeForm) {
		ModelAndView modelAndView = getModelAndView();
		recipeForm.setId(id);
		LOGGER.info("INSIDE >> actualize()");
		try {
			LOGGER.info("INSIDE >> recipeService.actualize()");
			final Integer rowsAffected = recipeService.actualizeRecipe(recipeForm);
			if (rowsAffected > 0) {
				modelAndView.addObject("message", Message.RECIPE_ACTUALIZE.toString());
				modelAndView.setViewName(Route.RECIPE_VIEW.toString());
				return modelAndView;
			} else {
				modelAndView.addObject("message", Message.RECIPE_ACTUALIZE_ERROR.toString());
				modelAndView.setViewName(Route.RECIPE_VIEW.toString());
				return modelAndView;
			}

		} catch (Exception e) {
			LOGGER.info("INSIDE >> actualize() Exception = " + e.getMessage());
		}
		return modelAndView;

	}

	@RequestMapping(value = "actualize", method = RequestMethod.POST)
	public ModelAndView actualizePost(@ModelAttribute("recipeForm") RecipeForm recipeForm,
			BindingResult bindingResult) {
		ModelAndView modelAndView = getModelAndView();

		LOGGER.info("INSIDE >> actualize()");
		try {
			LOGGER.info("INSIDE >> recipeService.actualize()");
			if (recipeForm.getIdRecipeType() == null) {
				modelAndView.addObject("message", Message.RECIPE_ACTUALIZE_ERROR.toString());
				modelAndView.setViewName(Route.RECIPE_VIEW.toString());
				return modelAndView;
			}
			Integer rowsAffected = recipeService.actualizeRecipe(recipeForm);
			if (rowsAffected > 0) {
				modelAndView.addObject("message", Message.RECIPE_ACTUALIZE.toString());
				modelAndView.setViewName(Route.RECIPE_VIEW.toString());
				return modelAndView;
			} else {
				modelAndView.addObject("message", Message.RECIPE_ACTUALIZE_ERROR.toString());
				modelAndView.setViewName(Route.RECIPE_VIEW.toString());
				return modelAndView;
			}

		} catch (Exception e) {
			LOGGER.info("INSIDE >> actualize() Exception = " + e.getMessage());
		}
		return modelAndView;

	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView delete(@ModelAttribute("recipeForm") RecipeForm recipeForm, BindingResult bindingResult) {
		ModelAndView modelAndView = getModelAndView();
		LOGGER.info("INSIDE >> delete() " + recipeForm);
		try {					
			if (recipeForm != null) {
				LOGGER.info("INSIDE >> delete(recipeEntity) = " + recipeForm);
				final boolean isHasDeleted = recipeService.deleteRecipe(recipeForm.getId());
				if(isHasDeleted){
					LOGGER.info("EXITED >> userService.saveUser()");
					modelAndView.setViewName(Route.RECIPE.toString());
					 modelAndView.addObject("message", Message.RECIPE_HAS_DELETED.toString());
					return recipeView(recipeForm, bindingResult);	
				}				
			}	
		} catch (Exception e) {
			LOGGER.info("INSIDE >> delete(id) Exception = "+ recipeForm + e.getMessage());
		}
		return modelAndView.addObject("message", Message.RECIPE_DELETE_ERROR.toString());
	}

	@RequestMapping(value = "/showValueRecipeReceivedForMonth", method = RequestMethod.GET)
	@ResponseBody
	public String showValueRecipeReceivedForMonth(@ModelAttribute("recipeForm") RecipeForm recipeForm,
			BindingResult bindingResult) {
		LOGGER.info("INSIDE >> showValueRecipeReceived()");
		try {
			recipeForm.setIdUser(getUserLogado().getId());
			LOGGER.info("OUT >> showValueRecipeReceived()");
			final BigDecimal total = recipeService.sumValueRecipeReceivedForMonth(recipeForm);
			LOGGER.info("OUT >> showValueRecipeReceived(total) = " + total);

			return total.toString();
		} catch (Exception e) {
			LOGGER.info("Exception >> (" + e.getMessage() + ")");
		}

		return null;

	}

	@RequestMapping(value = "/showValueRecipeReceivableForMonth", method = RequestMethod.GET)
	@ResponseBody
	public String showValueRecipeReceivableForMonth(@ModelAttribute("recipeForm") RecipeForm recipeForm,
			BindingResult bindingResult) {
		LOGGER.info("INSIDE >> showValueRecipeReceivable()");
		try {
			recipeForm.setIdUser(getUserLogado().getId());
			LOGGER.info("OUT >> showValueRecipeReceivable()");
			final BigDecimal total = recipeService.sumValueRecipeReceivableForMonth(recipeForm);
			LOGGER.info("OUT >> recipeService.sumValueRecipeReceivableForMonth(total) = " + total);
			return total.toString();
		} catch (Exception e) {
			LOGGER.info("Exception >> (" + e.getMessage() + ")");
		}
		return null;
	}

	@RequestMapping(value = "/showValueRecipeConsolidatedForMonth", method = RequestMethod.GET)
	@ResponseBody
	public String showValueRecipeConsolidatedForMonth(@ModelAttribute("recipeForm") RecipeForm recipeForm,
			BindingResult bindingResult) {
		LOGGER.info("INSIDE >> showValueRecipeConsolidatedForMonth()");
		try {
			recipeForm.setIdUser(getUserLogado().getId());
			LOGGER.info("OUT >> showValueRecipeConsolidatedForMonth()");
			final BigDecimal total = recipeService.sumValueRecipeConsolidatedForMonth(recipeForm);
			LOGGER.info("OUT >> recipeService.sumTotalRecipeToRecevedOfYear(total) = " + total);

			return total.toString();
		} catch (Exception e) {
			LOGGER.info("Exception >> (" + e.getMessage() + ")");
		}

		return null;

	}

	@RequestMapping(value = "/showTotalValueRecipeHasCreated", method = RequestMethod.GET)
	@ResponseBody
	public String showTotalValueRecipeHasCreated(@ModelAttribute("recipeForm") RecipeForm recipeForm,
			BindingResult bindingResult) {
		LOGGER.info("INSIDE >> showValueRecipeForCreated()");
		try {
			recipeForm.setIdUser(getUserLogado().getId());
			LOGGER.info("OUT >> showValueRecipeForCreated()");
			final BigDecimal total = recipeService.sumTotalRecipeToRecevedOfYear(recipeForm);
			LOGGER.info("OUT >> recipeService.sumTotalRecipeToRecevedOfYear(total) = " + total);
			return total.toString();
		} catch (Exception e) {
			LOGGER.info("Exception >> (" + e.getMessage() + ")");
		}
		return null;
	}

	private ModelAndView validForm(BindingResult bindingResult, ModelAndView modelAndView) {
		if (bindingResult.hasErrors()) {
			return modelAndView;
		}
		return modelAndView;
	}
	

	private void buildRecipeTableView(RecipeForm recipeForm, ModelAndView modelAndView, List<RecipeEntity> listRecipes,
			UserEntity userEntity) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unused")
	private void buildRecipeTableView(RecipeForm recipeForm, ModelAndView modelAndView, List<RecipeEntity> listRecipes,
			UserEntity userEntity, Set<AccountEntity> listAccounts, List<RecipeTypeEntity> listRecipeTypeEntities) {

		LOGGER.info("INSIDE >> buildRecipeFormView()");

		List<RecipeEntity> efetivarlistRecipes = new ArrayList<>();
		modelAndView.addObject("recipeFormMakeReal", recipeForm);
		modelAndView.addObject("recipeForm", recipeForm);
		modelAndView.addObject("listRecipes", listRecipes);
		modelAndView.addObject("efetivarlistRecipes", efetivarlistRecipes);
		modelAndView.addObject("listAccounts", listAccounts);
		modelAndView.addObject("listRecipeTypeEntities", listRecipeTypeEntities);
		

		LOGGER.info("EXITED >> buildRecipeFormView()");
	}

	@SuppressWarnings("unused")
	private void buildRecipeFormView(RecipeForm recipeForm, ModelAndView modelAndView) {
		LOGGER.info("INSIDE >> buildRecipeFormView()");
		modelAndView.addObject("recipeForm", recipeForm);

		modelAndView.addObject("id", recipeForm.getId());
		modelAndView.addObject("recipeStatus", recipeForm.getRecipeStatus());
		modelAndView.addObject("creationDate", recipeForm.getCreationDate());
		modelAndView.addObject("description", recipeForm.getDescription());
		modelAndView.addObject("idRecipesType", recipeForm.getIdRecipeType());
		modelAndView.addObject("idAccount", recipeForm.getIdAccount());
		modelAndView.addObject("value", recipeForm.getValue());
		LOGGER.info("EXITED >> buildRecipeFormView()");
	}

	@SuppressWarnings("unused")
	private void buildRecipeFormView(RecipeForm recipeForm, ModelAndView modelAndView, RecipeEntity recipeEntity) {
		LOGGER.info("INSIDE >> buildRecipeFormView()");
		modelAndView.addObject("recipeForm", recipeForm);

		modelAndView.addObject("id", recipeEntity.getId());
		modelAndView.addObject("recipeStatus", recipeEntity.getRecipeStatus());
		modelAndView.addObject("creationDate", recipeEntity.getCreationDate());
		modelAndView.addObject("description", recipeEntity.getDescription());
		modelAndView.addObject("idRecipesType", recipeEntity.getRecipeType().getId());
		modelAndView.addObject("idAccount", recipeEntity.getAccount().getId());
		modelAndView.addObject("value", recipeEntity.getValue());
		LOGGER.info("EXITED >> buildRecipeFormView()");
	}

}
