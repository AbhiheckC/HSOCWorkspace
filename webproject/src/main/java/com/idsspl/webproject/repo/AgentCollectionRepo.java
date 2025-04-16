package com.idsspl.webproject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.idsspl.webproject.entity.AgentCollectionEntity;

@Repository
public interface AgentCollectionRepo extends JpaRepository<AgentCollectionEntity, String>{
//	
//	@Query("SELECT a FROM AgentCollectionEntity a WHERE a.customerId = :customerId and to_char(a.collectionDate,'YYYY-MM-DD') = :collectionDate and a.receiptNo = :receiptNo")
//	public List<AgentCollectionEntity> findByCustomerIdAndCollectionDate(@Param("customerId") String customerId, @Param("collectionDate") String collectionDate,@Param("receiptNo") long receiptNo);
//	
	
	@Modifying
	@Transactional
    @Query("UPDATE AgentCollectionEntity u SET u.collectionAmount = 0 WHERE u.customerId = ?1 and u.receiptNo = ?2")
    void updateCollectionAmt(String customerId, long receiptNo);
	
}
