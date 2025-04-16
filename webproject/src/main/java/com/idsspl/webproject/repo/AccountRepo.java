package com.idsspl.webproject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.idsspl.webproject.entity.AccountEntity;

@Repository
public interface AccountRepo extends JpaRepository<AccountEntity, String>{
	
	@Query("SELECT a FROM AccountEntity a WHERE ACCOUNT_STATUS='L'  ")
	public List<AccountEntity> findAllOfTheAccountCode();
	
	@Query("SELECT a FROM AccountEntity a WHERE ACCOUNT_STATUS='L' AND trim(a.accountCode) = :accountCode  ")
	public List<AccountEntity>  findCustAccountCode(@Param("accountCode") String accountCode);


}