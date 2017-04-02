package org.oxi.persistence.store.test.repository;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.oxi.persistence.database.store.repositories.ICategoryRepository;
import org.oxi.persistence.store.test.database.AbstractDatabaseTest;
import org.oxi.utils.entities.sale.CategoryEntity;


public class CategoryRepositoryTest extends AbstractDatabaseTest{
	
	private final Logger LOGGER = Logger.getLogger(this.getClass());

	@Inject
	private ICategoryRepository categoryRepository;

	@Test
	public void testCategoryRepository() {
		List<CategoryEntity> categories = this.categoryRepository.findAll();

		this.LOGGER.debug(categories);
	}
	
	@Test
	public void testFindByCategoryName(){
		List<CategoryEntity> findByCategoryName = this.categoryRepository.findByCategoryName("Condiments");
		
		LOGGER.debug(findByCategoryName);
	}

}
