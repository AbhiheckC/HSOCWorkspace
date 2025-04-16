package com.idsspl.webproject.model;


public class CollectionInfoModel {

	    private String customerId;
	    
	    private Double collectionAmount;

	    private String localLanguageName;

	    private String collectionDate;
	    
	    private Long receiptNo;
	    
	    private String agentName;
	    
	    private String agentId;
	    
	    private String paymentMethod;

		public String getCustomerId() {
			return customerId;
		}

		public Double getCollectionAmount() {
			return collectionAmount;
		}

		public String getLocalLanguageName() {
			return localLanguageName;
		}

		public String getCollectionDate() {
			return collectionDate;
		}

		public Long getReceiptNo() {
			return receiptNo;
		}

		public void setCustomerId(String customerId) {
			this.customerId = customerId;
		}

		public void setCollectionAmount(Double collectionAmount) {
			this.collectionAmount = collectionAmount;
		}

		public void setLocalLanguageName(String localLanguageName) {
			this.localLanguageName = localLanguageName;
		}

		public void setCollectionDate(String collectionDate) {
			this.collectionDate = collectionDate;
		}

		public void setReceiptNo(Long receiptNo) {
			this.receiptNo = receiptNo;
		}

		public String getAgentId() {
			return agentId;
		}

		public void setAgentId(String agentId) {
			this.agentId = agentId;
		}

		public String getAgentName() {
			return agentName;
		}

		public void setAgentName(String agentName) {
			this.agentName = agentName;
		}

		public String getPaymentMethod() {
			return paymentMethod;
		}

		public void setPaymentMethod(String paymentMethod) {
			this.paymentMethod = paymentMethod;
		}
	    
	    
}
