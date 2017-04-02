package org.oxi.spring.data.jpa.persistences.test;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.oxi.spring.data.jpa.domain.CategoryEntity;
import org.oxi.spring.data.jpa.persistences.ICategoryRepository;
import org.oxi.spring.data.jpa.persistences.database.AbstractDatabaseTest;


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
