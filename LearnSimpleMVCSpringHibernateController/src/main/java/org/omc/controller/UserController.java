/**
 * 
 */
package org.omc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omc.controller.parse.UserParseUtil;
import org.omc.dao.entity.UsuarioEntity;
import org.omc.service.UsuarioService;
import org.omc.util.UserForm;
import org.omc.util.UserOut;
import org.omc.util.UsuarioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
@RequestMapping(value = "user")
@Controller
public class UserController {
	

	
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
	public ResponseEntity<List<UsuarioEntity>> getUsersJson() {
		List<UsuarioEntity> users = usuarioService.getUsers();
		
		return new ResponseEntity<List<UsuarioEntity>>(users, HttpStatus.CREATED);
	}
	
	
	@RequestMapping(value = "save/{nome}/{email}", method = RequestMethod.GET)	
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
	
	
	@RequestMapping(value = "saveOLD", method = RequestMethod.POST)	
	public UserOut saveUser(@RequestBody @ModelAttribute UserForm userForm,
			BindingResult result,HttpServletRequest request, HttpServletResponse response) {
		
		//final String  message = usuarioService.saveUser(UserParseUtil.parseUserFormToEntity(userForm));
		List<UserForm> users = UserParseUtil.parseListUserEntityToForm(usuarioService.getUsers());
		
		
		return new UserOut(null, users, 200);
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)	
	public ResponseEntity<UserOut> usersTest(@ModelAttribute UserForm userForm, BindingResult result) {
		
		final UserOut  userOut = usuarioService.saveUser(UserParseUtil.parseUserFormToEntity(userForm));
		if(userOut.getCodStatus() == 200){
			List<UserForm> users = UserParseUtil.parseListUserEntityToForm(usuarioService.getUsers());
			userOut.setUsers(users);
		}	
		
		return new ResponseEntity<UserOut>(userOut, HttpStatus.CREATED);
	}

}
