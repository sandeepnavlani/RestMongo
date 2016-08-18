package com.ecom.retail.poc.valueobject;

public class RequestAttributes {

 
	private String name;
    private String value;
    public void setName(String name) {
         this.name = name;
     }
     public String getName() {
         return name;
     }

    public void setValue(String value) {
         this.value = value;
     }
     public String getValue() {
         return value;
     }
     @Override
 	public String toString() {
 		return "RequestAttributes [name=" + name + ", value=" + value + "]";
 	}
}