package com.idsspl.webproject.service;

import java.util.List;

import com.idsspl.webproject.model.AgentCollectionModel;
import com.idsspl.webproject.model.AgentLocationModel;
import com.idsspl.webproject.model.AgentModel;
import com.idsspl.webproject.model.CollectionInfoModel;
import com.idsspl.webproject.model.CustomerMobileModifyModel;
import com.idsspl.webproject.model.PrintAccountStatementModel;
import com.idsspl.webproject.model.PrintAgentCollectionModel;


public interface AgentService {
	
	public String sayHello();
	
	public List<AgentModel> getAgentsList(AgentModel agent, String userName);

	public String saveAgentCollection(AgentCollectionModel agentCollection, String userName);
	
	public List<PrintAgentCollectionModel> getCollectionList(PrintAgentCollectionModel collection);
	
	public List<CollectionInfoModel> getCollectionInfoList(CollectionInfoModel collection, String userName);
	
	public String makeCollectionAmt0(CollectionInfoModel collection);
//	public List<CollectionInfoModel> getCollectionInfoList( String userName);
	
	public List<AgentModel> getUpdateMobileCustomerList(AgentModel agent);
	
	public String updateCustomerMobileNo(CustomerMobileModifyModel customer);
	
	public List<AgentLocationModel> getAgentLocation(AgentLocationModel agentLoc);
	
	public String getMainUser(String userName);
	
	public List<PrintAccountStatementModel> getCollectionList(PrintAccountStatementModel collection);

}
