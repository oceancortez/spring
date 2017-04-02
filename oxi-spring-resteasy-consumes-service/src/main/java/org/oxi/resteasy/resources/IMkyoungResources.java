package org.oxi.resteasy.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.oxi.resteasy.mains.Product;

/**
 * Definição dos serviços de usuários expostos pelo middleware do portal.
 */
@Path("mkyoung/")
public interface IMkyoungResources {

    
    @GET    
    @Produces(value = { MediaType.APPLICATION_JSON })
    @Path("find")
    Product findMkyoung();   


}
