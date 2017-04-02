package org.wpattern.persistence;

import javax.activation.DataSource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by ocean on 9/20/2015.
 */
public interface PersistenceService {

    EntityManager getEM();
    <T> EntityManager getEM(Class<T> clazz);
    javax.sql.DataSource getDefaultDS();
    Connection getJTAConnection() throws PersistenceException, SQLException;
    <T> T create(T instance) throws Exception;
    <T> T update(T instance) throws Exception;
    <T> void delete(T persistenceObject) throws Exception;

    <T> List<T> findByNamedQuery(Class<T> persistenceClass, String namedQuery,
                                 Map<String, Object> conditions) throws Exception;

}
