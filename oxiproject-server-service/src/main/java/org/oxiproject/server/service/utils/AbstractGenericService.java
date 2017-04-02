package org.oxiproject.server.service.utils;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.ObjectMapper;
import org.oxiproject.server.utils.BaseEntity;
import org.oxiproject.server.utils.service.interfaces.IGenericService;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class AbstractGenericService<T extends BaseEntity<PK>, PK extends Serializable>
		implements IGenericService<T, PK> {

	private static final ObjectMapper jsonMapper = new ObjectMapper();

	private Logger logger = Logger.getLogger(this.getClass());

	private Class<T> entityType;

	private Class<PK> keyType;

	static {
		jsonMapper.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	@SuppressWarnings("unchecked")
	public AbstractGenericService() {
		if (this.logger.isInfoEnabled()) {
			this.logger.info(String.format("Creating a REST service [%s].", this.getClass().getGenericSuperclass()));
		}

		try {
			ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
			Type[] genericTypes = parameterizedType.getActualTypeArguments();
			entityType = (Class<T>) genericTypes[0];
			setKeyType((Class<PK>) genericTypes[1]);
		} catch (RuntimeException e) {
			this.logger.error(e.getMessage(), e);
			// Re-throw the exception.
			throw e;
		}
	}

	protected abstract JpaRepository<T, PK> getGenericRepository();

	@Override
	public List<T> findAll() {
		this.logger.info(String.format("Classe AbstractGenercicService >> Método findAll ", this.getClass().getGenericSuperclass()));
		return this.getGenericRepository().findAll();
	}

	@Override
	public void insert(Object jsonEntityObject) {
		this.logger.info(String.format("Classe AbstractGenercicService >> Método findAll >> jsonEntityObject = ", jsonEntityObject , this.getClass().getGenericSuperclass()));
		T entityObject = jsonMapper.convertValue(jsonEntityObject, entityType);
		this.logger.info(String.format("Classe AbstractGenercicService >> Método findAll >> entityObject = ", entityObject , this.getClass().getGenericSuperclass()));
		this.getGenericRepository().saveAndFlush(entityObject);
	}

	@Override
	public void delete(Object jsonKeyObject) {
		PK keyObject = jsonMapper.convertValue(jsonKeyObject, keyType);
		this.getGenericRepository().delete(keyObject);
	}

	@Override
	public void update(Object jsonEntityObject) {
		T entityObject = jsonMapper.convertValue(jsonEntityObject, entityType);

		this.getGenericRepository().save(entityObject);

	}

	protected Class<PK> getKeyType() {
		return keyType;
	}

	protected void setKeyType(Class<PK> keyType) {
		this.keyType = keyType;
	}

	protected Class<T> getEntityType() {
		return entityType;
	}

	protected void setEntityType(Class<T> entityType) {
		this.entityType = entityType;
	}

}
