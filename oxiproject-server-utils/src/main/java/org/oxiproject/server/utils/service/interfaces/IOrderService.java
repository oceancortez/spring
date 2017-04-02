package org.oxiproject.server.utils.service.interfaces;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.oxiproject.server.utils.entities.OrderEntity;
import org.oxiproject.server.utils.service.ServiceConstants;
import org.oxiproject.server.utils.service.ServiceName;

@Path(value = ServiceName.ORDER_SERVICE)
@Produces(ServiceConstants.MEDIA_TYPE)
@Consumes(ServiceConstants.MEDIA_TYPE)
public interface IOrderService extends IGenericService<OrderEntity, Long> {
	
	@GET
	@Path("/findOne/{pk}")
	public OrderEntity findOne(@PathParam("pk")Long pk);
	
	@GET
	@Path(value = "/find/{customerId}")
	public List<OrderEntity> findOrderByCustomerId(@PathParam("customerId")String customerId);
	
	@GET
	@Path(value = "/count/{customerId}")
	public String countByOrderCustomer(@PathParam("customerId")String customerId);
	
	

}
