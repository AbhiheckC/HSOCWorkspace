package com.idsspl.webproject.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.idsspl.webproject.entity.AgentEntity;

import java.util.List;

@Repository
public interface AgentRepo extends JpaRepository<AgentEntity, String>{
	
//	public Optional<AgentEntity> findById(String account_code);
//	
	
//	public List<AgentEntity> findByCustomerIdOrName(String customerId,String name);
	
//	@Query("SELECT a FROM AgentEntity a WHERE a.customerId LIKE %:customerId% OR a.name LIKE %:name%")
//	public List<AgentEntity> findByCustomerIdOrName(@Param("customerId") String customerId,@Param("name") String name);
	
//	public List<AgentEntity> findByCustomerIdOrNameContainingIgnoreCase(String customerId,String name);
	
//	public List<AgentEntity> findByCustomerId(String customerId);
	
	@Query("SELECT a FROM AgentEntity a WHERE a.customerId in (:customerId, '0')")
	public List<AgentEntity> findByCustomerId(@Param("customerId") String customerId);
	
	@Query("SELECT a FROM AgentEntity a WHERE a.customerId in (:customerId)")
	public List<AgentEntity> findByCustomerIdforMobile(@Param("customerId") String customerId);
//	@Query("SELECT a FROM AgentEntity a WHERE a.customer_id = customerId and agent_name = userName")
//	public List<AgentEntity> findByCustomerId(@Param("customerId") String customerId, @Param("userName") String userName);
	
//	public List<AgentEntity> findByCustomerIdAndAgentName(String customerId, String agentName);
	
//	public List<AgentEntity> findByNameContainingIgnoreCase(String name);
	
	@Query("SELECT a FROM AgentEntity a WHERE UPPER(a.name) LIKE UPPER(CONCAT('%', :name, '%'))")
	public List<AgentEntity> findByCustomerName(@Param("name") String name);
	
//	@Query("SELECT a FROM AgentEntity a WHERE UPPER(a.name) LIKE UPPER(CONCAT('%', :name, '%')) AND UPPER(a.agentName) = UPPER(:agentName)")
//	public List<AgentEntity> findByCustomerName(@Param("name") String name, @Param("agentName") String agentName);

	
}
