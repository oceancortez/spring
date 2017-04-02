package org.oxi.portal.sale;

import javax.inject.Inject;
import javax.ws.rs.Path;

import org.apache.log4j.Logger;
import org.oxi.service.api.store.interfaces.ICategoryService;
import org.oxi.utils.entities.sale.CategoryEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Path("saleCategory")
public class SaleCategoryController {
	
	private static final Logger LOGGER = Logger.getLogger(SaleCategoryController.class);
	
	CategoryEntity categoryEntity = new CategoryEntity();
	
	@Inject
	public ICategoryService iCategoryService;
	
	
	@RequestMapping(value = { "/categoryId/{id}" }, method = { RequestMethod.GET })
	public @ResponseBody CategoryEntity getCategory(@PathVariable Long idCategory){
		LOGGER.info("Entrou no método SaleCategoryController.getCategory");
		categoryEntity = iCategoryService.findOne(idCategory);
		LOGGER.info("Objeto de retorno do método SaleCategoryController.getCategory = " + categoryEntity);
		return  categoryEntity;
	}

}
