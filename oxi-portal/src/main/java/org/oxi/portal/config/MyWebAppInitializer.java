package org.oxi.portal.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.apache.log4j.Logger;
import org.oxi.portal.sale.SaleCategoryrControllerRest;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


public class MyWebAppInitializer implements WebApplicationInitializer {
	private static final Logger LOGGER = Logger.getLogger(MyWebAppInitializer.class);
	 public void onStartup(ServletContext container) throws ServletException {
		 LOGGER.info("Entrou no método [MyWebAppInitializer.onStartup] =[id] ");
		 
	        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
	        ctx.register(MyWebAppInitializerConfig.class);
	        ctx.setServletContext(container);
	        LOGGER.info("Dentro do método [MyWebAppInitializer.onStartup] =[crirou o container]  = " + container);
	 
	        ServletRegistration.Dynamic servlet = container.addServlet(
	                "dispatcher", new DispatcherServlet(ctx));
	 
	        servlet.setLoadOnStartup(1);
	        servlet.addMapping("/");
	    }

}
