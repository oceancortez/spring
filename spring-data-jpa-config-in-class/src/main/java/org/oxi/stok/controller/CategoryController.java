package org.oxi.stok.controller;



import org.apache.log4j.Logger;
import org.oxi.stok.domain.CategoryEntity;
import org.oxi.stok.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("category")
public class CategoryController {

	private Logger logger = Logger.getLogger(this.getClass());

   @Autowired  ICategoryRepository iCategoryRepository;

	@RequestMapping(value = "db/categoryId/{categoryId}", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView findCategoryByRepository(@PathVariable("categoryId") Long categoryId) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			logger.info(
					"\n \n Entrou no método [HelloSpringController.showRestServiceOxiProjectFindByNameAndDescription]={categoryId} = "
							+ categoryId);
			modelAndView.setViewName("hello");

			CategoryEntity search = iCategoryRepository.findOne(categoryId);
			logger.info(
					" \n Entrou no método [HelloSpringController.findCategoryOxiProjectService]={search} =" + search);

			if (search.getCategoryId() != null) {
				modelAndView.addObject("category", search.getCategoryName());
			}
			return modelAndView;

		} catch (Exception e) {

			modelAndView.addObject("category", e.getMessage());
			return modelAndView;
		}

	}
	
	
	@RequestMapping(value = "get", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView getTest() {
		ModelAndView modelAndView = new ModelAndView();
		try {
			logger.info(
					"\n \n Entrou no método [CategoryController.getTest()]");
			modelAndView.setViewName("hello");

			modelAndView.addObject("category", "teste");
					return modelAndView;

		} catch (Exception e) {

			modelAndView.addObject("category", e.getMessage());
			return modelAndView;
		}

	}

	}
