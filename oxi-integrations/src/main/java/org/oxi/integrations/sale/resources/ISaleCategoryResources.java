package org.oxi.integrations.sale.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.oxi.utils.entities.sale.CategoryEntity;

public interface ISaleCategoryResources {
	
	@Produces(MediaType.APPLICATION_JSON)
	@Path(value = "category")
	@GET
	List<CategoryEntity> listCategories();
	
	@Produces(MediaType.APPLICATION_JSON)
	@Path(value = "category/{CategoryID}")
	@GET
	CategoryEntity findCategoryResourceForId(@PathParam("CategoryID")Long categoryID);

}
