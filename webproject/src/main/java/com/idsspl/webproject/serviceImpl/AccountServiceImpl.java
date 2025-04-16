package com.idsspl.webproject.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idsspl.webproject.entity.AccountEntity;
import com.idsspl.webproject.model.AccountModel;
import com.idsspl.webproject.repo.AccountRepo;
import com.idsspl.webproject.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountRepo accountRepo;
	
	@Override
	public List<AccountModel> getAccountCodeList() {
	    System.out.println("----------------Get Account Code Starts----------------");
	    List<AccountEntity> accountEntityList = accountRepo.findAll();
	    List<AccountModel> accountModelList = new ArrayList<>();
	    
	    accountEntityList.forEach(accountEntity -> {
	        AccountModel accountModel = new AccountModel();
	        accountModel.setAccountCode(accountEntity.getAccountCode());
	        accountModelList.add(accountModel);
	    });
	    
	    System.out.println("----------------Get Account Code Ends----------------");
	    return accountModelList; // Return the list instead of null
	}


}
