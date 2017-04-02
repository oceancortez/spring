package daos;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.wpattern.bo.UsuarioBoImpl;
import org.wpattern.dao.UsuarioDao;
import org.wpattern.dao.impl.UsuarioDaoImpl;
import org.wpattern.entities.Usuario;
import org.wpattern.utils.DaoFactory;

/**
 * Created by ocean on 9/20/2015.
 */
public class UsuarioDaoTest{

    private static final Logger LOGGER = Logger.getLogger(UsuarioDaoTest.class);

    UsuarioDaoImpl usuarioDao =  DaoFactory.getUsuarioDaoInstance();

    Usuario usuario = new Usuario();

    @Test
    public void findUserById() throws Exception{

        usuario.setNomUsuario("Ocean");
        usuario.setIdUsuario(1L);
        usuario = usuarioDao.findById(usuario.getIdUsuario());
        LOGGER.info(usuario.getNomUsuario());
    }
}
