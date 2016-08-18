package com.ecom.retail.poc.valueobject;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProcessStatus {

    @JsonProperty("is_ready")
    private boolean isReady;
    @JsonProperty("operation_description")
    private String operationDescription;
    @JsonProperty("operation_code")
    private String operationCode;
    public void setIsReady(boolean isReady) {
         this.isReady = isReady;
     }
     public boolean getIsReady() {
         return isReady;
     }

    public void setOperationDescription(String operationDescription) {
         this.operationDescription = operationDescription;
     }
     public String getOperationDescription() {
         return operationDescription;
     }

    public void setOperationCode(String operationCode) {
         this.operationCode = operationCode;
     }
     public String getOperationCode() {
         return operationCode;
     }
	@Override
	public String toString() {
		return "ProcessStatus [isReady=" + isReady + ", operationDescription=" + operationDescription
				+ ", operationCode=" + operationCode + "]";
	}

}