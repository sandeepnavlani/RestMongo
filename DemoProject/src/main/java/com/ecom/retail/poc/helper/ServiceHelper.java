package com.ecom.retail.poc.helper;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecom.retail.poc.exception.ProductDetailException;
import com.ecom.retail.poc.http.JsonClient;
import com.ecom.retail.poc.util.JsonUtil;
import com.ecom.retail.poc.util.ServiceUtil;
import com.ecom.retail.poc.valueobject.ProductResponse;

@Component
public class ServiceHelper implements Serializable {

    private static final long serialVersionUID = -2110046782681256343L;

    private static final Logger log = LoggerFactory.getLogger(ServiceHelper.class);

    @Autowired
    private JsonClient jsonClient;

    @Autowired
    private ServiceUtil serviceUtil;

    /*  COMMENTS
     *   This method  used to take String as input (id) formed the url to fetch data from external target api.
     *   HTTP GET method is used to fetch the data from api.After getting 200 response code it will parse and 
     *   return the productresponse object.*/
    
    public ProductResponse getProductExternalApi(String id) throws ProductDetailException {
        ProductResponse resp = null;
        try {
            String url = serviceUtil.getUrlString(id);
            if (StringUtils.isNotEmpty(url)) {
                HttpResponse jsonResponse = jsonClient.processGet(url);

                if (jsonResponse.getStatusLine().getStatusCode() == 200) {
                    HttpEntity httpEntity = jsonResponse.getEntity();
                    resp = JsonUtil.fromJsonToProductResponseObject(httpEntity.getContent());
                }
            }
        } catch (Exception e) {
            log.info("Exception occurred during price response :::" + e.getMessage());
            throw new ProductDetailException("Exception occurred during price response  :::" + e.getMessage());
        }

        return resp;
    }

}