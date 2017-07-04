package org.omc.dao;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.omc.dao.entity.UsuarioEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public @Repository class UsuarioDAO  extends BaseDAO{

	public UsuarioEntity getUserById(Long id) {
		Query query = getCurrentSession().getNamedQuery("getUserById");
		query.setLong("id", id);
		//Fazendo o bind de object for UsuarioEntity
		query.setResultTransformer(Transformers.aliasToBean(UsuarioEntity.class));
		
		return (UsuarioEntity) query.uniqueResult();
	}

	public void saveOrUpdate(UsuarioEntity usuarioEntity) {
//		Query query = getCurrentSession().getNamedQuery("insertUser");
//		query.setInteger("id", usuarioEntity.getId());
//		query.setString("nome", usuarioEntity.getNome());
				
		getCurrentSession().save(usuarioEntity);
				
	}
}
