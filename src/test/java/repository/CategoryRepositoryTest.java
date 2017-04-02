package repository;

import context.AbstractDataBaseTest;
import org.apache.log4j.Logger;
import org.hibernate.service.spi.InjectService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.wpattern.daos.CategoryDao;
import org.wpattern.entities.CategoryEntity;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by ocean on 9/19/2015.
 */

public class CategoryRepositoryTest extends AbstractDataBaseTest{

    private static final Logger LOGGER = Logger.getLogger(CategoryRepositoryTest.class);

     @Inject
     CategoryDao categoryDao;

    @Test
    public void testCategoryRepository(){
        List<CategoryEntity> categoryEntities = this.categoryDao.findAll();

        LOGGER.info(categoryEntities);
    }


}
