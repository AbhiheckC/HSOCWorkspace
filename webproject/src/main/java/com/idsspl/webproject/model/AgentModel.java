package com.idsspl.webproject.model;

import javax.persistence.Column;

public class AgentModel {
	
	private String accountCode;

	private String name;

	private Double ledgerbalance;

	private String customerId;
	
	private String accountType;
	
	private String localLanguageName;
	
	private String agentName;
	
	private String mobile;
	
	private String installmentAmount;
	
	private String reviewDate;

    private Long receiptNo;

	public String getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
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

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getLocalLanguageName() {
		return localLanguageName;
	}

	public void setLocalLanguageName(String localLanguageName) {
		this.localLanguageName = localLanguageName;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getInstallmentAmount() {
		return installmentAmount;
	}

	public String getReviewDate() {
		return reviewDate;
	}

	public void setInstallmentAmount(String installmentAmount) {
		this.installmentAmount = installmentAmount;
	}

	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}

	public Long getReceiptNo() {
		return receiptNo;
	}

	public void setReceiptNo(Long receiptNo) {
		this.receiptNo = receiptNo;
	}

	
	
	
}
