package org.wpattern.test.daos;

import org.junit.Assert;
import org.junit.Test;
import org.wpattern.daos.OrderDao;
import org.wpattern.daos.ProductDao;
import org.wpattern.entities.OrderEntity;
import org.wpattern.entities.ProductEntity;
import org.wpattern.utils.DaoFactory;

import java.util.List;

/**
 * Created by ocean on 23/08/2015.
 */
public class ProductDaoRepositoryTest {

    private ProductDao productDao = DaoFactory.getProductDao();

    @Test
    public void findAllTest() throws Exception{

        List<ProductEntity> entityList = productDao.findAll();

        int qtde = entityList.size();

        Assert.assertTrue("A lista será mairo que zero", entityList.size() > 0);
        Assert.assertFalse("A lista será mairo que zero", entityList.size() <= 0);
        Assert.assertTrue("A lista deverá ser igual a variável qtde", entityList.size() == qtde);
    }


}
