package com.ecom.retail.poc.valueobject;
import com.fasterxml.jackson.annotation.JsonProperty;
public class BusinessProcessStatus {

    @Override
	public String toString() {
		return "BusinessProcessStatus [processStatus=" + processStatus + "]";
	}
	@JsonProperty("process_status")
    private ProcessStatus processStatus;
    public void setProcessStatus(ProcessStatus processStatus) {
         this.processStatus = processStatus;
     }
     public ProcessStatus getProcessStatus() {
         return processStatus;
     }

}