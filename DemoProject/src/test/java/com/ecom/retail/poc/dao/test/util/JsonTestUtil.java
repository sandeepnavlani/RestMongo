package com.ecom.retail.poc.dao.test.util;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Component;

import com.ecom.retail.poc.exception.ProductDetailException;
import com.ecom.retail.poc.valueobject.ProductDetails;
import com.ecom.retail.poc.valueobject.ProductPrice;
import com.ecom.retail.poc.valueobject.ProductResponse;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonParser.Feature;
@Component
public class JsonTestUtil {
	
	private static ObjectMapper mapper = new ObjectMapper();
	
	static{
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(Feature.ALLOW_UNQUOTED_CONTROL_CHARS, false);
		mapper.configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES,true);
		mapper.configure(Feature.ALLOW_NON_NUMERIC_NUMBERS,true);
		
	}
	public static ObjectMapper getMapperInstance(){
		return mapper;
	}
	
	public static ProductResponse fromJsonToProductResponseObject(InputStream inputStream) throws IOException, ProductDetailException{
		ProductResponse product = null;
		try {
		 product =	mapper.readValue(inputStream, ProductResponse.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			throw new ProductDetailException("Parsing exception in JSON :::" + e.getMessage());
		}catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			throw new ProductDetailException("Mapping exception in JSON :::" + e.getMessage());
		}catch (IOException e) {
			// TODO Auto-generated catch block
			throw new ProductDetailException("Exception During  fromJsonToObject() method  :::" + e.getMessage());
		}
		return product;
	}
	
	public static ProductDetails fromJsonToProductObject(String inputStream) throws IOException, ProductDetailException{
		ProductDetails product = null;
		try {
		 product =	mapper.readValue(inputStream, ProductDetails.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			throw new ProductDetailException("Parsing exception in JSON :::" + e.getMessage());
		}catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			throw new ProductDetailException("Mapping exception in JSON :::" + e.getMessage());
		}catch (IOException e) {
			// TODO Auto-generated catch block
			throw new ProductDetailException("Exception During  fromJsonToObject() method  :::" + e.getMessage());
		}
		return product;
	}
	
	public static String fromObjectToJson(Object  object) throws IOException, ProductDetailException{
		String  jsonString = null;
		try {
			jsonString =	mapper.writeValueAsString(object);
		} catch (JsonParseException e) {
			throw new ProductDetailException("Parsing exception in JSON :::" + e.getMessage());
		}catch (JsonMappingException e) {
			throw new ProductDetailException("Mapping exception in JSON :::" + e.getMessage());
		}catch (IOException e) {
			throw new ProductDetailException("Exception During  fromObjectToJson() method in JSON :::" + e.getMessage());
		}
		return jsonString;
	}
	
	public static ProductPrice toProductPrice(String jsonString) throws IOException{
		ProductPrice  price = null;
		try {
			price =	mapper.readValue(jsonString, ProductPrice.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return price;
	}
	
	public static String fromPrice(ProductPrice  price) throws IOException{
		String  jsonString = null;
		try {
			jsonString =	mapper.writeValueAsString(price);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonString;
	}
}
