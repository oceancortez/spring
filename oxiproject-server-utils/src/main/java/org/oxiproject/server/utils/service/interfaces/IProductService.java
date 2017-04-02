package org.oxiproject.server.utils.service.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.oxiproject.server.utils.entities.ProductEntity;
import org.oxiproject.server.utils.service.ServiceConstants;
import org.oxiproject.server.utils.service.ServiceName;

@Path(value = ServiceName.PRODUCT_SERVICE)
@Produces(ServiceConstants.MEDIA_TYPE)
@Consumes(ServiceConstants.MEDIA_TYPE)
public interface IProductService extends IGenericService<ProductEntity, Long> {
	
	@GET
	@Path(value = "/findOne/{pk}")
	public ProductEntity findOne(@PathParam("pk")Long pk);
	
	
	@GET
	@Path(value = "/find/{ProductName}")
	public ProductEntity findByProductName(@PathParam("ProductName")String productName);


	//TODO
	@GET
	@Path(value = "/count/{ProductName}")
	public int countByProductName(@PathParam("ProductName")String productName);
	
	

}
