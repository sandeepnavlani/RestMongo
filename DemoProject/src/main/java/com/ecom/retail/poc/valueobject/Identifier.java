package com.ecom.retail.poc.valueobject;
import com.fasterxml.jackson.annotation.JsonProperty;
public class Identifier {

    @JsonProperty("id_type")
    private String idType;
    private String id;
    @JsonProperty("is_primary")
    private String isPrimary;
    private String source;
    public void setIdType(String idType) {
         this.idType = idType;
     }
     public String getIdType() {
         return idType;
     }

    public void setId(String id) {
         this.id = id;
     }
     public String getId() {
         return id;
     }

    public void setIsPrimary(String isPrimary) {
         this.isPrimary = isPrimary;
     }
     public String getIsPrimary() {
         return isPrimary;
     }

    public void setSource(String source) {
         this.source = source;
     }
     public String getSource() {
         return source;
     }
	@Override
	public String toString() {
		return "Identifier [idType=" + idType + ", id=" + id + ", isPrimary=" + isPrimary + ", source=" + source + "]";
	}

}