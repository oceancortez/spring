/**
 * 
 */
package org.omc.controller.parse;

import org.omc.controller.form.UserForm;
import org.omc.dao.entity.UsuarioEntity;

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

}
