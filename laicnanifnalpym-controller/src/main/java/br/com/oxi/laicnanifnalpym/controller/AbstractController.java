package br.com.oxi.laicnanifnalpym.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import br.com.oxi.laicnanifnalpym.middleware.service.recipetype.RecipeTypeService;
import br.com.oxi.laicnanifnalpym.middleware.service.user.UserService;
import br.com.oxi.laicnanifnalpym.repository.domain.UserEntity;
import br.com.oxi.laicnanifnalpym.utils.enums.Route;

@Controller
public abstract class AbstractController {
    private final Logger LOGGER = Logger.getLogger(AbstractController.class);    

    @Autowired
    protected RecipeTypeService recipeTypeService;

    @Autowired
    private UserService userService;

    protected UserEntity getUserLogado() {
    	String userEmail = null;				
		  SecurityContext context = SecurityContextHolder.getContext();
		  if(context instanceof SecurityContext){
			  Authentication authentication = context.getAuthentication();
		  		if(authentication instanceof Authentication){
		  			userEmail = authentication.getName();
		  		}
		  }		             
		
		return userService.findUserByEmail(userEmail);
	}
    
    public ModelAndView getModelAndView(){
    	ModelAndView modelAndView = new ModelAndView();
    	try {
    		modelAndView.addObject("loggedUser", loggedUser());
        	modelAndView.setViewName(Route.USER_HOME.toString());    		
		} catch (Exception e) {
			LOGGER.error("Erro ao criar ModelAndView "+ e.getMessage());
		}
    	return modelAndView;
    }
        
	public String loggedUser() {
		try {
		LOGGER.info("INSIDE >> logged()");
		UserEntity userEntity = getUserLogado();
		LOGGER.info("OUT >> logged() > " + userEntity.getNameUser());
		return userEntity.getNameUser();
		} catch (Exception e) {
			LOGGER.error("Erro no método loggedUser() "+ e.getMessage());
		}
		return null;
	}

}
