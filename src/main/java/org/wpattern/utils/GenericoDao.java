package org.wpattern.utils;

import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.wpattern.persistence.PersistenceService;
import org.wpattern.persistence.impl.PersistenceServiceImpl;
import org.wpattern.service.ModelServiceConstants;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.lang.reflect.ParameterizedType;
import java.util.List;


public  class GenericoDao<T> extends PersistenceServiceImpl {

    @Resource(name = ModelServiceConstants.PERSISTENCE_SERVICE_NAME)
    private PersistenceService persistenceService;

    @SuppressWarnings("unchecked")
    public T recuperar(Criteria criteria, Long codPk) throws Exception{
    try{
        return (T) criteria.uniqueResult();
    }finally {

    }

    }

    @SuppressWarnings("unchecked")
    public List<T> listar(Criteria criteria, Integer codPk, String dscAcao, Integer codUsuarioLogAuditoria) throws Exception{
        try{
            return criteria.list();
        }finally{

        }
    }

    @SuppressWarnings("unchecked")
    public T inserir(PersistenceService persistenceService, T t, Integer codPk,String dscAcao,Integer codUsuarioLogAuditoria ) throws Exception{
        try {
            return persistenceService.create(t);
        } finally {

        }
    }

    @SuppressWarnings("unchecked")
    public T atualizar(PersistenceService persistenceService, T t, Integer codPk,String dscAcao,Integer codUsuarioLogAuditoria ) throws Exception{
        try {
            return  persistenceService.update(t);
        } finally {

        }
    }

    @SuppressWarnings("unchecked")
    public void deletarLogico(PersistenceService persistenceService, T t, Integer codPk,String dscAcao,Integer codUsuarioLogAuditoria ) throws Exception{
        try {
            persistenceService.update(t);
        } finally {

        }
    }

    @SuppressWarnings("unchecked")
    public void deletar(PersistenceService persistenceService, T t, Integer codPk,String dscAcao,Integer codUsuarioLogAuditoria ) throws Exception{
        try {
            persistenceService.delete(t);
        } finally {

        }
    }



}
