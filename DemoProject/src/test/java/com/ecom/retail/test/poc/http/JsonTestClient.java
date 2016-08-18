package com.ecom.retail.test.poc.http;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.HttpClientErrorException;

public class JsonTestClient{
	private static final Logger log = LoggerFactory.getLogger(JsonTestClient.class);


	private CloseableHttpClient httpClient = null;
	private HttpGet httpGet  = null;
	
	@Autowired
	private HttpClientTestDetails httpClientTestDetails;
	

	public CloseableHttpClient getHttpClient() {
		return httpClient;
	}

	public void setHttpClient(CloseableHttpClient httpClient) {
		this.httpClient = httpClient;
	}

	public HttpGet getHttpGet() {
		return httpGet;
	}

	public void setHttpGet(HttpGet httpGet) {
		this.httpGet = httpGet;
	}

	public void initialize() throws Exception {
		httpClient  = httpClientTestDetails.getHttpClientInstance();
		httpGet = httpClientTestDetails.getHttpGetInstance();
	}

	public HttpResponse processGet(String urlString) {
		HttpResponse httpResponse = null;
		try {
			httpClientTestDetails.setGetUrl(urlString);
			httpClientTestDetails.setJsonHeader("accept", "application/json");
			 httpResponse =httpClient.execute(httpGet);		
		}
		catch (HttpClientErrorException e) {
			log.info("Error in connection:::" + e.getStackTrace());
		}
		catch (HttpResponseException e) {
			log.info("Error in connection:::" + e.getStackTrace());
		}
		catch (Throwable t) {
			log.info("Error in connection:::" + t.getStackTrace());
		}
		return httpResponse;

	}

	public void Close() throws Exception {
		httpClient  = null;
		httpGet = null;
	}

	
}
