package com.idsspl.webproject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.idsspl.webproject.entity.AgentLocationEntity;
import com.idsspl.webproject.model.AgentLocationModel;

@Repository
public interface AgentLocationRepo extends JpaRepository<AgentLocationEntity, String>{
	
	@Query("SELECT DISTINCT a FROM AgentLocationEntity a WHERE a.agentId = (:agentId)")
	public List<AgentLocationEntity> findByAgentId(@Param("agentId") String agentId);

}
