package com.ecom.retail.poc.util;

import java.io.Serializable;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.ecom.retail.poc.constant.ServiceConstant;
import com.ecom.retail.poc.valueobject.ProductCompositeResponse;
@Component
public class ServiceUtil implements Serializable {
    private static final Logger log = LoggerFactory.getLogger(ServiceUtil.class);
    private static final long serialVersionUID = 418897235981760852L;

    @Autowired
    @ Qualifier("myProperties")
    private ReloadableResourceBundleMessageSource myProperties;

    public String getUrlString(String id) throws NullPointerException {
        String url = null;
        try {
            StringBuilder builder = new StringBuilder();
            url = builder.append(ServiceConstant.HTTPS)
                .append(myProperties.getMessage("host.name", null, Locale.US))
                .append(myProperties.getMessage("product.url", null, Locale.US)).append(id)
                .append(myProperties.getMessage("remianing.url", null, Locale.US)).toString();

        } catch (Exception e) {
            log.info("Exception during getUrlString() method ::: " + e.getMessage());

        }
        return url;

    }

    public String getProductName(ProductCompositeResponse productCompositeRes) {
        String name = null;
        if (null != productCompositeRes && !CollectionUtils.isEmpty(productCompositeRes.getItems())) {
            if (null != productCompositeRes.getItems().get(0).getOnlineDescription() && StringUtils.isNotBlank(productCompositeRes.getItems().get(0).getOnlineDescription().getValue()))
                name = productCompositeRes.getItems().get(0).getOnlineDescription().getValue();
        }
     return name;
    }

}