package org.omc.service;

import java.util.List;

import org.omc.dao.GenericDAO;
import org.omc.dao.UsuarioDAO;
import org.omc.dao.entity.UsuarioEntity;
import org.omc.util.UserOut;
import org.omc.util.UsuarioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public @Service class UsuarioService {
	
	@Autowired
	private GenericDAO genericDAO;
	
	@Autowired
	private UsuarioDAO usuarioDAO;	
	
	
//	public UsuarioEntity getUsuarioById(Long id) {
//		return (UsuarioEntity) genericDAO.find(UsuarioEntity.class, id);
//	}
	
	public UsuarioEntity getUsuarioById(Long id) {
		return  usuarioDAO.getUserById(id);
	}

	public UsuarioEntity saveUser(String nome, String email) throws UsuarioException {
		UsuarioEntity usuarioEntity = new UsuarioEntity(null, nome, email);
		usuarioEntity = usuarioDAO.saveOrUpdate(usuarioEntity);
		
		return usuarioEntity;
	}

	public List<UsuarioEntity> getUsers() {
		// TODO Auto-generated method stub
		return usuarioDAO.getUsers();
	}

	public UserOut saveUser(UsuarioEntity usuarioEntity) {
		UserOut userOut = new UserOut();
		try {
			UsuarioEntity entity = usuarioDAO.saveOrUpdate(usuarioEntity);
			userOut.setMessage("Usuário com id ="+entity.getId()+" foi salvo com sucesso!");
			userOut.setCodStatus(200);
			
		} catch (UsuarioException e) {
			e.printStackTrace();
			userOut.setMessage(e.getMessage());
			userOut.setCodStatus(400);
		}
		return userOut;
	}

}
