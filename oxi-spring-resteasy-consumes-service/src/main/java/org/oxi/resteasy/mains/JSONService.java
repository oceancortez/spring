package org.oxi.resteasy.mains;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
//TODO  http://www.mkyong.com/webservices/jax-rs/integrate-jackson-with-resteasy/
@Path("/spring3/rest/json/product")
public interface JSONService {

	@GET
	@Path("/get")
	@Produces("application/json")
	public Product getProductInJSON(); 

	

	@POST
	@Path("/post")
	@Consumes("application/json")
	public Response createProductInJSON(Product product);	

}
