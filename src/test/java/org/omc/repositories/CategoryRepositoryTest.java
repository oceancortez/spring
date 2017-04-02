package org.omc.repositories;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.omc.AbstractDataBaseTest;
import org.omc.model.CategoryEntity;
import org.omc.model.repositories.ICategoryRepository;

import javax.inject.Inject;
import java.util.List;


public class CategoryRepositoryTest extends AbstractDataBaseTest {
    private static final Logger LOGGER = Logger.getLogger(CategoryRepositoryTest.class);

    @Inject
    private ICategoryRepository categoryRepository;

    @Test
    public void listAllCategoryRepositoryTest(){
        List<CategoryEntity> list = categoryRepository.findAll();
        LOGGER.info(list);
    }
}
