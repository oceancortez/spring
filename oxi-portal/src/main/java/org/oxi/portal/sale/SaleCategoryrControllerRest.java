package org.oxi.portal.sale;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.oxi.service.api.store.interfaces.ICategoryServiceRest;
import org.oxi.utils.entities.sale.CategoryEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("saleCategoryRest")
public class SaleCategoryrControllerRest {
	
	private static final Logger LOGGER = Logger.getLogger(SaleCategoryrControllerRest.class);
	
	CategoryEntity categoryEntity = new CategoryEntity();
	
	@Resource
	public ICategoryServiceRest iCategoryService;
	
	
	@RequestMapping(value = { "/categoryId/{id}" }, method = { RequestMethod.GET })
	public @ResponseBody CategoryEntity getCategory(@PathVariable Long idCategory){
		LOGGER.info("Entrou no método SaleCategoryController.getCategory");
		categoryEntity = iCategoryService.findOne(idCategory);
		LOGGER.info("Objeto de retorno do método SaleCategoryController.getCategory = " + categoryEntity);
		return  categoryEntity;
	}

}
