package org.oxi.resteasy.config;

import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.jboss.resteasy.client.core.ClientErrorInterceptor;
import org.jboss.resteasy.plugins.providers.RegisterBuiltin;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.jboss.resteasy.spi.interception.ClientExecutionInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@Lazy
public class ClientInterceptorsConfiguration {

	private Logger logger = LoggerFactory.getLogger(ClientInterceptorsConfiguration.class);
    static {
        RegisterBuiltin.register(ResteasyProviderFactory.getInstance());
    }

    @Resource
    private Set<ClientErrorInterceptor> errorInterceptors;

    @Resource
    private Set<ClientExecutionInterceptor> executionInterceptors;

    /**
     * Registra os interceptors do Resteasy
     */
    @PostConstruct
    public void registerInterceptors() {
        if (errorInterceptors != null) {
            logger.info("registrando [{}] resteasy error interceptors {}", errorInterceptors.size(), errorInterceptors);

            for (ClientErrorInterceptor interceptor : errorInterceptors) {
                ResteasyProviderFactory.getInstance().getClientErrorInterceptors().add(interceptor);
            }
        }
        if (executionInterceptors != null) {
            logger.info("registrando [{}] resteasy execution interceptors {}", executionInterceptors.size(), executionInterceptors);

            for (ClientExecutionInterceptor interceptor : executionInterceptors) {
                ResteasyProviderFactory.getInstance().getClientExecutionInterceptorRegistry().register(interceptor);
            }
        }
    }
}
