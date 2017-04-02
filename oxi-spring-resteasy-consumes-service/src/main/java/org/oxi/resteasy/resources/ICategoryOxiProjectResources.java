package org.oxi.resteasy.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.oxi.resteasy.domain.CategoryResponse;

/**
 * Definição dos serviços de usuários expostos pelo middleware do portal.
 */
@Path("service/category/")
public interface ICategoryOxiProjectResources {

    
    @GET    
    @Produces(value = { MediaType.APPLICATION_JSON })
    @Path("findOne/{categoryID}")
    public CategoryResponse searchCategoryById(@PathParam("categoryID") Long categoryID);
    
    @GET
    @Produces(value = { MediaType.APPLICATION_JSON })
	@Path(value = "findByNameAndDescription/category-name/{name}/description/{description}")
	public CategoryResponse findByNameAndDescription(@PathParam("name")String name,
			@PathParam("description")String description);

}
