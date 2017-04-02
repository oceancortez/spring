package service;

import context.AbstractDataBaseTest;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.wpattern.bo.UsuarioBo;
import org.wpattern.entities.Usuario;

import javax.annotation.Resource;
import javax.inject.Inject;

/**
 * Created by ocean on 9/20/2015.
 */
public class UsuarioBoTest extends AbstractDataBaseTest {


    private static final Logger LOGGER = Logger.getLogger(UsuarioBoTest.class);

    @Inject
    UsuarioBo usuarioBo;

    Usuario usuario;

    @Test
    public void findUserById() throws Exception {
        usuario = new Usuario();
        usuario.setIdUsuario(1L);
        Usuario usuarios = usuarioBo.buscarUsuarioById(usuario);

        LOGGER.info(usuarios.getNomUsuario());
    }
}
