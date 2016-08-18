package com.ecom.retail.poc.valueobject;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
public class ProductCompositeResponse {

    @JsonProperty("request_attributes")
    private List<RequestAttributes> requestAttributes;
    private List<Items> items;
    public void setRequestAttributes(List<RequestAttributes> requestAttributes) {
         this.requestAttributes = requestAttributes;
     }
     public List<RequestAttributes> getRequestAttributes() {
         return requestAttributes;
     }

    public void setItems(List<Items> items) {
         this.items = items;
     }
     public List<Items> getItems() {
         return items;
     }
	@Override
	public String toString() {
		return "ProductCompositeResponse [requestAttributes=" + requestAttributes + ", items=" + items + "]";
	}

}