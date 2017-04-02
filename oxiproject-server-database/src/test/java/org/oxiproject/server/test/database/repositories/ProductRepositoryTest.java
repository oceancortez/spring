package org.oxiproject.server.test.database.repositories;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.hibernate.classic.Session;
import org.hibernate.ejb.criteria.predicate.BooleanExpressionPredicate;
import org.junit.Test;
import org.oxiproject.server.database.repositories.IProductRepository;
import org.oxiproject.server.test.database.AbstractDatabaseTest;
import org.oxiproject.server.utils.entities.ProductEntity;
import org.springframework.data.jpa.repository.Query;

public class ProductRepositoryTest extends AbstractDatabaseTest {

	private final Logger logger = Logger.getLogger(this.getClass());

	@Inject
	private IProductRepository productRepository;
	
	@Inject
	protected EntityManager em;

	@Test
	public void testProductRepository() {
		List<ProductEntity> products = this.productRepository.findAll();

		this.logger.debug(products);
	}
	
	
//	@Test
//	public void testFindaAllProductRepositoryWithoutCateogoryAssociate() {
//		
//		 
//		List<ProductEntity> products = productRepository.findAllProductsWithoutCategory();
//
//		this.logger.debug(products);
//	}

}
