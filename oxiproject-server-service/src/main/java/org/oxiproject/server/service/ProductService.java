package org.oxiproject.server.service;

import javax.inject.Inject;
import javax.inject.Named;

import org.oxiproject.server.database.repositories.IProductRepository;
import org.oxiproject.server.service.utils.AbstractGenericService;
import org.oxiproject.server.utils.entities.ProductEntity;
import org.oxiproject.server.utils.service.interfaces.IProductService;
import org.springframework.data.jpa.repository.JpaRepository;

@Named
public class ProductService extends AbstractGenericService<ProductEntity, Long> implements IProductService {

	@Inject
	private IProductRepository productRepository;

	@Override
	protected JpaRepository<ProductEntity, Long> getGenericRepository() {
		return this.productRepository;
	}

	@Override
	public ProductEntity findOne(Long pk) {
		if(pk != null){			
		return this.productRepository.findOne(pk);
		}
		return null;
	}

	@Override
	public ProductEntity findByProductName(String productName) {
		
		if(!productName.isEmpty()){
				
		}
		return null;
	}

	@Override
	public int countByProductName(String productName) {
		// TODO Auto-generated method stub
		return 0;
	}

}
