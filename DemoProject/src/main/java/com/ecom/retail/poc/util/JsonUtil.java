package com.ecom.retail.poc.util;

import java.io.IOException;
import java.io.InputStream;

import com.ecom.retail.poc.exception.ProductDetailException;
import com.ecom.retail.poc.valueobject.ProductDetails;
import com.ecom.retail.poc.valueobject.ProductPrice;
import com.ecom.retail.poc.valueobject.ProductResponse;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;



public class JsonUtil {

    private static ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(Feature.ALLOW_UNQUOTED_CONTROL_CHARS, false);
        mapper.configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        mapper.configure(Feature.ALLOW_NON_NUMERIC_NUMBERS, true);

    }
    public static ObjectMapper getMapperInstance() {
        return mapper;
    }
    /*  COMMENTS
     *   Converts from inputstream to product response object using object mapper
     *    .*/
    
    public static ProductResponse fromJsonToProductResponseObject(InputStream inputStream) throws IOException, ProductDetailException {
        ProductResponse product = null;
        try {
            product = mapper.readValue(inputStream, ProductResponse.class);
        } catch (JsonParseException e) {          
            throw new ProductDetailException("Parsing exception in JSON :::" + e.getMessage());
        } catch (JsonMappingException e) {          
            throw new ProductDetailException("Mapping exception in JSON :::" + e.getMessage());
        } catch (IOException e) {          
            throw new ProductDetailException("Exception During  fromJsonToProductResponseObject() method  :::" + e.getMessage());
        }
        return product;
    }

    /*  COMMENTS
     *   Converts from String to productdetails object using object mapper
     *   .*/
    public static ProductDetails fromJsonToProductObject(String inputStream) throws IOException, ProductDetailException {
        ProductDetails product = null;
        try {
            product = mapper.readValue(inputStream, ProductDetails.class);
        } catch (JsonParseException e) {          
            throw new ProductDetailException("Parsing exception in JSON :::" + e.getMessage());
        } catch (JsonMappingException e) {          
            throw new ProductDetailException("Mapping exception in JSON :::" + e.getMessage());
        } catch (IOException e) {          
            throw new ProductDetailException("Exception During  fromJsonToProductObject() method  :::" + e.getMessage());
        }
        return product;
    }
    
    /*  COMMENTS
     *   Converts from object to json string object using object mapper
     *    .*/

    public static String fromObjectToJson(Object object) throws IOException, ProductDetailException {
        String jsonString = null;
        try {
            jsonString = mapper.writeValueAsString(object);
        } catch (JsonParseException e) {
            throw new ProductDetailException("Parsing exception in JSON :::" + e.getMessage());
        } catch (JsonMappingException e) {
            throw new ProductDetailException("Mapping exception in JSON :::" + e.getMessage());
        } catch (IOException e) {
            throw new ProductDetailException("Exception During  fromObjectToJson() method in JSON :::" + e.getMessage());
        }
        return jsonString;
    }
    
    
    /*  COMMENTS
     *   Converts from JsonString to productprice object using object mapper
     *    .*/

    public static ProductPrice toProductPrice(String jsonString) throws IOException,ProductDetailException {
        ProductPrice price = null;
        try {
            price = mapper.readValue(jsonString, ProductPrice.class);
        } catch (JsonParseException e) {          
        	throw new ProductDetailException("Parsing exception in JSON :::" + e.getMessage());
        } catch (JsonMappingException e) {          
        	throw new ProductDetailException("Mapping exception in JSON :::" + e.getMessage());
        } catch (IOException e) {          
        	throw new ProductDetailException("Exception During  toProductPrice() method in JSON :::" + e.getMessage());
        }
        return price;
    }

}