package com.idsspl.webproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.ColumnTransformer;

@Entity
@Table(name = "USERREGISTER")
public class UserEntity {
	@Column(name = "user_id")
	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userIdGenerator")
//	@SequenceGenerator(name = "userIdGenerator", sequenceName = "user_id_generator_seq", allocationSize = 1)
//	@GenericGenerator(name="userIdGenerator", strategy="native")
//    @GeneratedValue(strategy = GenerationType.AUTO)
	private String userName;

	@Column(name = "active")
	private Integer active;

	@Column(name = "passwd")
	@ColumnTransformer(read = "hsoc.toolkit.decrypt(passwd)")//,write = "encrypt('AES', '00', ?)"
	private String password;
	
	@Column(name = "agent_id")
	private String agentId;
	
	@Column(name = "receipt_no")
	private Long receiptNo;

	@Column(name = "role")
	private String role;
	
	@Column(name = "is_main_app_user")
	private String isMainAppUser;

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	public Long getReceiptNo() {
		return receiptNo;
	}

	public void setReceiptNo(Long receiptNo) {
		this.receiptNo = receiptNo;
	}

	public String getIsMainAppUser() {
		return isMainAppUser;
	}

	public void setIsMainAppUser(String isMainAppUser) {
		this.isMainAppUser = isMainAppUser;
	}


}
