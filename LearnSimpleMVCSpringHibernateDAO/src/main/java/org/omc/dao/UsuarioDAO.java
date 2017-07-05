package org.omc.dao;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.omc.dao.entity.UsuarioEntity;
import org.omc.util.UsuarioException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@Transactional
public @Repository class UsuarioDAO  extends BaseDAO{

	public UsuarioEntity getUserById(Long id) {
		Query query = getCurrentSession().getNamedQuery("getUserById");
		query.setLong("id", id);
		//Fazendo o bind de object for UsuarioEntity
		query.setResultTransformer(Transformers.aliasToBean(UsuarioEntity.class));
		
		return (UsuarioEntity) query.uniqueResult();
	}

	public UsuarioEntity saveOrUpdate(UsuarioEntity usuarioEntity) throws UsuarioException {
		try {
			usuarioEntity = (UsuarioEntity) getCurrentSession().merge(usuarioEntity);			
			
		} catch (Exception e) {
			if(e.getCause() instanceof MySQLIntegrityConstraintViolationException) {
				getCurrentSession().clear();
				throw new UsuarioException("Favor inserir outro nome!");
			}
			System.out.println(e.getMessage());
		}
		return usuarioEntity;
				
	}
}
