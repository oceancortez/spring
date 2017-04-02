package org.wpattern.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.wpattern.dao.UsuarioDao;
import org.wpattern.entities.Usuario;
import org.wpattern.service.ModelServiceConstants;
import org.wpattern.utils.GenericDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Repository(ModelServiceConstants.USUARIO_DAO)
@Transactional
public class UsuarioDaoImpl extends GenericDao<Usuario, Long> implements UsuarioDao {

    private static final long serialVersionUID = 2272443813667571091L;

    private static Log LOG = LogFactory.getLog(UsuarioDaoImpl.class);

    /*@Resource(name = ModelServiceConstants.PERSISTENCE_SERVICE_NAME)
    private PersistenceService persistenceService;*/

    @PersistenceContext
    private EntityManager entityManager;

    public Usuario buscarUsuarioById(Usuario u) throws Exception{
        try{
            Session session = (Session) entityManager.getDelegate();
            Criteria criteria = session.createCriteria(Usuario.class);
            criteria.createAlias("usuario", "u");
            return super.findById(u.getIdUsuario());
        }catch (Exception e){
            String erroMsg = "Erro ao buscar: + " + this.getClass().getName() + " - " + u.getNomUsuario();
            LOG.error("buscarUsuarioById = " + e);
            throw new RuntimeException(erroMsg, e);
        }

    }

    public List<Usuario> buscarUsuarioLogin(Usuario u) throws Exception{
        try{
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Usuario> cq = builder.createQuery(Usuario.class);
            Root<Usuario> root = cq.from(Usuario.class);
            cq.select(root);
            return entityManager.createQuery(cq).getResultList();
        }catch (Exception e){
            String erroMsg = "Erro ao buscar: + " + this.getClass().getName() + " - " + u.getNomUsuario();
            LOG.error("buscarUsuarioById = " + e);
            throw new RuntimeException(erroMsg, e);
        }

    }

    @Override
    public Usuario isUsuarioReadyToLogin(String email, String senha) {
        return null;
    }
}
