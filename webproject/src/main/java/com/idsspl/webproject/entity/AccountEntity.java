package com.idsspl.webproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity   
@Table(name = "ACCOUNT", schema = "ACCOUNT")
public class AccountEntity {
	
	@Id
	@Column(name= "account_code")
	private String accountCode;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "customer_id")
	private String customerId;

	public String getAccountCode() {
		return accountCode;
	}

	public String getName() {
		return name;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}


}
