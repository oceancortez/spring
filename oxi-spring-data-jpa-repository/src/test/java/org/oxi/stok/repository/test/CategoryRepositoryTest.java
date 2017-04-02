package org.oxi.stok.repository.test;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.oxi.stok.config.test.AbstractDatabaseTest;
import org.oxi.stok.domain.CategoryEntity;
import org.oxi.stok.repository.ICategoryRepository;


public class CategoryRepositoryTest extends AbstractDatabaseTest{
	
	private final Logger logger = Logger.getLogger(CategoryRepositoryTest.class);
	
	@Inject
	private ICategoryRepository categoryRepository;
	
	@Test
	public void testCategoryRepository() {
		List<CategoryEntity> categories = this.categoryRepository.findAll();

		this.logger.debug(categories);
	}

}
