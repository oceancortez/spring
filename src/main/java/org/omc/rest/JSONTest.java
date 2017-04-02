package org.omc.rest;

import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.omc.model.CategoryEntity;
import org.omc.model.repositories.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by ocortez on 11/26/2015.
 */

//@Path("/rest/category/")
public class JSONTest {


    private static Gson GSON = new GsonBuilder().create();
    private static final Logger LOG = Logger.getLogger(JSONTest.class);

    private ICategoryRepository categoryRepository;


    @Autowired
    public JSONTest(@Qualifier("ICategoryRepository") ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @POST
    @Path("list")
    @Produces("application/json")
    public Response listCategoryInJSON() {
        List<CategoryEntity> listCategory = categoryRepository.findAll();
        String json = listCategory.toString();
        return Response.status(200).entity(json).build();
    }

    @POST
    @Path("list/post")
    @Produces("application/json")
    public Response getCategoryInJSON() {
        List<CategoryEntity> listCategory = categoryRepository.findAll();
        String json = listCategory.toString();
        return Response.status(200).entity(json).build();
    }
}
