/**
 * 
 */
package org.omc.controller;

import javax.servlet.http.HttpServletRequest;

import org.omc.service.UsuarioService;
import org.omc.util.Paginas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value = "testMain", method = RequestMethod.GET)
	public ModelAndView testMain(HttpServletRequest request){
		
		request.setAttribute("inicio", "Teste OK");
		
		return new ModelAndView(Paginas.inicio.forward());
	}
	
	@RequestMapping(value = "testMainResponseBody", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody UserController testMainResponseBody(HttpServletRequest request){
		
		//request.setAttribute("inicio", "Teste OK");
		UserController u = new UserController();
	
		
		
		return u;
	}
	
	@RequestMapping(value = "getUserById/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody org.omc.dao.entity.UsuarioEntity getUserById(@PathVariable Long id){
		
		//request.setAttribute("inicio", "Teste OK");
		
		org.omc.dao.entity.UsuarioEntity u = usuarioService.getUsuarioById(id);		
		
		
		return u;
	}

}
