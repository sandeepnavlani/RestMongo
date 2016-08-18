package com.ecom.retail.test.poc.http;

import java.net.URI;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class HttpClientTestDetails {

	private  CloseableHttpClient httpClient = null;
	private  HttpGet httpGet = null;
	
	private HttpClientTestDetails(){
		
	}
	public  CloseableHttpClient getHttpClientInstance(){
		return	httpClient = HttpClientBuilder.create().build();		
	}
	
	public  HttpGet getHttpGetInstance(){
			return httpGet = new HttpGet();		
	}
	
	public  void setGetUrl(String url){
		httpGet.setURI(URI.create(url));
	}
	
	public  void setJsonHeader(String name,String value){
		httpGet.addHeader(name, value);
	}
}
