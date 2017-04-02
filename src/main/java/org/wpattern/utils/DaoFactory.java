package org.wpattern.utils;

import org.springframework.beans.factory.annotation.Autowired;

import org.wpattern.service.ModelServiceConstants;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by ocean on 22/08/2015.
 */

public final class DaoFactory {

    private static final String PERSISTENCE_UNIT_NAME = ModelServiceConstants.PERSISTENCE_UNIT_NAME;

    @Autowired
    private static EntityManagerFactory entityManagerFactoryInstance;


    @PostConstruct
    public void init() {
        entityManagerFactoryInstance();
    }

    public static EntityManagerFactory entityManagerFactoryInstance() {
        if (entityManagerFactoryInstance == null) {
            entityManagerFactoryInstance = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return entityManagerFactoryInstance;
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////
    //CATEGORY
    //////////////////////////////////////////////////////////////////////////////////////////////////////

   /* private static CategoryDao categoryDaoInstance;

    public static CategoryDao getCategoryDaoInstance() {
        if (categoryDaoInstance == null) {
            categoryDaoInstance = new CategoryDao();
        }

        return categoryDaoInstance;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    //ORDER
    //////////////////////////////////////////////////////////////////////////////////////////////////////
    private static OrderDao orderDaoInstance;

    public static OrderDao getOrderDaoInstance() {
        if (orderDaoInstance == null) {
            orderDaoInstance = new OrderDao();
        }
        return orderDaoInstance;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    //Product
    //////////////////////////////////////////////////////////////////////////////////////////////////////
    private static ProductDao productDaoIsntance;

    public static ProductDao getProductDao() {
        if (productDaoIsntance == null) {
            productDaoIsntance = new ProductDao();
        }
        return productDaoIsntance;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    //OderDetail
    //////////////////////////////////////////////////////////////////////////////////////////////////////
    private static OrderDetailDao orderDetailDaoInstance;

    public static OrderDetailDao getOrderDetailDaoInstance() {
        if (orderDetailDaoInstance == null) {
            orderDetailDaoInstance = new OrderDetailDao();
        }
        return orderDetailDaoInstance;
    }*/

}
