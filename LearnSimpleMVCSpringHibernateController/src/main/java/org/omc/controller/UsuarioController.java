/**
 * 
 */
package org.omc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omc.controller.form.UserForm;
import org.omc.controller.parse.UserParseUtil;
import org.omc.dao.entity.UsuarioEntity;
import org.omc.service.UsuarioService;
import org.omc.util.UsuarioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author omc
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
	
	@RequestMapping(value = "getUsersJson", method = RequestMethod.GET)	
	public @ResponseBody ResponseEntity<List<UsuarioEntity>> getUsersJson() {
		List<UsuarioEntity> usuarioById = usuarioService.getUsers();
		
		return new ResponseEntity<List<UsuarioEntity>>(usuarioById, HttpStatus.CREATED);
	}
	
	
	@RequestMapping(value = "saveUser/{nome}/{email}", method = RequestMethod.GET)	
	public @ResponseBody ResponseEntity<String> saveUser(@PathVariable String nome, @PathVariable String email) {
		UsuarioEntity usuarioById;
		try {
			usuarioById = usuarioService.saveUser(nome, email);
		} catch (UsuarioException e) {			
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<String>("Usuario '" + usuarioById.getNome() + "' foi cadastrado com sucesso!", HttpStatus.CREATED);
	}
	
	
	@RequestMapping(value = "getUsers", method = RequestMethod.GET)	
	public ModelAndView  usuarios() {
		List<UsuarioEntity> usuarios = usuarioService.getUsers();
		
		return new ModelAndView("pages/usuarios").addObject("usuarios", usuarios);
	}
	
	
	@RequestMapping(value = "saveUser", method = RequestMethod.POST)	
	public  ModelAndView saveUser(@RequestBody UserForm userForm, BindingResult result,HttpServletRequest request, HttpServletResponse response) {
		
		final String  message = usuarioService.saveUser(UserParseUtil.parseUserFormToEntity(userForm));
		final List<UsuarioEntity> usuarios = usuarioService.getUsers();	
		
		return new ModelAndView("pages/usuarios").addObject("usuarios", usuarios).addObject("message", message);
	}

}
