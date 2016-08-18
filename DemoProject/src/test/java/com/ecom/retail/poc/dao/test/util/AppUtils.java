package com.ecom.retail.poc.dao.test.util;

import com.ecom.retail.poc.util.JsonUtil;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

public class AppUtils {

	
	 public static DBObject toDBObject(Object pojo){
		 String json = null;
		 try{
		    json =JsonUtil.fromObjectToJson(pojo);	   
		    
		  }catch(Exception e){
			 e.printStackTrace(); 
		  }
		 return (DBObject) JSON.parse(json);
}}
