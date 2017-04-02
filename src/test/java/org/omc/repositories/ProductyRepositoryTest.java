package org.omc.repositories;


import org.apache.log4j.Logger;
import org.junit.Test;
import org.omc.AbstractDataBaseTest;
import org.omc.model.ProductyEntity;
import org.omc.model.repositories.IProductyRepository;

import javax.inject.Inject;
import java.util.List;

public class ProductyRepositoryTest extends AbstractDataBaseTest {

    private static final Logger LOGGER = Logger.getLogger(ProductyRepositoryTest.class);

    @Inject
    private IProductyRepository productyRepository;

    @Test
    public void findAllProductyTest() {
        List<ProductyEntity> list = productyRepository.findAll();

        LOGGER.info(list);


    }
}
