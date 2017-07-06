package org.omc.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import org.hibernate.type.TimestampType;
import org.omc.dao.entity.UsuarioEntity;
import org.omc.util.UsuarioException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@Transactional
public @Repository class UsuarioDAO  extends BaseDAO{

	public UsuarioEntity getUserById(Long id) {
		SQLQuery query = (SQLQuery) getCurrentSession().getNamedQuery("getUserById");
		query.setLong("id", id);
		//Fazendo o bind de object for UsuarioEntity
		preencherProjecao(query);
		query.setResultTransformer(Transformers.aliasToBean(UsuarioEntity.class));
		
		return (UsuarioEntity) query.uniqueResult();
	}

	private void preencherProjecao(SQLQuery query) {
		query.addScalar("id", IntegerType.INSTANCE);
		query.addScalar("nome", StringType.INSTANCE);
		query.addScalar("dtUltAlt", TimestampType.INSTANCE);		
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

	@SuppressWarnings("unchecked")
	public List<UsuarioEntity> getUsers() {
		SQLQuery query = (SQLQuery) getCurrentSession().getNamedQuery("getUsers");		
		//Fazendo o bind de object for UsuarioEntity
		preencherProjecao(query);
		query.setResultTransformer(Transformers.aliasToBean(UsuarioEntity.class));
		
		return  query.list();
		
	}
}
