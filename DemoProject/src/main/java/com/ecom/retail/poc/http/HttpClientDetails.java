package com.ecom.retail.poc.http;

import java.net.URI;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class HttpClientDetails {

    private static CloseableHttpClient httpClient = null;
    private static HttpGet httpGet = null;

    private HttpClientDetails() {}
    
    /*  COMMENTS
     *  it will initialise HttpCLient object .*/
    
    public static CloseableHttpClient getHttpClientInstance() {
        if (httpClient == null) {
            httpClient = HttpClientBuilder.create().build();
        }

        return httpClient;

    }

    /*  COMMENTS
     *  it will initialise HTTP GET object .*/
    
    public static HttpGet getHttpGetInstance() {
        if (httpGet == null) {
            httpGet = new HttpGet();
        }
        return httpGet;

    }
    
    /*  COMMENTS
     *  it will create and set URI in HTTP GET method.*/
    
    public static void setGetUrl(String url) {
        httpGet.setURI(URI.create(url));
    }
    
    /*  COMMENTS
     *  it will set header  in HTTP GET method.*/

    public static void setJsonHeader(String name, String value) {
        httpGet.addHeader(name, value);
    }
}