package org.wpattern.bo;

import org.wpattern.entities.Usuario;

import java.util.List;

/**
 * Created by ocean on 9/20/2015.
 */

public interface UsuarioBo {

     Usuario buscarUsuarioById(Usuario Usuario) throws Exception;
     public List<Usuario> buscarUsuarioLogin(Usuario u);
     Usuario isUsuarioReadyToLogin(String email, String senha);
}
