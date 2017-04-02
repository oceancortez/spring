package org.oxi.resteasy.services;

import org.apache.log4j.Logger;
import org.oxi.resteasy.mains.Product;
import org.oxi.resteasy.resources.IMkyoungResources;
import org.springframework.stereotype.Component;

/**
 * Definição dos serviços de usuários expostos pelo middleware do portal.
 */
@Component
public class MkyoungResourcesImpl implements IMkyoungResources{
	private Logger logger = Logger.getLogger(this.getClass());

	@Override
	public Product findMkyoung() {
			logger.info("entro no método [MkyoungResourcesImpl.findMkyoung]");
			Product product = new Product();
			product.setName("iPad 3");			
			product.setQty(999);		
			logger.info("retorno do método [MkyoungResourcesImpl.findMkyoung = ]" + product.getName());
			return product;
			
			}    

}
