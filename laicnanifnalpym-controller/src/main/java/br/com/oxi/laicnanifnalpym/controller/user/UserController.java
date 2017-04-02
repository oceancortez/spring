package br.com.oxi.laicnanifnalpym.controller.user;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import br.com.oxi.laicnanifnalpym.controller.AbstractController;
import br.com.oxi.laicnanifnalpym.middleware.service.forms.UserForm;
import br.com.oxi.laicnanifnalpym.middleware.service.recipe.RecipeService;
import br.com.oxi.laicnanifnalpym.middleware.service.user.UserService;
import br.com.oxi.laicnanifnalpym.repository.domain.UserEntity;
import br.com.oxi.laicnanifnalpym.utils.enums.Message;
import br.com.oxi.laicnanifnalpym.utils.enums.Route;

@Controller
@RequestMapping("user")
public class UserController extends AbstractController {
	private final Logger LOGGER = Logger.getLogger(UserController.class);	

	@Autowired
	private UserService userService;
	
	@Autowired
	private RecipeService recipeService;

	@Secured("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public ModelAndView buildFormUser(@ModelAttribute("user") UserForm userForm, BindingResult bindingResult) {
		LOGGER.info("INSIDE >> buildFormUser()");
		ModelAndView modelAndView = getModelAndView();
		
		modelAndView.setViewName(Route.USER_CREATE.toString());
		buildUserFormView(userForm, modelAndView);
		LOGGER.info("OUT >> buildFormUser()");
		return modelAndView;

	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public ModelAndView create(@Valid UserForm userForm, BindingResult bindingResult) {
		ModelAndView modelAndView = getModelAndView();
		
		LOGGER.info("INSIDE >> create()");
		try {
			validForm(bindingResult, modelAndView);
			UserEntity user = new UserEntity();
			user = userService.findUserByEmail(userForm.getEmail());
			if (user == null) {
				LOGGER.info("INSIDE >> userService.saveUser()");
				userService.saveUser(userForm, user);
				modelAndView.setViewName(Route.USER_SIGN_IN.toString());
				LOGGER.info("EXITED >> userService.saveUser()");
				return modelAndView;
			}

			modelAndView.setViewName(Route.USER_CREATE.toString());
			modelAndView.addObject("userForm", userForm);
			modelAndView.addObject("message", Message.USER_ALREADY.toString());
			LOGGER.info("EXITED >> userService.saveUser() = USER_ALREADY");

		} catch (Exception e) {
			LOGGER.info("INSIDE >> create() Exception = " + e.getMessage());
		}
		return modelAndView;

	}

	private ModelAndView validForm(BindingResult bindingResult, ModelAndView modelAndView) {
		if (bindingResult.hasErrors()) {
			return modelAndView;
		}
		return modelAndView;
	}

	@RequestMapping(value = "logged", method = RequestMethod.GET)
	public String logged() {
		LOGGER.info("INSIDE >> logged()");
		UserEntity userEntity = getUserLogado();
		LOGGER.info("OUT >> logged() > " + userEntity.getNameUser());
		return userEntity.getNameUser();
	}
	
	@RequestMapping(value = "signIn", method = RequestMethod.POST)
	public ModelAndView signIned(@Valid UserForm userForm, BindingResult bindingResult) {
		LOGGER.info("INSIDE >> signIned()");
		ModelAndView modelAndView = getModelAndView();
		
		validForm(bindingResult, modelAndView);
		
		UserEntity user = new UserEntity();
		LOGGER.info("INSIDE >> findUserByEmailAndPassword.???()");
		user = userService.findUserByEmailAndPassword(userForm.getEmail(), userForm.getPassword());
		if (user != null) {						
			modelAndView.setViewName(Route.USER_HOME.toString());
			LOGGER.info("EXITED >> findUserByEmailAndPassword.???()");
			return modelAndView;
		}

		modelAndView.setViewName(Route.USER_SIGN_IN.toString());
		modelAndView.addObject("userForm", userForm);
		modelAndView.addObject("message", Message.USER_NOT_FOUND.toString());
		LOGGER.info("EXITED >> userService.saveUser() = USER_NOT_FOUND");		
		return modelAndView;

	}
	
	@RequestMapping(value = "home", method = RequestMethod.GET)
	public ModelAndView home(@ModelAttribute("userForm") UserForm userForm, BindingResult bindingResult) {
		LOGGER.info("INSIDE >> home()");
		ModelAndView modelAndView = getModelAndView();
		
		modelAndView.setViewName(Route.USER_HOME.toString());
		UserEntity userEntity = new UserEntity();
		userEntity.setId(1L);
		//List<RecipeEntity> listRecipes = recipeService.listRecipesByUser(userEntity);
				
		buildUserFormView(userForm, modelAndView);
		LOGGER.info("OUT >> home()");
		return modelAndView;

	}
	
	@RequestMapping(value = "sidebar", method = RequestMethod.GET)
	public ModelAndView sidebar() {
		LOGGER.info("INSIDE >> home()");
		ModelAndView modelAndView = getModelAndView();
		
		modelAndView.setViewName(Route.USER_SIDEBAR.toString());
//		buildUserFormView(userForm, modelAndView);
		LOGGER.info("OUT >> home()");
		return modelAndView;

	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {

	  ModelAndView model = new ModelAndView();
	  if (error != null) {
		model.addObject("error", "Invalid username and password!");
	  }

	  if (logout != null) {
		model.addObject("msg", "You've been logged out successfully.");
	  }
	  model.setViewName(Route.USER_LOGIN.toString());

	  return model;

	}
	
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public ModelAndView logout() {
		
	  ModelAndView model = new ModelAndView();
	  model.setViewName(Route.USER_LOGIN.toString());
	  
	  SecurityContext context = SecurityContextHolder.getContext();
	  if(context instanceof SecurityContext){
		  Authentication authentication = context.getAuthentication();
		  if(authentication instanceof Authentication){
			  UserEntity userEntity  = getUserLogado();
			  SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
			  if(userEntity != null){
				  
			  }
		  }
	  }
	  	  
	  return model;

	}
	

	@SuppressWarnings("unused")
	private void buildUserFormView(UserForm userForm, ModelAndView modelAndView) {
		LOGGER.info("INSIDE >> buildUserFormView()");
		modelAndView.addObject("userForm", userForm);

		modelAndView.addObject("nameUser", userForm.getNameUser());
		modelAndView.addObject("email", userForm.getEmail());
		modelAndView.addObject("password", userForm.getPassword());
		modelAndView.addObject("confirmPassword", userForm.getConfirmPassword());
		LOGGER.info("OUT >> buildUserFormView()");
	}

}
