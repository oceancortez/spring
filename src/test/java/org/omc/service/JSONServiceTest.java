package org.omc.service;

import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.omc.AbstractDataBaseTest;
import org.omc.rest.JSONServiceImpl;

import javax.inject.Inject;
import javax.ws.rs.core.Response;


@SuppressWarnings("deprecation")
public class JSONServiceTest extends AbstractDataBaseTest {
    private static final Logger LOGGER = Logger.getLogger(JSONServiceTest.class);
    
    
    @Inject
    private JSONServiceImpl jSONServiceImpl;

    @Test
    public void listAllCategoryFromJSONServiceTest(){
        Response list = jSONServiceImpl.getCategoryInJSON();
        Assert.assertTrue(list.getStatus() == 200);
        LOGGER.info(list);
    }

}
