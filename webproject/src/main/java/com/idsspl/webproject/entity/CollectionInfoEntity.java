package com.idsspl.webproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AGENT_DAILY_COLLECTION", schema = "CUSTOMER")
public class CollectionInfoEntity {
 
    
    @Column(name = "customer_id")
    private String customerId;
    
    @Column(name = "collection_amount")
    private Double collectionAmount;
    
	@Column(name = "local_language_name")
	private String localLanguageName;

    @Column(name = "collection_date")
    private String collectionDate;
    
    @Id
    @Column(name = "receipt_no")
    private Long receiptNo;
    
    @Column(name = "agent_id")
    private String agentId;
    
    @Column(name = "agent_name")
    private String agentName;
    
    @Column(name = "payment_method")
    private String paymentMethod;


	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Double getCollectionAmount() {
		return collectionAmount;
	}

	public void setCollectionAmount(Double collectionAmount) {
		this.collectionAmount = collectionAmount;
	}

	public String getCollectionDate() {
		return collectionDate;
	}

	public void setCollectionDate(String collectionDate) {
		this.collectionDate = collectionDate;
	}

	public Long getReceiptNo() {
		return receiptNo;
	}

	public void setReceiptNo(Long receiptNo) {
		this.receiptNo = receiptNo;
	}

	public String getLocalLanguageName() {
		return localLanguageName;
	}

	public void setLocalLanguageName(String localLanguageName) {
		this.localLanguageName = localLanguageName;
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