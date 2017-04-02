package org.oxi.resteasy.config;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.oxi.resteasy.resources.ICategoryOxiProjectResources;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan("org.oxi")
@PropertySource(value = {"classpath:consumes.properties"})
public class CategoryOxiProjectServicesConfiguration extends ServicesConfiguration {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
	    return new PropertySourcesPlaceholderConfigurer();
	}
    @Value("${oxiproject.server.url}")
    private String oxiprojectUrl;

    @Value("${oxiproject.connect.timeout}")
    private int oxiprojectConnectTimeout;

    @Value("${oxiproject.request.timeout}")
    private int oxiprojectRequestTimeout;

    @PostConstruct
    public void initialize() {
    	logger.info("inicializando cateroies services configuration. url [%s], connect timeout [%s], request timeout [%s]" +
                this.oxiprojectUrl + this.oxiprojectConnectTimeout + this.oxiprojectRequestTimeout);
    	
    }

    /**
     * 
     *
     * @return
     * @returstomerServices O bean de serviços de clientes.
     */
    @Bean
    public ICategoryOxiProjectResources findCategoryOxiProjectService() {
        return this.createProxy(ICategoryOxiProjectResources.class);
    }
    @Override
    protected String getServiceUrl() {
        return this.oxiprojectUrl;
    }

    @Override
    protected int getConnectionTimeout() {
        return this.oxiprojectConnectTimeout;
    }

    @Override
    protected int getRequestTimeout() {
        return this.oxiprojectRequestTimeout;
    }


}
