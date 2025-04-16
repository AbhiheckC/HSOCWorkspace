
package com.idsspl.webproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name = "CUSTOMER_AGENT_COLLECTION", schema = "CUSTOMER")
@Table(name = "ACCOUNT_STMT_VIEW", schema = "CUSTOMER")
public class AccountStatementEntity {
 
	 @Id
	  @Column(name = "id")
	    private Long id;
    
    @Column(name = "txn_date")
    private String txndate;
    
    @Column(name = "txn_number")
    private String txnnumber;
    
    @Column(name = "account_code")
    private String accountCode;
    
    @Column(name = "particular")
//    @Column(name = "HINDHI_DESCRIPTION")
    private String particular;
    
    @Column(name = "transactionindicator_code")
    private String transactionindicatorcode;
    
    @Column(name = "amount")
	private Double amount;
    
    @Column(name = "accountbalance")
   	private Double accountbalance;

   
    @Column(name = "authorizeseqnumber")
   	private Long authorizeseqnumber;
    
    
    @Column(name = "transactionstatus")
   	private String transactionstatus;
    
	public String getTransactionstatus() {
		return transactionstatus;
	}

	public void setTransactionstatus(String transactionstatus) {
		this.transactionstatus = transactionstatus;
	}

	public Long getAuthorizeseqnumber() {
		return authorizeseqnumber;
	}

	public void setAuthorizeseqnumber(Long authorizeseqnumber) {
		this.authorizeseqnumber = authorizeseqnumber;
	}

	public Double getAccountbalance() {
		return accountbalance;
	}

	public void setAccountbalance(Double accountbalance) {
		this.accountbalance = accountbalance;
	}

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
    
  

    
}