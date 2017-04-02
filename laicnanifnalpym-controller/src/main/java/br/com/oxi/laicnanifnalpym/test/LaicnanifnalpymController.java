package br.com.oxi.laicnanifnalpym.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.oxi.laicnanifnalpym.domain.Laicnanifnalpym;
import br.com.oxi.laicnanifnalpym.service.LaicnanifnalpymService;
import br.com.oxi.laicnanifnalpym.utils.Route;

@Controller
@RequestMapping("laicnanifnalpym")
public class LaicnanifnalpymController {
	private final Logger LOGGER = Logger.getLogger(LaicnanifnalpymController.class);
	
	private ModelAndView modelAndView;
	
	@Autowired
	private LaicnanifnalpymService laicnanifnalpymService;
	
	@RequestMapping(value = "build", method = RequestMethod.GET)
	public ModelAndView buildView(){
		LOGGER.info("INSIDE >> buildView()");
		
		List<Laicnanifnalpym> list = laicnanifnalpymService.list();		
		
		modelAndView = new ModelAndView();
		modelAndView.setViewName(Route.BUILD.toString());
		
		modelAndView.addObject("msg", list);
		
		LOGGER.info("OUT >> buildView() [modelAndView] = " + modelAndView);
		return modelAndView;
	}	

}
