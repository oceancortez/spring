package repository;

import context.AbstractDataBaseTest;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.wpattern.dao.UsuarioDao;
import org.wpattern.dao.impl.UsuarioDaoImpl;
import org.wpattern.entities.Usuario;
import org.wpattern.service.ModelServiceConstants;

import javax.annotation.Resource;
import javax.inject.Inject;

/**
 * Created by ocean on 9/20/2015.
 */
public class UsuarioDaoTest extends AbstractDataBaseTest {

    private static final Logger LOGGER = Logger.getLogger(UsuarioDaoTest.class);

    @Autowired
    UsuarioDao usuarioDao;

    Usuario usuario = new Usuario();

    @Test
    public void findUserById() throws Exception{



       //LOGGER.info(usuario.getNomUsuario());
    }
}
