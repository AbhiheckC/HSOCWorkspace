
package com.idsspl.webproject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.idsspl.webproject.entity.AccountStatementEntity;
import com.idsspl.webproject.entity.PrintAgentCollectionEntity;

public interface PrintAccountStatementRepo extends JpaRepository<AccountStatementEntity, String>{

	@Query("SELECT a FROM AccountStatementEntity a WHERE trim(a.accountCode) = :accountCode and   to_char(a.txndate,'YYYY-MM-DD') <= :txndate and a.transactionstatus = 'A' ORDER BY to_char(a.txndate,'YYYY-MM-DD'),a.authorizeseqnumber") //to_char(a.txndate,'YYYY-MM-DD') >= :txndate and
	public List<AccountStatementEntity> findByAccountCodeAndTxnDate(@Param("accountCode") String accountCode, @Param("txndate") String txndate);
}
