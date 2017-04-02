//
//
//
//package org.oxi.resteasy.mains;
//
//import javax.annotation.PostConstruct;
//
//import org.oxi.resteasy.conf.ServicesConfiguration;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
//
//@Configuration
////@DependsOn(value = { "clientInterceptorsConfiguration" })
//@ComponentScan("org.oxi")
//@PropertySource(value = {"classpath:correios.properties"})
//public class CorreiosServicesConfiguration extends ServicesConfiguration {
//	
//	@Bean
//	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
//	    return new PropertySourcesPlaceholderConfigurer();
//	}
//    @Value("${correios.server.url}")
//    private String correiosUrl;
//
//    @Value("${correios.connect.timeout}")
//    private int correiosConnectTimeout;
//
//    @Value("${correios.request.timeout}")
//    private int correiosRequestTimeout;
//
//    @PostConstruct
//    public void initialize() {
//    	System.out.println(String.format("inicializando correios services configuration. url [%s], connect timeout [%s], request timeout [%s]",
//                this.correiosUrl, this.correiosConnectTimeout, this.correiosRequestTimeout));
//    }
//
//    /**
//     * Define o bean de serviços de consulta aos correios.
//     *
//     * @return
//     * @returstomerServices O bean de serviços de clientes.
//     */
//    @Bean
//    public SearchCorreirosServices searchCorreirosServices() {
//        return this.createProxy(SearchCorreirosServices.class);
//    }
//    @Override
//    protected String getServiceUrl() {
//        return this.correiosUrl;
//    }
//
//    @Override
//    protected int getConnectionTimeout() {
//        return this.correiosConnectTimeout;
//    }
//
//    @Override
//    protected int getRequestTimeout() {
//        return this.correiosRequestTimeout;
//    }
//
//
//}
