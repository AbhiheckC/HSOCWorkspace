package com.idsspl.webproject.model;

public class CustomerModel {

	private String customerId;

	private String name;
	
	private String phonemobile;
	
	private String dateofbirth;
	
//	private String signature;

	public String getCustomerId() {
		return customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhonemobile() {
		return phonemobile;
	}

	public String getDateofbirth() {
		return dateofbirth;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public void setPhonemobile(String phonemobile) {
		this.phonemobile = phonemobile;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}


	
}
