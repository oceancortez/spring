package org.omc.repositories;

import java.util.List;

import javax.inject.Inject;

import org.omc.AbstractDataBaseTest;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.omc.model.CategoryEntity;
import org.omc.model.repositories.ICategoryRepository;
import org.omc.rest.JSONServiceImpl;


public class CategoryRepositoryTest extends AbstractDataBaseTest {
    private static final Logger LOGGER = Logger.getLogger(CategoryRepositoryTest.class);
     
    @Inject
    private ICategoryRepository categoryRepository;

    @Test
    public void listAllCategoryRepositoryTest(){
        List<CategoryEntity> list = categoryRepository.findAll();
        LOGGER.info(list);
    }

    @Test
    public void findByIdTest(){
        Long id = 25L;
        CategoryEntity categoryEntity = this.categoryRepository.findById(id);
        LOGGER.info("ID >> " + categoryEntity);
    }

 
}
