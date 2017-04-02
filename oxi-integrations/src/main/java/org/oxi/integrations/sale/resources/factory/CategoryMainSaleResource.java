package org.oxi.integrations.sale.resources.factory;

import java.io.IOException;

import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;


public abstract class CategoryMainSaleResource {
	
	private static Logger logger = Logger.getLogger(CategoryMainSaleResource.class);

	
	protected static final String URI_SERVICE = "http://localhost:8080/service/category";	

	protected static HttpClientFactory httpClientFactory;

	public CategoryMainSaleResource() {
	}

	public abstract void setHttpClientFactory(HttpClientFactory httpClientFactory);

	public static String searchSale(String uriService) {
		validationInitializeHttpClient();
		HttpGet httpGet = new HttpGet(uriService);	
		httpGet.addHeader("accept", "application/json");
		//CloseableHttpClient httpclient = httpClientFactory.createHttpClient();
		@SuppressWarnings("deprecation")
		DefaultHttpClient httpClient = new DefaultHttpClient();
		CloseableHttpResponse resp = null;
		try {
			resp = httpClient.execute(httpGet);
			
		} catch (IOException e) {
			logger.error(String.format("Problems accessing to service manager from uri: %s", uriService.toString()));
//			throw new ConnectionException(
//					String.format("Problems accessing to service manager from uri: %s", uri.toString()), e.getCause());
		}
		if (resp.getStatusLine().getStatusCode() == 200) {
			try {
				return EntityUtils.toString(resp.getEntity());
			} catch (ParseException | IOException e) {
				logger.error(String.format("Problems parse reponse to service manager from uri: %s", uriService.toString()));
//				throw new IntegrationSm940RuntimeException(
//						String.format("Problems parse reponse to service manager from uri: %s", uri.toString()));
			}
		}
		logger.error(String.format("Problems accessing to service manager:%s - Status Code: s%",
				uriService.toString(), resp.getStatusLine()));
//		throw new ConnectionException(String.format("Problems accessing to service manager:%s - Status Code: s%",
//				uri.toString(), resp.getStatusLine()));
		return resp.toString();
	}
	
	public static void main (String [] args){
		String retorno = searchSale(URI_SERVICE);
		logger.info("retorno = " + retorno);
	}
	
	

	private static void validationInitializeHttpClient() {
		if (httpClientFactory == null) {
			logger.error("he HttpClientFactory not initializate");
//			throw new HttpClientFactoryException("the HttpClientFactory not initializate");
		}
	}
}
