package com.ecom.retail.poc.valueobject;

public class Features {
  
	private String feature;
    public void setFeature(String feature) {
         this.feature = feature;
     }
     public String getFeature() {
         return feature;
     }

     @Override
 	public String toString() {
 		return "Features [feature=" + feature + "]";
 	}
}