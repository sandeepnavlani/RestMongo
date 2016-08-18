package com.ecom.retail.poc.valueobject;
import com.fasterxml.jackson.annotation.JsonProperty;
public class AlternateDescription {

   
	private String type;
    private String value;
    @JsonProperty("type_description")
    private String typeDescription;
    public void setType(String type) {
         this.type = type;
     }
     public String getType() {
         return type;
     }

    public void setValue(String value) {
         this.value = value;
     }
     public String getValue() {
         return value;
     }

    public void setTypeDescription(String typeDescription) {
         this.typeDescription = typeDescription;
     }
     public String getTypeDescription() {
         return typeDescription;
     }
     @Override
 	public String toString() {
 		return "AlternateDescription [type=" + type + ", value=" + value + ", typeDescription=" + typeDescription + "]";
 	}
}