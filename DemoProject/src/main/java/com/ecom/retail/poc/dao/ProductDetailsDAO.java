package com.ecom.retail.poc.dao;

import java.util.Optional;

import com.ecom.retail.poc.exception.ProductDetailException;
import com.ecom.retail.poc.valueobject.ProductPrice;

public interface ProductDetailsDAO {	
	
public  Optional<ProductPrice> readPriceById(String id) throws ProductDetailException;
	
public Optional<ProductPrice> updateProductPriceObj(String id, ProductPrice productPrice) throws ProductDetailException;
	

}
