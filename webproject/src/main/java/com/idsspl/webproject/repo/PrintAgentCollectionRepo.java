package com.idsspl.webproject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.idsspl.webproject.entity.PrintAgentCollectionEntity;

public interface PrintAgentCollectionRepo extends JpaRepository<PrintAgentCollectionEntity, String>{

	@Query("SELECT a FROM PrintAgentCollectionEntity a WHERE trim(a.customerId) = :customerId and to_char(a.collectionDate,'YYYY-MM-DD') = :collectionDate and a.receiptNo = :receiptNo")
	public List<PrintAgentCollectionEntity> findByCustomerIdAndCollectionDate(@Param("customerId") String customerId, @Param("collectionDate") String collectionDate,@Param("receiptNo") long receiptNo);
	
	@Query("SELECT a FROM PrintAgentCollectionEntity a WHERE trim(a.customerId) = :customerId")
	public List<PrintAgentCollectionEntity> findByCustomerId(@Param("customerId") String customerId);
}
