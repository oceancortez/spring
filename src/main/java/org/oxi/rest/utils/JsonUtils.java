package org.oxi.rest.utils;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

import com.fasterxml.jackson.core.JsonParseException;
import com.google.gson.Gson;
import com.google.gson.stream.MalformedJsonException;

public abstract class JsonUtils {

    private static ObjectMapper mapper = new ObjectMapper();     
    private static Gson gson = new Gson();
    

    public static <T extends Object> T readValue(String value, Class<T> clazz) throws IOException, JsonParseException, MalformedJsonException {
        return mapper.readValue(value, clazz);
    }

    public static String writeValue(Object value) throws IOException, JsonParseException, MalformedJsonException {
        return mapper.writeValueAsString(value);
    }

    
    public static <T extends Object> T readValueFromStringGson(String value, Class<T> clazz) throws JsonParseException, MalformedJsonException{    		
    	
    		return gson.fromJson(value, clazz);
    	
    }
}
