package org.wpattern.utils;

import org.wpattern.daos.CategoryDao;
import org.wpattern.daos.OrderDao;
import org.wpattern.daos.OrderDetailDao;
import org.wpattern.daos.ProductDao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by ocean on 22/08/2015.
 */
public final class DaoFactory {

    private static final String PERSISTENCE_UNIT_NAME = "wprojectPersistenceUnit";

    private static EntityManagerFactory entityManagerFactoryInstance;

    public static EntityManagerFactory entityManagerFactoryInstance(){
        if(entityManagerFactoryInstance == null){
            entityManagerFactoryInstance = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return entityManagerFactoryInstance;
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////
    //CATEGORY
    //////////////////////////////////////////////////////////////////////////////////////////////////////

    private static CategoryDao categoryDaoInstance;

    public static CategoryDao getCategoryDaoInstance(){
        if(categoryDaoInstance == null){
            categoryDaoInstance = new CategoryDao();
        }

        return categoryDaoInstance;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    //ORDER
    //////////////////////////////////////////////////////////////////////////////////////////////////////
    private static OrderDao orderDaoInstance;

    public static OrderDao getOrderDaoInstance(){
        if(orderDaoInstance == null){
            orderDaoInstance = new OrderDao();
        }
        return orderDaoInstance;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    //Product
    //////////////////////////////////////////////////////////////////////////////////////////////////////
    private static ProductDao productDaoIsntance;
    public static ProductDao getProductDao(){
        if(productDaoIsntance == null){
            productDaoIsntance = new ProductDao();
        }
        return productDaoIsntance;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    //OderDetail
    //////////////////////////////////////////////////////////////////////////////////////////////////////
    private static OrderDetailDao orderDetailDaoInstance;

    public static OrderDetailDao getOrderDetailDaoInstance(){
        if(orderDetailDaoInstance == null){
            orderDetailDaoInstance = new OrderDetailDao();
        }
        return orderDetailDaoInstance;
    }

}
