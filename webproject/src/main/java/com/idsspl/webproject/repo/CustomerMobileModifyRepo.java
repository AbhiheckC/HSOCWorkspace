package com.idsspl.webproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.idsspl.webproject.entity.CustomerMobileModifyEntity;

public interface CustomerMobileModifyRepo extends JpaRepository<CustomerMobileModifyEntity, String>{
	@Modifying
	@Transactional
    @Query("UPDATE CustomerMobileModifyEntity u SET u.mobile = ?2  WHERE u.customerId = ?1")
    void updateCustomerMobile(String customerId, String mobile);

}
