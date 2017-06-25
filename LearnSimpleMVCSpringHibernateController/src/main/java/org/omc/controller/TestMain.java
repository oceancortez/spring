/**
 * 
 */
package org.omc.controller;

import javax.servlet.http.HttpServletRequest;

import org.omc.util.Paginas;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author ocean
 *
 */
@Controller
@SessionAttributes(value = {"testMain"})
public class TestMain {
	
	@RequestMapping(value = "testMain", method = RequestMethod.GET)
	public ModelAndView testMain(HttpServletRequest request){
		
		request.setAttribute("inicio", "Teste OK");
		
		return new ModelAndView(Paginas.inicio.forward());
	}

}
