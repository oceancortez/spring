package org.oxi.integrations.sale.resources.config;

import javax.annotation.PostConstruct;

import org.oxi.integrations.sale.resources.ISaleCategoryResources;
import org.oxi.service.api.config.ServicesConfiguration;
import org.oxi.service.api.store.interfaces.ICategoryServiceRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class ServiceAPIConfiguration extends ServicesConfiguration{
	
	private static Logger logger = LoggerFactory.getLogger(ServiceAPIConfiguration.class);
	
	@Value(value = "${cloud.hybrid.resources.hostname}")
	private String hostname;

	@Value(value = "${cloud.hybrid.resources.socket.timeout.millis}")
	private int socketTimeout;

	@Value(value = "${cloud.hybrid.resources.connection.timeout.millis}")
	private int connectionTimeout;
    
    @PostConstruct
    public void initialize() {
        logger.info("inicializando middleware services configuration. url [{}], connect timeout [{}], request timeout [{}]",
                this.hostname, this.socketTimeout, this.connectionTimeout);
    }
    
//    @Bean
//    public ISaleCategoryResources iSaleCategoryResources(){
//    	return createProxy(ISaleCategoryResources.class);
//    }
	

    @Override
    protected String getServiceUrl() {
        return this.hostname;
    }

    @Override
    protected int getConnectionTimeout() {
        return this.socketTimeout;
    }

    @Override
    protected int getRequestTimeout() {
        return this.connectionTimeout;
    }
}
