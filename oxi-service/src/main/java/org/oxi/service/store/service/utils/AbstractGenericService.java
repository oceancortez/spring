package org.oxi.service.store.service.utils;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.ObjectMapper;
import org.oxi.service.api.store.interfaces.IGenericServiceRest;
import org.oxi.utils.base.utils.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class AbstractGenericService<T extends BaseEntity<PK>, PK extends Serializable> implements IGenericServiceRest<T, PK> {
	
	
	private static final ObjectMapper jsonMapper = new ObjectMapper();
	
	private Logger LOGGER = Logger.getLogger(this.getClass());
	
	private Class<T> entityType;
	
	private Class<PK> keyType;
	
	static{
		jsonMapper.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	@SuppressWarnings("unchecked")
	public AbstractGenericService() {
		if(this.LOGGER.isInfoEnabled()){
		this.LOGGER.info(String.format("Creating a REST service [%s].", this.getClass().getGenericSuperclass()));
		}
		
		try {
			ParameterizedType parameterizedType  = (ParameterizedType) this.getClass().getGenericSuperclass();
			Type[] genericTypes = parameterizedType.getActualTypeArguments();
			entityType = (Class<T>) genericTypes[0];
			setKeyType((Class<PK>) genericTypes[1]);
			
		} catch (RuntimeException e) {
			 this.LOGGER.error(e.getMessage(), e);
			 throw e;
		}
		
	}
	
	protected abstract JpaRepository<T, PK> getGenericRepository();
	
	
	@Override
	public List<T> findAll() {
		this.LOGGER.info(String.format("Classe AbstractGenercicService >> Método findAll ", this.getClass().getGenericSuperclass()));
		return getGenericRepository().findAll();
	}	

	@Override
	public void insert(Object jsonEntityObject) {
		this.LOGGER.info(String.format("Classe AbstractGenercicService >> Método findAll >> jsonEntityObject = ", jsonEntityObject , this.getClass().getGenericSuperclass()));
		T entityObject = jsonMapper.convertValue(jsonEntityObject, entityType);
		this.getGenericRepository().saveAndFlush(entityObject);
		
	}

	@Override
	public void delete(Object jsonEntityObject) {
		PK keyObject = jsonMapper.convertValue(jsonEntityObject, keyType);
		this.getGenericRepository().delete(keyObject);
	}

	@Override
	public void update(Object jsonEntityObject) {
		T entityObject = jsonMapper.convertValue(jsonEntityObject, entityType);
		this.getGenericRepository().save(entityObject);		
	}

	public Class<T> getEntityType() {
		return entityType;
	}

	public void setEntityType(Class<T> entityType) {
		this.entityType = entityType;
	}

	public Class<PK> getKeyType() {
		return keyType;
	}

	public void setKeyType(Class<PK> keyType) {
		this.keyType = keyType;
	}
	
	
	
	
	
	
	
	
	

}
