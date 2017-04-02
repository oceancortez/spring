package daos;

import org.junit.Assert;
import org.junit.Test;
import org.wpattern.daos.OrderDetailDao;
import org.wpattern.entities.OrderDetailEntity;
import org.wpattern.utils.DaoFactory;

import java.util.List;

/**
 * Created by ocean on 23/08/2015.
 */
public class OrderDetailDaoRepositoryTest {

    private OrderDetailDao orderDetailDao = DaoFactory.getOrderDetailDaoInstance();

    @Test
    public void findAll() throws Exception{
        List<OrderDetailEntity> detailEntityList = orderDetailDao.findAll();

        int qtde = detailEntityList.size();

        Assert.assertTrue("A lista será maior que zero", detailEntityList.size() > 0);
        Assert.assertTrue("A lista será maior que zero", detailEntityList.size() == qtde);
        Assert.assertFalse("A lista será maior que zero", detailEntityList.size() < 0);


    }
}

