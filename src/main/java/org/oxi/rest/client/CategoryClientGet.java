package org.oxi.rest.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.oxi.domain.CategoryResponse;
import org.oxi.rest.utils.JsonUtils;

public class CategoryClientGet {

	public static void main(String[] args) {

		try {
			
			URL url = new URL("http://localhost:8080/service/category/findOne/10");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setDoOutput(true);
			conn.connect();

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}			
			
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			
			String output;
			System.out.println("Output from Server .... \n");
			
			while ((output = br.readLine()) != null) {
				
				System.out.println("output string = " + output);
				final CategoryResponse categoryResponse = JsonUtils.readValueFromStringGson(output, CategoryResponse.class);
				System.out.println("output categoryEntity = " + categoryResponse);				
			}
			
			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();

		}

	}	
	
	
}