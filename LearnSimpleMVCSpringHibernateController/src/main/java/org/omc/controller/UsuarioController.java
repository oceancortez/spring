/**
 * 
 */
package org.omc.controller;

import java.util.HashMap;

import org.omc.dao.entity.UsuarioEntity;
import org.omc.service.UsuarioService;
import org.omc.util.UsuarioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
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
	
	@RequestMapping(value = "getUserByIdResponse/{id}", method = RequestMethod.GET)	
	public @ResponseBody ResponseEntity<UsuarioEntity> getUserByIdResponse(@PathVariable Long id) {
		UsuarioEntity usuarioById = usuarioService.getUsuarioById(id);
		
		return new ResponseEntity<UsuarioEntity>(usuarioById, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "saveUser/{nome}", method = RequestMethod.GET)	
	public @ResponseBody ResponseEntity<UsuarioEntity> saveUser(@PathVariable String nome) {
		UsuarioEntity usuarioById;
		try {
			usuarioById = usuarioService.saveUser(nome);
		} catch (UsuarioException e) {
			MultiValueMap<String, String> rollback = new LinkedMultiValueMap<String, String>();
			rollback.add("message", e.getMessage());
			return new ResponseEntity<UsuarioEntity>(null, rollback ,HttpStatus.ACCEPTED);
		}
		
		return new ResponseEntity<UsuarioEntity>(usuarioById, HttpStatus.CREATED);
	}

}
