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


@Path(value = ServiceName.CATEGORY_REST_SERVICE_API)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface ICategoryServiceRest extends IGenericServiceRest<CategoryEntity, Long> {
	
	/**
	 * curl http://localhost:8082/rest/service/api/category/findOne/2
	 * @param pk
	 * @return
	 */
	@GET
	@Path("/findOne/{pk}")
	public CategoryEntity findOne(@PathParam("pk")Long pk);
	
	@GET
	@Path("/category")
	public List<CategoryEntity> listCategorieResource();
	
	

}
