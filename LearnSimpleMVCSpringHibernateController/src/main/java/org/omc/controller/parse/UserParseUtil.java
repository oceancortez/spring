/**
 * 
 */
package org.omc.controller.parse;

import java.util.ArrayList;
import java.util.List;

import org.omc.dao.entity.UsuarioEntity;
import org.omc.util.UserForm;
import org.springframework.util.CollectionUtils;

/**
 * @author omc
 *
 */

public class UserParseUtil {

	public static UsuarioEntity parseUserFormToEntity(UserForm userForm) {
		UsuarioEntity usuarioEntity = new UsuarioEntity();
		usuarioEntity.setId(userForm.getIdUsuario());
		usuarioEntity.setNome(userForm.getNome());
		usuarioEntity.setEmail(userForm.getEmail());
		return usuarioEntity;
	}

	public static UserForm parseUserEntityToForm(UsuarioEntity usuarioEntity) {
		UserForm userForm = new UserForm();
		userForm.setIdUsuario(usuarioEntity.getId());
		userForm.setNome(usuarioEntity.getNome());
		userForm.setEmail(usuarioEntity.getEmail());
		userForm.setDtUltAlt(usuarioEntity.getDtUltAlt());
		return userForm;
	}
	
	public static List<UserForm> parseListUserEntityToForm(List<UsuarioEntity> usuarioEntities){
		if(CollectionUtils.isEmpty(usuarioEntities)){
			return null;
		}
		List<UserForm> userForms = new ArrayList<UserForm>();
		
		for (UsuarioEntity entity : usuarioEntities) {
			UserForm userForm = parseUserEntityToForm(entity);
			userForms.add(userForm);			
		}
		
		return userForms;
	}

}
