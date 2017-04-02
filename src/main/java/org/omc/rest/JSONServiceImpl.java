package org.omc.rest;

import java.io.IOException;
import java.util.List;

import javax.inject.Named;
import javax.ws.rs.core.Response;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.log4j.Logger;
import org.omc.factory.HttpClientFactory;
import org.omc.model.CategoryEntity;
import org.omc.model.repositories.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Named
public class JSONServiceImpl implements JSONService {

	@Autowired
	HttpClientFactory httpClientFactory;
	private static Gson GSON = new GsonBuilder().create();
	private static final Logger LOG = Logger.getLogger(JSONServiceImpl.class);	
	
	private ICategoryRepository categoryRepository;
	
	
	@Autowired
	public JSONServiceImpl(@Qualifier("ICategoryRepository") ICategoryRepository categoryRepository) {		
		this.categoryRepository = categoryRepository;
	}



	@Override
	public Response getCategoryInJSON() {
			
		LOG.debug("Init - getCategoryInJSON");
		List<CategoryEntity> listCategory = categoryRepository.findAll();
		String json = GSON.toJson(listCategory);
		LOG.debug("END - getCategoryInJSON = " + json);
		return Response.status(200).entity(json).build();
			
		}

	@Override
	public Response listCategoryInJSON() {
		LOG.debug("Init - listCategoryInJSON");
		List<CategoryEntity> listCategory = categoryRepository.findAll();
		String json = GSON.toJson(listCategory);
		LOG.debug("END - listCategoryInJSON = " + json);
		return Response.status(200).entity(json).build();
	}


	private CloseableHttpResponse sendPost(List<CategoryEntity> listCategory){
		String json = GSON.toJson(listCategory);
		HttpPost httpPost = new HttpPost("http://localhost:8050/omc-jsf-spring-jpa-h4-p/rest/category/list");
		httpPost.setHeader("accept", "application/json");
		StringEntity stringEntity = new StringEntity(json, "UTF-8");
		stringEntity.setContentType("application/json");

		CloseableHttpClient client = httpClientFactory.createHttpClient();
		try {
			client.execute(httpPost);
		} catch (IOException e) {
			LOG.error("sendPost: Erro ao enviar categoryEntity" + e.getMessage() + ">");
		}
		return null;
	}


	@Override
	public Response listCatecoryMock() {
		LOG.debug("Init - listCatecoryMock");
		CategoryEntity categoryEntity = new CategoryEntity();
		categoryEntity.setCategoryName("categoria teste");
		categoryEntity.setDescription("apenas um teste");
		categoryEntity.setId(1L);
		
		String json = GSON.toJson(categoryEntity);
		LOG.debug("END - listCatecoryMock = " + json);
		return Response.status(200).entity(json).build();
		
	}
}
	
	
	


