package org.omc.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = Exception.class)
public @Repository class GenericDAO extends BaseDAO{
	
	public <T> void saveOrUpdate(T object) {
		getCurrentSession().saveOrUpdate(object);
	}
	
	public void delete(Object object) {
		getCurrentSession().delete(object);
	}
	
	public Object find(Class<? extends Object> clazz, Serializable id) {
		return getCurrentSession().get(clazz, id);
	}


	@SuppressWarnings("rawtypes")
	public List findAll(Class<? extends Object> clazz) {
		return getCurrentSession().createQuery("from " + clazz.getName()).list();
	}
	
}
