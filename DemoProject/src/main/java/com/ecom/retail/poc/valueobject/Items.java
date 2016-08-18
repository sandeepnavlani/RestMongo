package com.ecom.retail.poc.valueobject;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
public class Items {

    private List<Identifier> identifier;
    private String relation;
    @JsonProperty("relation_description")
    private String relationDescription;
    @JsonProperty("data_page_link")
    private String dataPageLink;
    @JsonProperty("imn_identifier")
    private int imnIdentifier;
    @JsonProperty("is_orderable")
    private boolean isOrderable;
    @JsonProperty("is_sellable")
    private boolean isSellable;
    @JsonProperty("general_description")
    private String generalDescription;
    @JsonProperty("is_circular_publish")
    private boolean isCircularPublish;
    @JsonProperty("business_process_status")
    private List<BusinessProcessStatus> businessProcessStatus;
    private String dpci;
    @JsonProperty("department_id")
    private int departmentId;
    @JsonProperty("class_id")
    private int classId;
    @JsonProperty("item_id")
    private int itemId;
    @JsonProperty("online_description")
    private OnlineDescription onlineDescription;
    @JsonProperty("store_description")
    private StoreDescription storeDescription;
    @JsonProperty("alternate_description")
    private List<AlternateDescription> alternateDescription;
    private List<Features> features;
    public void setIdentifier(List<Identifier> identifier) {
         this.identifier = identifier;
     }
     public List<Identifier> getIdentifier() {
         return identifier;
     }

    public void setRelation(String relation) {
         this.relation = relation;
     }
     public String getRelation() {
         return relation;
     }

    public void setRelationDescription(String relationDescription) {
         this.relationDescription = relationDescription;
     }
     public String getRelationDescription() {
         return relationDescription;
     }

    public void setDataPageLink(String dataPageLink) {
         this.dataPageLink = dataPageLink;
     }
     public String getDataPageLink() {
         return dataPageLink;
     }

    public void setImnIdentifier(int imnIdentifier) {
         this.imnIdentifier = imnIdentifier;
     }
     public int getImnIdentifier() {
         return imnIdentifier;
     }

    public void setIsOrderable(boolean isOrderable) {
         this.isOrderable = isOrderable;
     }
     public boolean getIsOrderable() {
         return isOrderable;
     }

    public void setIsSellable(boolean isSellable) {
         this.isSellable = isSellable;
     }
     public boolean getIsSellable() {
         return isSellable;
     }

    public void setGeneralDescription(String generalDescription) {
         this.generalDescription = generalDescription;
     }
     public String getGeneralDescription() {
         return generalDescription;
     }

    public void setIsCircularPublish(boolean isCircularPublish) {
         this.isCircularPublish = isCircularPublish;
     }
     public boolean getIsCircularPublish() {
         return isCircularPublish;
     }

    public void setBusinessProcessStatus(List<BusinessProcessStatus> businessProcessStatus) {
         this.businessProcessStatus = businessProcessStatus;
     }
     public List<BusinessProcessStatus> getBusinessProcessStatus() {
         return businessProcessStatus;
     }

    public void setDpci(String dpci) {
         this.dpci = dpci;
     }
     public String getDpci() {
         return dpci;
     }

    public void setDepartmentId(int departmentId) {
         this.departmentId = departmentId;
     }
     public int getDepartmentId() {
         return departmentId;
     }

    public void setClassId(int classId) {
         this.classId = classId;
     }
     public int getClassId() {
         return classId;
     }

    public void setItemId(int itemId) {
         this.itemId = itemId;
     }
     public int getItemId() {
         return itemId;
     }

    public void setOnlineDescription(OnlineDescription onlineDescription) {
         this.onlineDescription = onlineDescription;
     }
     public OnlineDescription getOnlineDescription() {
         return onlineDescription;
     }

    public void setStoreDescription(StoreDescription storeDescription) {
         this.storeDescription = storeDescription;
     }
     public StoreDescription getStoreDescription() {
         return storeDescription;
     }

    public void setAlternateDescription(List<AlternateDescription> alternateDescription) {
         this.alternateDescription = alternateDescription;
     }
     public List<AlternateDescription> getAlternateDescription() {
         return alternateDescription;
     }

    public void setFeatures(List<Features> features) {
         this.features = features;
     }
     public List<Features> getFeatures() {
         return features;
     }
	@Override
	public String toString() {
		return "Items [identifier=" + identifier + ", relation=" + relation + ", relationDescription="
				+ relationDescription + ", dataPageLink=" + dataPageLink + ", imnIdentifier=" + imnIdentifier
				+ ", isOrderable=" + isOrderable + ", isSellable=" + isSellable + ", generalDescription="
				+ generalDescription + ", isCircularPublish=" + isCircularPublish + ", businessProcessStatus="
				+ businessProcessStatus + ", dpci=" + dpci + ", departmentId=" + departmentId + ", classId=" + classId
				+ ", itemId=" + itemId + ", onlineDescription=" + onlineDescription + ", storeDescription="
				+ storeDescription + ", alternateDescription=" + alternateDescription + ", features=" + features + "]";
	}

}