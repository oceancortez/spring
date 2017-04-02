package daos;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.wpattern.daos.CategoryDao;
import org.wpattern.entities.CategoryEntity;
import org.wpattern.utils.DaoFactory;

import java.util.List;

/**
 * Created by ocean on 22/08/2015.
 */
public class CategoryDaoRepositoryTest {

    private static final Logger LOOGER = Logger.getLogger(CategoryDaoRepositoryTest.class);

    private CategoryDao categoryDao = DaoFactory.getCategoryDaoInstance();

    @Test
    public void testFindAll(){
        List<CategoryEntity> categories = this.categoryDao.findAll();

        LOOGER.info(categories);
    }


    @Test
    public void insertCategory() throws Exception{
        boolean answer = true;
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryName("Oceans");
        categoryEntity.setDescritptions("Alto mar");
        categoryDao.save(categoryEntity);
        List<CategoryEntity> categoryByName = categoryDao.findByCategoryName(categoryEntity.getCategoryName());
        for(int i = 0; i < categoryByName.size(); i++){
            Assert.assertEquals(categoryByName.get(i).getCategoryName().equals(categoryEntity.getCategoryName()), answer);
            break;
        }
    }



}
