package com.idsspl.webproject.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.idsspl.webproject.entity.AgentEntity;
import com.idsspl.webproject.entity.UserEntity;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long>{

//	public Optional<UserEntity> findById(Long userId);
	
	public UserEntity findByUserName(String userName);
	
//	@Query("UPDATE UserEntity u SET u.receiptNo = :receiptNo WHERE u.userName = :userName ")
//	public UserEntity updateReceiptNo(@Param("userName") String userName,@Param("receiptNo") long receiptNo);
	
	@Modifying
	@Transactional
    @Query("UPDATE UserEntity u SET u.receiptNo = ?2 WHERE u.userName = ?1")
    void updateReceiptNoByUserName(String userName, long receiptNo);
}
