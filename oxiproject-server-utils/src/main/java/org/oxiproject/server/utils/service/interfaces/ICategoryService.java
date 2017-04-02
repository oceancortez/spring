package org.oxiproject.server.utils.service.interfaces;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.oxiproject.server.utils.entities.CategoryEntity;
import org.oxiproject.server.utils.service.ServiceName;

@Path(value = ServiceName.CATEGORY_SERVICE)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface ICategoryService extends IGenericService<CategoryEntity, Long> {

	@GET
	@Path("/findOne/{pk}")		
	public CategoryEntity findOne(@PathParam("pk") Long pk);

	@GET
	@Path(value = "/find/{category_name}")	
	public List<CategoryEntity> findByCategoryName(@PathParam("category_name") String categoryName);

	@GET
	@Path(value = "/count/{category_name}")	
	public int countByCategoryName(@PathParam("category_name") String categoryName);
	
	@GET
	@Path(value = "/findByNameAndDescription/category-name/{name}/description/{description}")	
	public CategoryEntity findByNameAndDescription(@PathParam("name")String name,
			@PathParam("description")String description);

}
