package br.com.oxi.laicnanifnalpym.controller.recipe;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.oxi.laicnanifnalpym.controller.AbstractController;
import br.com.oxi.laicnanifnalpym.middleware.service.forms.RecipeForm;
import br.com.oxi.laicnanifnalpym.middleware.service.forms.RecipeTypeForm;
import br.com.oxi.laicnanifnalpym.middleware.service.recipetype.RecipeTypeService;
import br.com.oxi.laicnanifnalpym.middleware.service.user.UserService;
import br.com.oxi.laicnanifnalpym.repository.domain.RecipeEntity;
import br.com.oxi.laicnanifnalpym.repository.domain.RecipeTypeEntity;
import br.com.oxi.laicnanifnalpym.repository.domain.UserEntity;
import br.com.oxi.laicnanifnalpym.utils.enums.Message;
import br.com.oxi.laicnanifnalpym.utils.enums.Route;

@Controller
@RequestMapping("recipeType")
public class RecipeTypeController extends AbstractController {
	
	private final Logger LOGGER = Logger.getLogger(RecipeTypeController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RecipeTypeService recipeTypeService;
	
	
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public ModelAndView createRecipeType(){
		LOGGER.info("INSIDE >> createRecipeType()");
		RecipeTypeForm recipeTypeForm = new RecipeTypeForm();
		ModelAndView modelAndView = getModelAndView();
		
		modelAndView.setViewName(Route.RECIPE_TYPE_CREATE.toString());
		buildFormRecipeType(recipeTypeForm, modelAndView);
		LOGGER.info("EXIT >> createRecipeType()");
		return modelAndView;
	}	
	
	 @RequestMapping(value = "create", method = RequestMethod.POST)
	    public ModelAndView create(@Valid RecipeTypeForm recipeTypeForm, BindingResult bindingResult) {
		 ModelAndView modelAndView = getModelAndView();
		 
	        modelAndView.setViewName(Route.RECIPE_TYPE_CREATE.toString());
	        LOGGER.info("INSIDE >> create()");
	        try {
	        	UserEntity userEntity = getUserLogado();
	            List<RecipeTypeEntity> listRecipeTypeEntity = recipeTypeService.listRecipeTypesByUser(userEntity.getId());
	            
	            boolean isRecipeTypeAlready = isFormRecipeTypeValid(recipeTypeForm, listRecipeTypeEntity); 
	            if (recipeTypeForm != null) {	                
	                if(!isRecipeTypeAlready){	                	
	                	return modelAndView.addObject("message", Message.RECIPE_TYPE_ALREADY.toString());	                	 
	                }	                
	                LOGGER.info("INSIDE >> userService.add()");	                
	                boolean isSave = recipeTypeService.saveOrUpdateRecipeType(recipeTypeForm, userEntity);	                
	                    if (!isRecipeTypeAlready && isSave) {
	                        modelAndView.setViewName(Route.RECIPE_TYPE_CREATE.toString());
	                        modelAndView.addObject("message", Message.RECIPE_TYPE_CREATE.toString());
	                        LOGGER.info("EXITED >> userService.saveUser()");
	                        return modelAndView;
	                    } else {
	                        modelAndView.setViewName(Route.RECIPE_TYPE_CREATE.toString());                        
	                        modelAndView.addObject("message", Message.RECIPE_TYPE_UPDATE.toString());
	                        LOGGER.info("EXITED >> update = USER_ALREADY");
	                        return modelAndView;
	                    }
	            }

	        } catch (Exception e) {
	            LOGGER.error("INSIDE >> create() Exception = " + e.getMessage());
	        }
	        return modelAndView;
	    }
	 
	 
	 public boolean isFormRecipeTypeValid(RecipeTypeForm recipeTypeForm, List<RecipeTypeEntity> listRecipeTypeEntity){		 
		 for(RecipeTypeEntity entity : listRecipeTypeEntity){
			 if(recipeTypeForm.getType().toLowerCase().equals(entity.getType().toLowerCase())){
				 return false;
			 }	 
		 }
		 
		 return true;		 
	 }
	
	public void buildFormRecipeType(RecipeTypeForm recipeTypeForm,ModelAndView modelAndView){		
		modelAndView.addObject("recipeTypeForm", recipeTypeForm);
	}

}
