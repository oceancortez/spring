package org.oxi.resteasy.config;

import java.lang.reflect.Method;

import javax.annotation.PostConstruct;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.httpclient.HostConfiguration;
import org.apache.commons.httpclient.HttpConnectionManager;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.jboss.resteasy.client.ClientExecutor;
import org.jboss.resteasy.client.ClientResponseFailure;
import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.client.core.executors.ApacheHttpClientExecutor;
import org.oxi.resteasy.exception.ExceptionTranslatorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ServicesConfiguration {

	private static Logger logger = LoggerFactory.getLogger(ServicesConfiguration.class);
	
    private final ClientExecutor executor = new ApacheHttpClientExecutor();

    private MultiThreadedHttpConnectionManager httpConnectionManager = null;

    @PostConstruct
    private void init() {
        HttpConnectionManager httpConnectionManager = this.createConnectionManager();
        ((ApacheHttpClientExecutor) executor).getHttpClient().setHttpConnectionManager(httpConnectionManager);
    }

    @SuppressWarnings("unchecked")
    public <T> T createProxy(Class<T> clazz) {

        T serviceProxy = ProxyFactory.create(clazz, getServiceUrl(), executor);

        org.springframework.aop.framework.ProxyFactory factory = new org.springframework.aop.framework.ProxyFactory(serviceProxy);

        factory.addInterface(clazz);

        factory.addAdvice(new MethodInterceptor() {
            @Override
            public Object invoke(MethodInvocation invocation) throws Throwable {
                try {
                    return invocation.proceed();
                } catch (ExceptionTranslatorException exceptionTranslatorException) {
                    Method method = invocation.getMethod();
                    
                    logger.error("falha ao executar servico metodo [{}.{}], argumentos [{}]. exception [{}]", method.getDeclaringClass()
                            .getSimpleName(), method.getName(), invocation.getArguments(), exceptionTranslatorException);

                    throw exceptionTranslatorException.getCause();
                } catch (Throwable throwable) {
                    String response = "";
                    if (throwable instanceof ClientResponseFailure) {
                        try {
                            response = (String) ((ClientResponseFailure) throwable).getResponse().getEntity(String.class);
                        } catch (Exception ex) {

                        }
                    }
                    Method method = invocation.getMethod();

                    logger.error("falha ao executar servico metodo [{}.{}], argumentos [{}]. exception [{}] , response=[{}]", method
                            .getDeclaringClass().getSimpleName(), method.getName(), invocation.getArguments(), throwable, response);

                    throw throwable;
                } finally {
                    httpConnectionManager.closeIdleConnections(getRequestTimeout() + 1000);
                }
            }
        });

        return (T) factory.getProxy();
    }

    private HttpConnectionManager createConnectionManager() {

        if (httpConnectionManager == null) {
            logger.debug("Configurando httpConnectionManager := {}", httpConnectionManager);
            httpConnectionManager = new MultiThreadedHttpConnectionManager();

            HttpConnectionManagerParams connParam = new HttpConnectionManagerParams();
            connParam.setMaxConnectionsPerHost(HostConfiguration.ANY_HOST_CONFIGURATION, 500);
            connParam.setMaxTotalConnections(1000);
            connParam.setConnectionTimeout(getConnectionTimeout());
            connParam.setSoTimeout(getRequestTimeout());
            connParam.setTcpNoDelay(true);
            httpConnectionManager.setParams(connParam);
        }

        return httpConnectionManager;
    }

    public void shutdown() {
        httpConnectionManager.shutdown();
    }

    /**
     * URL do host do servico
     * 
     * @return
     */
    protected abstract String getServiceUrl();

    /**
     * ConnectionTimeout da conection
     * 
     * @return
     */
    protected abstract int getConnectionTimeout();

    /**
     * RequestTimeout da requisicao
     * 
     * @return
     */
    protected abstract int getRequestTimeout();

}
