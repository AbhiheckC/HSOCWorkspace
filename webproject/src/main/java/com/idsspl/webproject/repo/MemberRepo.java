package com.idsspl.webproject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.idsspl.webproject.entity.MemberEntity;

public interface MemberRepo extends JpaRepository<MemberEntity, String> {
	
	@Query("SELECT a FROM MemberEntity a WHERE UPPER(a.name) LIKE UPPER(CONCAT('%', :name, '%'))")
	public List<MemberEntity> findByCustomerName(@Param("name") String name);
	
//	@Query("SELECT a FROM MemberEntity a WHERE UPPER(a.name) LIKE UPPER(CONCAT('%', :name, '%')) AND UPPER(a.agentName) = UPPER(:agentName)")
//	public List<MemberEntity> findByCustomerName(@Param("name") String name, @Param("agentName") String agentName);
}
