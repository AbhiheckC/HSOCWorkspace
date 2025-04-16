package com.idsspl.webproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "CUSTOMER", schema = "CUSTOMER")
public class CustomerMobileModifyEntity {

	@Id
	@Column(name = "customer_id")
	private String customerId;
	
	@Column(name = "phonemobile")
	private String mobile;

	public String getCustomerId() {
		return customerId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
}
