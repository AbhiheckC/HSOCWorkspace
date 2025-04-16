package com.idsspl.webproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER_AGENT", schema = "CUSTOMER")
public class MemberEntity {
	@Column(name = "account_code")
	@Id
	private String accountCode;

	@Column(name = "name")
	private String name;

	@Column(name = "customer_id")
	private String customerId;
	
	@Column(name = "account_type")
	private String accountType;
	
	@Column(name = "local_language_name")
	private String localLanguageName;
	
	@Column(name = "agent_name")
	private String agentName;
	
	@Column(name = "mobile")
	private String mobile;
	
	@Column(name = "areaname")
	private String areaname;

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

	public String getAreaname() {
		return areaname;
	}

	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}
	


}
