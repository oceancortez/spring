package org.oxi.sale;

import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.oxi.config.ApplicationTest;
import org.oxi.integrations.sale.resources.ISaleCategoryResources;
import org.oxi.utils.entities.sale.CategoryEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationTest.class)
@WebAppConfiguration
public class CategorySaleResourceTest {
		
		@Inject
		ISaleCategoryResources iSaleCategoryResources;
		
		private MockMvc mockMvc;
		
		//private HttpMessageConverter mappingJackson2HttpMessageConverter;
		
	
	     @Test
	     public void getListUser(){
	        List<CategoryEntity> listResponse = iSaleCategoryResources.listCategories();
	        Assert.assertTrue(listResponse.size() > 0);
	    }

}
