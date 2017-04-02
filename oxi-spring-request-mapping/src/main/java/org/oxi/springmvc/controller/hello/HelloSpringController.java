package org.oxi.springmvc.controller.hello;



import org.apache.log4j.Logger;
import org.oxi.resteasy.domain.CategoryResponse;
import org.oxi.resteasy.mains.Product;
import org.oxi.resteasy.resources.ICategoryOxiProjectResources;
import org.oxi.resteasy.resources.IMkyoungResources;
import org.oxi.resteasy.services.ICategoryOxiProjectService;
import org.oxi.stok.domain.CategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloSpringController {

	private Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private ICategoryOxiProjectResources iCategoryOxiProjectResources;

	@Autowired
	private IMkyoungResources iMkyoungResources;

    @Autowired
	public ICategoryOxiProjectService iCategoryOxiProjectService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

		model.addAttribute("message", "Spring 3 MVC Hello World");
		return "hello";
	}

	@RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
	public ModelAndView hello(@PathVariable("name") String name) {

		ModelAndView model = new ModelAndView();
		model.setViewName("hello");
		model.addObject("msg", name);

		return model;

	}

	@RequestMapping(value = "/rest/{showRest}", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView showRest(@PathVariable("showRest") String showRest) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("hello");
		modelAndView.addObject("showRest", showRest);

		return modelAndView;
	}

	// @RequestMapping(value = "/rest/service/correios", method =
	// RequestMethod.GET)
	// @ResponseBody
	// public ModelAndView showRestServiceCorreios(){
	// ModelAndView modelAndView = new ModelAndView();
	//
	// EnderecoCEP search = searchCorreirosServicescs.search("03227040");
	//
	// modelAndView.setViewName("hello");
	// modelAndView.addObject("showRest", search.toString());
	//
	// return modelAndView;
	// }

	@RequestMapping(value = "/rest/service/mkyoung", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView showRestServiceMkyoung() {
		ModelAndView modelAndView = new ModelAndView();
		try {
			logger.info("Entrou no método [HelloSpringController.showRestServiceMkyoung])");
			modelAndView.setViewName("hello");

			Product search = iMkyoungResources.findMkyoung();
			logger.info("Entrou no método [jsonService.getProductInJSON();] search =" + search.getName());

			if (search != null) {
				modelAndView.addObject("showRest", search.getName());
			}
			return modelAndView;

		} catch (Exception e) {

			modelAndView.addObject("showRest", e.getMessage());
			return modelAndView;
		}

	}

	@RequestMapping(value = "/rest/service/oxiproject/{categoryID}", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView showRestServiceOxiProject(@PathVariable("categoryID") Long categoryID) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			logger.info(
					"Entrou no método [HelloSpringController.showRestServiceOxiProject]={categoryID} =" + categoryID);
			modelAndView.setViewName("hello");

			CategoryResponse search = iCategoryOxiProjectResources.searchCategoryById(categoryID);
			logger.info("Entrou no método [HelloSpringController.findCategoryOxiProjectService]={search} =" + search);

			if (search.getCategoryEntity().getCategoryName() != null) {

				modelAndView.addObject("showRest", search.getCategoryEntity().getCategoryName()
						.concat(" / " + search.getCategoryEntity().getDescription()));
			}
			return modelAndView;

		} catch (Exception e) {

			modelAndView.addObject("showRest", e.getMessage());
			return modelAndView;
		}

	}

	@RequestMapping(value = "/rest/service/oxiproject/name/{name}/description/{description}", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView showRestServiceOxiProjectFindByNameAndDescription(@PathVariable("name") String name,
			@PathVariable("description") String description) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			logger.info(
					"\n \n Entrou no método [HelloSpringController.showRestServiceOxiProjectFindByNameAndDescription]={name}"
							+ name + " / {description} =" + description + "\n");
			modelAndView.setViewName("hello");

			CategoryResponse search = iCategoryOxiProjectResources.findByNameAndDescription(name, description);
			logger.info(
					" \n Entrou no método [HelloSpringController.findCategoryOxiProjectService]={search} =" + search);

			if (search.getCategoryEntity().getCategoryId() != null) {
				modelAndView.addObject("showRest", search.getCategoryEntity().getCategoryName());
			}
			return modelAndView;

		} catch (Exception e) {

			modelAndView.addObject("showRest", e.getMessage());
			return modelAndView;
		}

	}

	@RequestMapping(value = "/rest/service/save/categoryId/oxiproject/{categoryID}", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView saveCategoryByRestServiceOxiProject(@PathVariable("categoryID") Long categoryID) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			logger.info("Entrou no método [HelloSpringController.saveCategoryByRestServiceOxiProject]={categoryID} ="
					+ categoryID);
			modelAndView.setViewName("hello");

			CategoryEntity categoryEntity = iCategoryOxiProjectService.saveCategoryByResource(categoryID);
			logger.info("Entrou no método boolean [categoryOxiProjectService.saveService]={categoryID} ="
					+ categoryEntity.getCategoryName());

			if (categoryEntity.getCategoryName() != null) {

				modelAndView.addObject("showRest",
						categoryEntity.getCategoryName().concat(" / " + categoryEntity.getDescription()));
				return modelAndView;
			} else {
				modelAndView.addObject("showRest", "Não foi possível realizar a operação");
				return modelAndView;
			}
		} catch (Exception e) {

			modelAndView.addObject("showRest", e.getMessage());
			return modelAndView;
		}

	}
}
