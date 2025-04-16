package com.idsspl.webproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER_AGENT_COLLECTION", schema = "CUSTOMER")
//@Table(name = "CUSTOMER_AGENT_COLLECTION_VIEW", schema = "CUSTOMER")
public class AgentCollectionEntity {
 
    @Id
    @Column(name = "id")
    private String id;
    
    @Column(name = "customer_id")
    private String customerId;
    
    @Column(name = "account_code")
    private String accountCode;
    
    @Column(name = "account_type")
//    @Column(name = "HINDHI_DESCRIPTION")
    private String accountType;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "ledgerbalance")
	private Double ledgerbalance;
    
    @Column(name = "collection_amount")
    private Double collectionAmount;
    
    @Column(name = "latitude")
    private String latitude;
    
    @Column(name = "longitude")
    private String longitude; 
    
    @Column(name = "agent_name")
    private String agentName;
    
    @Column(name = "agent_id")
    private String agentId;
    
    @Column(name = "collection_date")
    private String collectionDate;
    
    @Column(name = "receipt_no")
    private Long receiptNo;
    
    @Column(name = "payment_method")
    private String paymentMethod;
    
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getLedgerbalance() {
		return ledgerbalance;
	}

	public void setLedgerbalance(Double ledgerbalance) {
		this.ledgerbalance = ledgerbalance;
	}

	public Double getCollectionAmount() {
		return collectionAmount;
	}

	public void setCollectionAmount(Double collectionAmount) {
		this.collectionAmount = collectionAmount;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
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

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
 
    
}