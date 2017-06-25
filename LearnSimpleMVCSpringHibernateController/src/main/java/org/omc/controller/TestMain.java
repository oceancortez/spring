/**
 * 
 */
package org.omc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.omc.util.Paginas;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@RequestMapping(value = "testMainResponseBody", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Usuario testMainResponseBody(HttpServletRequest request){
		
		//request.setAttribute("inicio", "Teste OK");
		Usuario u = new Usuario();
		u.setNome("Usuario OK");
		
		
		return u;
	}

}
