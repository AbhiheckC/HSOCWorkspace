package com.idsspl.webproject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.idsspl.webproject.entity.CollectionInfoEntity;

@Repository
public interface CollectionInfoRepo extends JpaRepository<CollectionInfoEntity, String>{ 

	public List<CollectionInfoEntity> findByAgentId(String agentId);
	
	@Query("SELECT a FROM CollectionInfoEntity a WHERE a.agentId = :agentId and a.agentName = :agentName")
	public List<CollectionInfoEntity> findInfoByAgentIdAndAgentName(@Param("agentId") String agentId,@Param("agentName") String agentName);
	
	
}
