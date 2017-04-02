package org.oxi.rest;

import javax.ws.rs.core.Response;

import org.oxi.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class JSONServiceImpl implements JSONService{

	@Override
	public Product getProductInJSON() {

		Product product = new Product();
		product.setName("iPad 3");
		product.setQty(999);
		
		return product; 

	}
	
	public Response createProductInJSON(Product product) {

		String result = "Product created : " + product;
		return Response.status(201).entity(result).build();
		
	}
	
}