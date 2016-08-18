package com.ecom.retail.poc.http;

import java.io.Serializable;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

@Component
public class JsonClient implements Serializable, InitializingBean {
    private static final Logger log = LoggerFactory.getLogger(JsonClient.class);

    private static final long serialVersionUID = -563409957519892271L;

    private CloseableHttpClient httpClient = null;
    private HttpGet httpGet = null;


    public void initialize() throws Exception {
        httpClient = HttpClientDetails.getHttpClientInstance();
        httpGet = HttpClientDetails.getHttpGetInstance();
    }

    /*  COMMENTS
     *   This method  takes string url as input and fetch the data from api and return http reponse.*/
    
    public HttpResponse processGet(String urlString) {
        HttpResponse httpResponse = null;
        try {
            HttpClientDetails.setGetUrl(urlString);
            HttpClientDetails.setJsonHeader("Accept", "application/json");
          //  HttpClientDetails.setJsonHeader("Content-Type", "application/json");
            httpResponse = httpClient.execute(httpGet);
        } catch (HttpClientErrorException e) {
            log.info("Error in connection:::" + e.getStackTrace());
        } catch (HttpResponseException e) {
            log.info("Error in connection:::" + e.getStackTrace());
        } catch (Throwable t) {
            log.info("Error in connection:::" + t.getStackTrace());
        }
        return httpResponse;

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        initialize();

    }
}