package org.omc.factory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;

public class ApacheHttpClientGet {
	
	private static final Logger LOG = Logger.getLogger(ApacheHttpClientGet.class);
	
	//http://localhost:8050/omc-jsf-spring-jpa-h4-p/rest/json/category/get
	public static void main(String[] args) throws IllegalStateException, IOException {
		
		DefaultHttpClient httpClient = new DefaultHttpClient();
		LOG.debug("INIT - ApacheHttpClientGet");
		HttpGet getRequest = new HttpGet("http://localhost:8050/omc-jsf-spring-jpa-h4-p/rest/json/category/get");
		getRequest.addHeader("accept", "application/json");
		
		HttpResponse response = null;
		try {
			response = httpClient.execute(getRequest);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			LOG.debug("ERROR  response = httpClient.execute(getRequest); " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			LOG.debug("ERROR  response = httpClient.execute(getRequest); " + e.getMessage());
			e.printStackTrace();
		}
		
		if(response.getStatusLine().getStatusCode() != 200){
			throw new RuntimeException("Failed : HTTP error code : "
			   + response.getStatusLine().getStatusCode());
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
		
		
		String output;
		System.out.println("Output from Server .... \n");
		while((output = br.readLine()) != null){
			System.out.println(output);	
		}
		
		LOG.debug("END - httpClient.getConnectionManager().shutdown();");
		
		httpClient.getConnectionManager().shutdown();
			
	}

}
