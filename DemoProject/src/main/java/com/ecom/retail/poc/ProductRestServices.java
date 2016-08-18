package com.ecom.retail.poc;

import static java.lang.String.format;

import java.io.IOException;
import java.io.Serializable;
import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ecom.retail.poc.constant.ServiceConstant;
import com.ecom.retail.poc.dao.ProductDetailsDAO;
import com.ecom.retail.poc.exception.ProductDetailException;
import com.ecom.retail.poc.helper.ServiceHelper;
import com.ecom.retail.poc.util.DataValidationUtil;
import com.ecom.retail.poc.util.JsonUtil;
import com.ecom.retail.poc.util.ServiceUtil;
import com.ecom.retail.poc.valueobject.ProductDetails;
import com.ecom.retail.poc.valueobject.ProductPrice;
import com.ecom.retail.poc.valueobject.ProductResponse;
import com.mongodb.util.JSON;

@Controller
@ Path("/products")
public class ProductRestServices implements Serializable {
    private static final Logger log = LoggerFactory.getLogger(ProductRestServices.class);

    private static final long serialVersionUID = -6892483547688122566L;
    @Autowired
    private ServiceHelper serviceHelper;


    @Autowired
    private ProductDetailsDAO productDetailsDAO;

    @Autowired
    private ServiceUtil serviceUtil;

    @Autowired
    private DataValidationUtil dataValidationUtil;


    /*  COMMENTS
     *   This method  used for get request using particular product id as input .
        It will  fetch the data from external target api and query the mongo db 
        to get price of a particular product.*/

    @GET
    @ Path("/{id}")
    @ Produces(MediaType.APPLICATION_JSON)
    public Response getProductDetailJson(@PathParam("id") String id) throws ProductDetailException {
    ProductDetails productDetails = null;
    ProductResponse productResp = null;
    boolean flag = false;
    try {
        if (!dataValidationUtil.isInteger(id)) {
            return Response.status(Response.Status.BAD_REQUEST).entity(format(ServiceConstant.ERROR_MSG_STRING)).build();
        } else if (!dataValidationUtil.isGreaterZero(id)) {
            return Response.status(Response.Status.BAD_REQUEST).entity(format(ServiceConstant.ERROR_MSG_STRING_ZERO)).build();
        } else if (StringUtils.isNotBlank(id)) {
            productDetails = new ProductDetails();
            productDetails.setId(dataValidationUtil.getProductItemId(id));
            productResp = serviceHelper.getProductExternalApi(id);
            if (null != productResp) {
                String name = serviceUtil.getProductName(productResp.getProductCompositeResponse());
                if (StringUtils.isNotBlank(name)) {
                    productDetails.setName(name);
                    flag = true;
                }
                if (flag) {
                    Optional < ProductPrice > optional = productDetailsDAO.readPriceById(id);
                    if (null != optional && optional.isPresent()) {
                        productDetails.setCurrent_Price(optional.get());
                    } else {
                        return Response.status(Response.Status.NOT_FOUND).entity(format(ServiceConstant.NO_PRICE_RECORD_MSG, id)).build();
                    }

                } else {
                    productDetails = null;
                }
            }
        }
    } catch (ProductDetailException e) {
        log.info("Exception during getProductDetailJson() method ::: " + e.getMessage());
        throw new ProductDetailException("Exception occurred during getProductDetailJson() method ::" + e.getMessage());
    }
    if (null == productDetails) {
        return Response.status(Response.Status.NOT_FOUND).entity(format(ServiceConstant.NO_RECORD_FOUND_MSG, id)).build();
    } else {
        return Response.ok(productDetails).build();
    }
  }

    /*  COMMENTS
     *   This method  used for put request to update the data in mongodb price colection.
        It will  take object as input and convert it to json.It will perform all vaildation
         before updating the record in Mongo DB.*/

    @PUT
    @ Path("/{id}")
    @ Consumes(MediaType.APPLICATION_JSON)
    public Response updateProductDetailJson(@PathParam("id") String id, Object object) throws ProductDetailException, IOException {
        ProductDetails productDetailObj = null;
        Response response = null;
        try {
            if (null == object) {
                return Response.status(Response.Status.BAD_REQUEST).entity(format(ServiceConstant.ERROR_NULL_OBJECT_MSG)).build();
            } else if (StringUtils.isBlank(id)) {
                return Response.status(Response.Status.BAD_REQUEST).entity(format(ServiceConstant.ID_CANNOT_BE_NULL)).build();
            } else if (!dataValidationUtil.isInteger(id)) {
                return Response.status(Response.Status.BAD_REQUEST).entity(format(ServiceConstant.ERROR_MSG_STRING)).build();
            } else if (!dataValidationUtil.isGreaterZero(id)) {
                return Response.status(Response.Status.BAD_REQUEST).entity(format(ServiceConstant.ERROR_MSG_STRING_ZERO)).build();
            } else {
                String jsonStr = JSON.serialize(object);
                productDetailObj = JsonUtil.fromJsonToProductObject(jsonStr);
                if (productDetailObj.getId() > 0 && null != productDetailObj.getCurrent_Price()) {
                    if (productDetailObj.getCurrent_Price().getValue() <= 0) {
                        return Response.status(Response.Status.BAD_REQUEST).entity(format(ServiceConstant.PRICE_ERROR_MSG, productDetailObj.getId())).build();
                    } else {
                        String value = productDetailObj.getCurrent_Price().getValue().toString();
                        //  String prodId = productDetailObj.getId().toString();
                        if (StringUtils.isNotBlank(id) && StringUtils.isNotBlank(value)) {
                            Optional < ProductPrice > option = productDetailsDAO.updateProductPriceObj(id, productDetailObj.getCurrent_Price());
                            if (null != option && option.isPresent()) {
                                return Response.status(Response.Status.NO_CONTENT).entity(format(ServiceConstant.SUCCESS_UPDATE_MSG, id)).build();
                            }
                            return Response.status(Response.Status.NOT_FOUND).entity(format(ServiceConstant.PRICE_ID_MSG, id)).build();
                        }
                    }
                }

            }
        } catch (ProductDetailException e) {
            log.info("Exception during updateProductDetailJson() method ::: " + e.getMessage());
            throw new ProductDetailException("Exception occurred during updateProductDetailJson() method ::" + e.getMessage());
        }
        return response;

    }

}