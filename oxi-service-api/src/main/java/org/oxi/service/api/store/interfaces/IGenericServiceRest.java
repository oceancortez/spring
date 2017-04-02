package org.oxi.service.api.store.interfaces;

import java.io.Serializable;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;

import org.oxi.utils.base.utils.BaseEntity;

public interface IGenericServiceRest<T extends BaseEntity<PK>,PK extends Serializable > {
	
	
	@GET
	public List<T> findAll();
	
	@POST
	public void insert(Object jsonEntityObject);
	
	@DELETE
	public void delete(Object jsonEntityObject);
	
	@PUT
	public void update(Object jsonEntityObject);

}
