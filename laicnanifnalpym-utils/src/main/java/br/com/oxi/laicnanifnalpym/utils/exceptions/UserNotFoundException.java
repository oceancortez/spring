package br.com.oxi.laicnanifnalpym.utils.exceptions;

import org.springframework.web.servlet.ModelAndView;

import br.com.oxi.laicnanifnalpym.utils.enums.Message;
import br.com.oxi.laicnanifnalpym.utils.enums.Route;

public class UserNotFoundException {
	

	public ModelAndView userNotFound(){
		ModelAndView modelAndView  = new ModelAndView();
		modelAndView.setViewName(Route.USER_LOGIN.toString());
		modelAndView.addObject("message", Message.USER_NOT_FOUND.toString());
		
		return modelAndView;
	}

}
