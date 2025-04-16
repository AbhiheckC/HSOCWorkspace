package com.idsspl.webproject.model;

public class MemberModel {
	
	private String accountCode;

	private String name;

	private String customerId;
	
	private String accountType;
	
	private String localLanguageName;
	
	private String agentName;
	
	private String mobile;
	
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

	public String getAreaname() {
		return areaname;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}

}
