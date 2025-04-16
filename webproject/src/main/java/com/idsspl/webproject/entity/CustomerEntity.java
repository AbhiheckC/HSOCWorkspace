package com.idsspl.webproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity   
@Table(name = "CUSTOMER_7JUN23", schema = "CUSTOMER")
public class CustomerEntity {
	@Column(name = "customer_id")
	@Id
	private String customerId;

	@Column(name = "name")
	private String name;
	
	@Column(name ="phonemobile")
	private String phonemobile;
	
	@Column(name = "dateofbirth")
	private String dateofbirth;

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
	
//	@Column(name = "signature")
//	private Blob signature;
//	
//	@Column(name = "signature")
//	private byte[] signature;
	
	
	
	
	
}
