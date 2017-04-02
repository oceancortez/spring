package org.oxi.service.store.test.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.oxi.persistence.store.test.database.AbstractDatabaseTest;
import org.oxi.service.store.service.impl.CategoryServiceRestImpl;
import org.oxi.utils.entities.sale.CategoryEntity;

public class CategoryServiceTest extends AbstractDatabaseTest{

	private final Logger logger = Logger.getLogger(this.getClass());

	@Inject
	private CategoryServiceRestImpl categoryServiceImpl;

	
	
	@Test
	public void countCategoryTest(){
		List<CategoryEntity> categoryEntities = this.categoryServiceImpl.findAll();
		
		if(categoryEntities.size() > 0){
			this.logger.debug("Total de CategoryEntity  = " + categoryEntities.size());	
		}
		
		this.logger.debug(categoryEntities);
		
	}

}
