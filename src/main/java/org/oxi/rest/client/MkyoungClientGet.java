package org.oxi.rest.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.oxi.domain.Product;
import org.oxi.rest.utils.JsonUtils;

public class MkyoungClientGet {

	public static void main(String[] args) {

		try {

			URL url = new URL(
					"http://localhost:8087/resteasyspring/rest/json/product/get");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				
				System.out.println("output = " + output);
				Product product = JsonUtils.readValueFromStringGson(output, Product.class); 
				System.out.println("output product = " + product);
			}
			
			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
			
		}

	}

}