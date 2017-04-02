package org.wpattern.dao;

import org.wpattern.entities.Usuario;

import java.util.List;

/**
 * Created by ocean on 9/20/2015.
 */
public interface UsuarioDao {

     Usuario buscarUsuarioById(Usuario u) throws Exception;
     public List<Usuario> buscarUsuarioLogin(Usuario u) throws Exception;
     Usuario isUsuarioReadyToLogin(String email, String senha);
}
