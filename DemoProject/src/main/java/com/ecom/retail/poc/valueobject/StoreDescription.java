package com.ecom.retail.poc.valueobject;

public class StoreDescription {

   
	private String value;
    private String type;
    public void setValue(String value) {
         this.value = value;
     }
     public String getValue() {
         return value;
     }

    public void setType(String type) {
         this.type = type;
     }
     public String getType() {
         return type;
     }

     @Override
 	public String toString() {
 		return "StoreDescription [value=" + value + ", type=" + type + "]";
 	}
}