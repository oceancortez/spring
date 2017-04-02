package org.oxi.service.api.store.interfaces;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.oxi.utils.constants.ServiceName;
import org.oxi.utils.entities.sale.CategoryEntity;


public interface ICategoryService {
	
	
	
	public CategoryEntity findOne(Long pk);	
	public List<CategoryEntity> listCategorieResource();
	
	

}
