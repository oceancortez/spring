package org.oxi.integrations.sale.resources.factory;

import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class HttpClientFactory {

	private static int HTTP_CLIENT_CONFIG_TIMEOUT = 12000;
	private static String PROTOCOL;
	private static String HOST_NAME;
	private static int PORT;
	private static HttpClientFactory instance;
	
	public static final String APPLICATION_JSON_UTF8 = "application/json; charset=utf-8";

	public static HttpClientFactory getInstance() {
		if (instance == null)
			instance = new HttpClientFactory();

		return instance;
	}
	
	private  HttpClientFactory() {
		
		HTTP_CLIENT_CONFIG_TIMEOUT = Integer.parseInt("12000");
		PROTOCOL = "http";
		HOST_NAME = "localhost";
		PORT = Integer.parseInt("8080");
				
	}

	public CloseableHttpClient createHttpClient() {
		RequestConfig.Builder requestBuilder = RequestConfig.custom();
		requestBuilder = requestBuilder.setConnectTimeout(HTTP_CLIENT_CONFIG_TIMEOUT);
		requestBuilder = requestBuilder.setSocketTimeout(HTTP_CLIENT_CONFIG_TIMEOUT);
		requestBuilder = requestBuilder.setConnectionRequestTimeout(HTTP_CLIENT_CONFIG_TIMEOUT);
		return HttpClientBuilder.create().build();
	}


	public HttpHost getTarget() {
		return new HttpHost(HOST_NAME, PORT, PROTOCOL);
	}	

}
