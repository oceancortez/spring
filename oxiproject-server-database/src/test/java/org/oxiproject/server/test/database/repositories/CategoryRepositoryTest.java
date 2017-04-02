package org.oxiproject.server.test.database.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.oxiproject.server.database.repositories.ICategoryRepository;
import org.oxiproject.server.test.database.AbstractDatabaseTest;
import org.oxiproject.server.utils.entities.CategoryEntity;
import org.oxiproject.server.utils.entities.ProductEntity;

public class CategoryRepositoryTest extends AbstractDatabaseTest {

	private final Logger logger = Logger.getLogger(this.getClass());

	@Inject
	private ICategoryRepository categoryRepository;

	@Test
	public void testCategoryRepository() {
		List<CategoryEntity> categories = this.categoryRepository.findAll();

		this.logger.debug(categories);
	}
	
	@Test
	public void testFindByCategoryName(){
		List<CategoryEntity> findByCategoryName = this.categoryRepository.findByCategoryName("Condiments");
		
		logger.debug(findByCategoryName);
	}
	
	
	
	@Test
	public void testfindByCategoryNameInTableCategoryProduct(){
		List<CategoryEntity> findByCategoryName = this.categoryRepository.findByCategoryName("Beverages");
		List<ProductEntity> productName = new ArrayList<>();
		try {			
			for(CategoryEntity categoryEntity : findByCategoryName){
				if(categoryEntity.getProductEntities() != null){
					productName.addAll(categoryEntity.getProductEntities());
					logger.debug(categoryEntity.getProductEntities());
				}
				logger.debug(productName);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		logger.debug(productName);
	}
	
	@Test
	public void testFindByCategoryNameAndDescription(){
		CategoryEntity findByCategoryName =
				this.categoryRepository.findByCategoryNameAndDescription("Produce", "test");
		
		logger.debug(findByCategoryName);
	}

}
