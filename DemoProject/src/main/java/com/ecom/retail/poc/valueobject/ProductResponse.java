package com.ecom.retail.poc.valueobject;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductResponse {

    @JsonProperty("product_composite_response")
    private ProductCompositeResponse productCompositeResponse;
    public void setProductCompositeResponse(ProductCompositeResponse productCompositeResponse) {
         this.productCompositeResponse = productCompositeResponse;
     }
     public ProductCompositeResponse getProductCompositeResponse() {
         return productCompositeResponse;
     }
	@Override
	public String toString() {
		return "ProductResponse [productCompositeResponse=" + productCompositeResponse + "]";
	}

}