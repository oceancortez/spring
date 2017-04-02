package org.omc.support.settings.user;

import javax.inject.Named;

import org.omc.constant.Role;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

@Scope(value = WebApplicationContext.SCOPE_SESSION)
@Named(value = "roleForEnum")
public class RoleForEnum {	

	public Role[] getRoles() {
		return Role.values();
	}

	
	

}
