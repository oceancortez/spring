package org.oxi.portal.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "org.oxi")
public class MyWebAppInitializerConfig {

//	    @Override
//	    public void onStartup(ServletContext container) {
//	      // Create the 'root' Spring application context
//	      AnnotationConfigWebApplicationContext rootContext =
//	        new AnnotationConfigWebApplicationContext();
//	      rootContext.register(AppConfig.class);
//
//	      // Manage the lifecycle of the root application context
//	      container.addListener(new ContextLoaderListener(rootContext));
//
//	      // Create the dispatcher servlet's Spring application context
//	      AnnotationConfigWebApplicationContext dispatcherContext =
//	        new AnnotationConfigWebApplicationContext();
//	      dispatcherContext.register(DispatcherConfig.class);
//
//	      // Register and map the dispatcher servlet
//	      ServletRegistration.Dynamic dispatcher =
//	        container.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
//	      dispatcher.setLoadOnStartup(1);
//	      dispatcher.addMapping("/");
//	    }
//

}
