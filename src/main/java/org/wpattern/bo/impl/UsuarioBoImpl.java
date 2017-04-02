package org.wpattern.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wpattern.dao.UsuarioDao;
import org.wpattern.entities.Usuario;

import java.util.List;

/**
 * Created by ocean on 9/20/2015.
 */
@Service
public class UsuarioBoImpl implements UsuarioBo {

    @Autowired
    UsuarioDao usuarioDao;


    @Transactional
    public Usuario buscarUsuarioById(Usuario usuario) throws Exception {

        return usuarioDao.buscarUsuarioById(usuario);
    }

    public List<Usuario> buscarUsuarioLogin(Usuario usuario){
        return usuarioDao.buscarUsuarioLogin(usuario);
    }

    @Override
    public Usuario isUsuarioReadyToLogin(String email, String senha) {
        return usuarioDao.isUsuarioReadyToLogin(email, senha);
    }
}
