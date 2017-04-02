package org.wpattern.persistence.impl;

import org.springframework.orm.jpa.JpaTransactionManager;
import org.wpattern.persistence.PersistenceService;
import org.wpattern.service.ModelServiceConstants;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by ocean on 9/20/2015.
 */
public class PersistenceServiceImpl implements PersistenceService {

    private static final long serialVersionUID = -7540968706243561802L;

    @PersistenceContext(unitName = ModelServiceConstants.ENTITY_MANAGER_FACTORY_NAME)
    protected EntityManager em;

    @Resource(name = ModelServiceConstants.DEFAULT_TRANSACTION_MANAGER)
    protected JpaTransactionManager jpaTM;

    @Resource(name = ModelServiceConstants.DEFAULT_DATA_SOURCE)
    protected DataSource defaultDS;


    @Override
    public EntityManager getEM() {
        return em;
    }

    @Override
    public <T> EntityManager getEM(Class<T> clazz) {
        return getEM();
    }

    @Override
    public DataSource getDefaultDS() {
        return defaultDS;
    }

    @Override
    public Connection getJTAConnection() throws PersistenceException, SQLException {
        Connection conn  = jpaTM.getJpaDialect().getJdbcConnection(em, false).getConnection();
        return conn;
    }

    @Override
    public <T> T create(T instance) throws Exception {
        if (instance != null) {
            getEM(instance.getClass()).persist(instance);
        }
        return instance;
    }

    @Override
    public <T> T update(T instance) throws Exception {
        if (instance != null) {
            getEM(instance.getClass()).merge(instance);
        }
        return instance;
    }

    @Override
    public <T> void delete(T persistenceObject) throws Exception {
        if (persistenceObject != null) {
            EntityManager em = getEM(persistenceObject.getClass());
            if (!em.contains(persistenceObject)) {
                persistenceObject = em.merge(persistenceObject);
            }
            em.remove(persistenceObject);
        }
    }

    @Override
    public <T> List<T> findByNamedQuery(Class<T> persistenceClass, String namedQuery, Map<String, Object> conditions) throws Exception {
            // get the named query from persistence class
            Query query = getEM(persistenceClass).createNamedQuery(namedQuery);
            // set the query parameters
            if (conditions != null && !conditions.isEmpty()) {
                Iterator<Map.Entry<String, Object>> it = conditions.entrySet()
                        .iterator();
                while (it.hasNext()) {
                    Map.Entry<String, Object> entry = (Map.Entry<String, Object>) it.next();
                    query.setParameter(entry.getKey(), entry.getValue());
                }
            }
            // execute the query
            return query.getResultList();
    }
}
