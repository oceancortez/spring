package org.oxiproject.server.utils.service.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.oxiproject.server.utils.entities.OrderDetailEntity;
import org.oxiproject.server.utils.entities.keys.OrderDetailKeyEntity;
import org.oxiproject.server.utils.service.ServiceConstants;
import org.oxiproject.server.utils.service.ServiceName;

@Path(value = ServiceName.ORDER_DETAIL_SERVICE)
@Produces(ServiceConstants.MEDIA_TYPE)
@Consumes(ServiceConstants.MEDIA_TYPE)
public interface IOrderDetailService extends IGenericService<OrderDetailEntity, OrderDetailKeyEntity> {

	
	@GET
	@Path(value = "/findOne/{pk}")
	public OrderDetailEntity findOne(@PathParam("pk")Long pk);
	
	
	@GET
	@Path(value = "find/{orderId}")
	OrderDetailEntity findByOrderDetailId(@PathParam("orderId")Long orderId);		
	
	
}
