/**
 * 
 */
package org.omc.controller;

import org.omc.dao.entity.UsuarioEntity;
import org.omc.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ocean
 *
 */
@RequestMapping(value = "usuario")
@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value = "getUserBy/{id}", method = RequestMethod.GET)
	public @ResponseBody UsuarioEntity getUserById(@PathVariable Long id) {
		
		return usuarioService.getUsuarioById(id);
	}

}
