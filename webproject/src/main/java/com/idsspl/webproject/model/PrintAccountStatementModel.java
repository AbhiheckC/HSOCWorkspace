package com.idsspl.webproject.model;

public class PrintAccountStatementModel {

	private String txndate;

	private String txnnumber;

	private String accountCode;

	private String particular;

	private String transactionindicatorcode;

	private Double amount;

	private Double accountbalance;

	

	public String getTxndate() {
		return txndate;
	}

	public String getTxnnumber() {
		return txnnumber;
	}

	public String getAccountCode() {
		return accountCode;
	}

	public String getParticular() {
		return particular;
	}

	public String getTransactionindicatorcode() {
		return transactionindicatorcode;
	}

	public Double getAmount() {
		return amount;
	}

	public Double getAccountbalance() {
		return accountbalance;
	}



	public void setTxndate(String txndate) {
		this.txndate = txndate;
	}

	public void setTxnnumber(String txnnumber) {
		this.txnnumber = txnnumber;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	public void setParticular(String particular) {
		this.particular = particular;
	}

	public void setTransactionindicatorcode(String transactionindicatorcode) {
		this.transactionindicatorcode = transactionindicatorcode;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public void setAccountbalance(Double accountbalance) {
		this.accountbalance = accountbalance;
	}


	
}
