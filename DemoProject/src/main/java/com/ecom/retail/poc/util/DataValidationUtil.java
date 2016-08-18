package com.ecom.retail.poc.util;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.ecom.retail.poc.exception.ProductDetailException;


@Component
public class DataValidationUtil implements Serializable {


    private static final long serialVersionUID = -4029428454724520125L;
    private static final Logger log = LoggerFactory.getLogger(DataValidationUtil.class);

    /*  COMMENTS
     *  it will check  incoming string is integer  .*/
    
    public  boolean isInteger(String s) {
        try { 
            Integer.parseInt(s); 
        } catch(NumberFormatException e) { 
            return false; 
        } catch(NullPointerException e) {
            return false;
        }
        return true;
    }
    
    /*  COMMENTS
     *  it will check  incoming string is integer  .*/
    
	public boolean isGreaterZero(String s) {
		try {
			int id = Integer.parseInt(s);
			if (id <= 0) {
				return false;
			}
		} catch (NumberFormatException e) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
		return true;
	}
	
	
    /*  COMMENTS
     *  it will Convert String id to integer id  .*/
    public Integer getProductItemId(String id) throws ProductDetailException {
        try {
            return Integer.parseInt(id);
        } catch (NumberFormatException nfe) {
            log.info("Exception occurred during Number format exception:::" + nfe.getMessage());
            throw new ProductDetailException("Number format exception unable to convert from String to Integer :::" + id);
        }

    }

}