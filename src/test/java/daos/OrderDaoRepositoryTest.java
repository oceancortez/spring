package daos;

import org.junit.Assert;
import org.junit.Test;
import org.wpattern.daos.OrderDao;
import org.wpattern.entities.OrderEntity;
import org.wpattern.utils.DaoFactory;

import java.util.List;

/**
 * Created by ocean on 23/08/2015.
 */
public class OrderDaoRepositoryTest {

    private OrderDao orderDao = DaoFactory.getOrderDaoInstance();

    @Test
    public void findAll() throws Exception{

        List<OrderEntity> orderEntityList = orderDao.findAll();

        Assert.assertTrue("Lista será maior que zero", orderEntityList.size() > 0 );
        Assert.assertFalse("Lista será maior que zero", orderEntityList.size() < 0);

    }
}
