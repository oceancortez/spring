package org.omc.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/rest/category/")
public interface JSONService {
	
	@GET
	@Path("getCategoryInJSON")
	@Produces("application/json")
	 Response getCategoryInJSON();



	@POST
	@Path("listCategoryInJSON")
	@Consumes("application/json")
	 Response listCategoryInJSON();
	
	@GET
	@Path("listcatecorymock")
	@Produces("application/json")
	 Response listCatecoryMock();

}