package org.oxi.portal.sale;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.oxi.service.api.store.interfaces.ICategoryServiceRest;
import org.oxi.utils.entities.sale.CategoryEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("saleCategorySpring3")
public class SaleCategoryrControllerSpring3 {
	
	private static final Logger LOGGER = Logger.getLogger(SaleCategoryrControllerSpring3.class);
	
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
	
	   
    @RequestMapping(value = "/hello", method = RequestMethod.GET)  
	public String printWelcome(ModelMap model) {  
        model.addAttribute("message", "Hello! This is Spring MVC Web Controller.");  
        return "output";  
    
	}

}
