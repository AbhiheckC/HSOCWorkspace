package com.idsspl.webproject.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.Random;
import java.util.function.Predicate;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.idsspl.webproject.entity.AccountEntity;
import com.idsspl.webproject.entity.AccountStatementEntity;
import com.idsspl.webproject.entity.AgentCollectionEntity;
import com.idsspl.webproject.entity.AgentEntity;
import com.idsspl.webproject.entity.AgentLocationEntity;
import com.idsspl.webproject.entity.CollectionInfoEntity;
import com.idsspl.webproject.entity.MemberEntity;
import com.idsspl.webproject.entity.PrintAgentCollectionEntity;
import com.idsspl.webproject.entity.UserEntity;
import com.idsspl.webproject.model.AgentCollectionModel;
import com.idsspl.webproject.model.AgentLocationModel;
import com.idsspl.webproject.model.AgentModel;
import com.idsspl.webproject.model.CollectionInfoModel;
import com.idsspl.webproject.model.CustomerMobileModifyModel;
import com.idsspl.webproject.model.MemberModel;
import com.idsspl.webproject.model.PrintAccountStatementModel;
import com.idsspl.webproject.model.PrintAgentCollectionModel;
import com.idsspl.webproject.repo.AccountRepo;
import com.idsspl.webproject.repo.AgentCollectionRepo;
import com.idsspl.webproject.repo.AgentLocationRepo;
import com.idsspl.webproject.repo.AgentRepo;
import com.idsspl.webproject.repo.CollectionInfoRepo;
import com.idsspl.webproject.repo.CustomerMobileModifyRepo;
import com.idsspl.webproject.repo.PrintAccountStatementRepo;
import com.idsspl.webproject.repo.PrintAgentCollectionRepo;
import com.idsspl.webproject.repo.UserRepo;
import com.idsspl.webproject.service.AgentService;

@Service
public class AgentServiceImpl implements AgentService {
	@Autowired
	private AgentRepo agentRepo;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private AgentCollectionRepo agentCollectionRepo;

	@Autowired
	private PrintAgentCollectionRepo printAgentCollectionRepo;

	@Autowired
	private CollectionInfoRepo collectionInfoRepo;

	@Autowired
	private CustomerMobileModifyRepo customerMobileModifyRepo;

	@Autowired
	private AgentLocationRepo agentLocationRepo;

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private PrintAccountStatementRepo PrintAccountStatementRepo;

	@Autowired
	private AccountRepo accountrepo;
	
	@Override
	public String sayHello() {
		String response = restTemplate.getForObject("http://localhost:3000/king", String.class);
		return response;
	}

	String localcustname = "",custid="";
	
	@Override
	public List<AgentModel> getAgentsList(AgentModel agent, String userName) {
		System.out.println("customerID----" + agent.getCustomerId());
		List<AgentEntity> agentEntityList = null;
//		
//		if (agent.getCustomerId().length() == 10 && !agent.getCustomerId().isEmpty()) {
//			
		agentEntityList = agentRepo.findByCustomerId(agent.getCustomerId());

		System.out.println("customerID----" + agent.getCustomerId() + "---------");
		System.out.println("customerID length----" + agent.getCustomerId().length() + "---------");

//		}

		List<AgentModel> agentModelList = new ArrayList<>();

		agentEntityList.stream().forEach(agentEntity -> {
			AgentModel agentModel = new AgentModel();
			agentModel.setAccountCode(agentEntity.getAccountCode());
			agentModel.setCustomerId(agentEntity.getCustomerId());
			agentModel.setLedgerbalance(agentEntity.getLedgerbalance());
			agentModel.setName(agentEntity.getName());
			agentModel.setAccountType(agentEntity.getAccountType());
			agentModel.setLocalLanguageName(agentEntity.getLocalLanguageName());
			agentModel.setMobile(agentEntity.getMobile());
			agentModel.setInstallmentAmount(agentEntity.getInstallmentAmount());

			// TO GET RECEIPT NO FROM USERREGISTER TABLE
			UserEntity userEntity = null;
			userEntity = userRepo.findByUserName(userName);

			long receiptNo = userEntity.getReceiptNo();
			receiptNo += 1;
			agentModel.setReceiptNo(receiptNo);

//			System.out.println("review date----" + agentEntity.getReviewDate() + "---------");
			String reviewDate = agentEntity.getReviewDate();

			if (reviewDate != null) {
				SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");

				try {
					Date date = inputFormat.parse(reviewDate);
					String outputDate = outputFormat.format(date);
					agentModel.setReviewDate(outputDate);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			agentModelList.add(agentModel);

		});

		return agentModelList;
	}

	@Override
	public String saveAgentCollection(AgentCollectionModel agentCollection, String userName) {
		System.out.println("----------------Saving Agent Collection Start--------------");
		AgentCollectionEntity newAgent = new AgentCollectionEntity();
		newAgent.setAccountCode(agentCollection.getAccountCode());
		newAgent.setAccountType(agentCollection.getAccountType());
		newAgent.setCollectionAmount(agentCollection.getCollectionAmount());
		newAgent.setCustomerId(agentCollection.getCustomerId());
		newAgent.setLedgerbalance(agentCollection.getLedgerbalance());
		newAgent.setName(agentCollection.getName());
		newAgent.setLatitude(agentCollection.getLatitude());
		newAgent.setLongitude(agentCollection.getLongitude());
		newAgent.setAgentName(userName);
		newAgent.setReceiptNo(agentCollection.getReceiptNo());
		newAgent.setPaymentMethod(agentCollection.getPaymentMethod());

		UserEntity userEntity = null;
		userEntity = userRepo.findByUserName(userName);
		newAgent.setAgentId(userEntity.getAgentId());

		///// TO GENERATE THE RANDOM UNIQUE ID
		String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuilder sb = new StringBuilder(14);
		for (int i = 0; i < 14; i++) {
			int index = random.nextInt(CHARACTERS.length());
			char randomChar = CHARACTERS.charAt(index);
			sb.append(randomChar);
		}
		String id = sb.toString();

		Date currentDate = new Date();
		SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MMM-yyyy");
		String formattedDate = outputFormat.format(currentDate);

		newAgent.setId(id);
		newAgent.setCollectionDate(formattedDate);

		System.out.println("-----------------saveAgentCollection---------------------");
		System.out.println("id----------" + id);
		System.out.println("customerId-----" + agentCollection.getCustomerId());
		System.out.println("accountCode-----" + agentCollection.getAccountCode());
		System.out.println("accountType-----" + agentCollection.getAccountType());
		System.out.println("name-----" + agentCollection.getName());
		System.out.println("ledgerbalance-----" + agentCollection.getLedgerbalance());
		System.out.println("CollectionAmount-----" + agentCollection.getCollectionAmount());
		System.out.println("latitute-----" + agentCollection.getLatitude());
		System.out.println("latitute-----" + agentCollection.getLongitude());
		System.out.println("agentName-----" + userName);
		System.out.println("agentId-----" + userEntity.getAgentId());
		System.out.println("collection date-----" + formattedDate);
		System.out.println("Receipt No-----" + agentCollection.getReceiptNo());
		System.out.println("Payment Method-----" + agentCollection.getPaymentMethod());

		try {
			String obj = "";
			if(!agentCollection.getReceiptNo().equals(obj)) {
				agentCollectionRepo.save(newAgent);
	//			userEntity.setReceiptNo(agentCollection.getReceiptNo());
    //			userRepo.save(userEntity);
				userRepo.updateReceiptNoByUserName(userName,agentCollection.getReceiptNo());
				System.out.println("----------------Saving Agent Collection END--------------");
				return "Saved Successfully";
			}else {
				System.out.println("----------------Saving Agent Collection END--------------");
				return "Error Saving Data.";
			}
		} catch (Exception e) {
			
			return "Error saving  data: " + e.getMessage();
		}
		
	}

	@Override
	public List<PrintAgentCollectionModel> getCollectionList(PrintAgentCollectionModel collection) {
		List<PrintAgentCollectionEntity> agentCollectionEntityList = null;
		System.out.println("collection date -------------" + collection.getCollectionDate());
		System.out.println("jfdlksfjsldkfjlksdjfdslkfjsdkl");
		System.out.println("print customer Id---------" + collection.getCustomerId().trim());
		System.out.println("print receipt no----------" + collection.getReceiptNo());
		agentCollectionEntityList = printAgentCollectionRepo.findByCustomerIdAndCollectionDate(
				collection.getCustomerId(), collection.getCollectionDate(), collection.getReceiptNo());
		List<PrintAgentCollectionModel> agentCollectionModelList = new ArrayList<>();

		agentCollectionEntityList.stream().forEach(collectionEntity -> {
			PrintAgentCollectionModel collectionModel = new PrintAgentCollectionModel();
			collectionModel.setAccountCode(collectionEntity.getAccountCode());
			collectionModel.setCustomerId(collectionEntity.getCustomerId());
			collectionModel.setCollectionAmount(collectionEntity.getCollectionAmount());
			collectionModel.setReceiptNo(collectionEntity.getReceiptNo());
			collectionModel.setAccountType(collectionEntity.getAccountType());
			collectionModel.setLocalLanguageName(collectionEntity.getLocalLanguageName());

			SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
			String collectionDate = collectionEntity.getCollectionDate();
			try {
				Date date = inputFormat.parse(collectionDate);
				String outputDate = outputFormat.format(date);
				System.out.println(outputDate);
				collectionModel.setCollectionDate(outputDate);
			} catch (Exception e) {
				e.printStackTrace();
			}
			agentCollectionModelList.add(collectionModel);

			System.out.println("print customer Id---------" + collectionEntity.getCustomerId());
			System.out.println("print receipt no----------" + collectionEntity.getReceiptNo());

		});

		return agentCollectionModelList;
	}

	@Override
	public List<PrintAccountStatementModel> getCollectionList(PrintAccountStatementModel collection) {
		List<AccountStatementEntity> accountStatementEntityList = null;
		System.out.println("txn date -------------" + collection.getTxndate());
		System.out.println("jfdlksfjsldkfjlksdjfdslkfjsdkl");
		System.out.println("print account code---------"+collection.getAccountCode());
//		System.out.println("print amount----------"+collection.getAmount());
//		String custid = "";
		List<AccountEntity> customeridlist = null;
		customeridlist = accountrepo.findCustAccountCode(collection.getAccountCode());
		customeridlist.stream().forEach(accountEntity -> {
			
		System.out.println("ststement ===="+accountEntity.getCustomerId());
		 custid = accountEntity.getCustomerId();
		
		});

		List<PrintAgentCollectionEntity> customernamelist = null;
		customernamelist = printAgentCollectionRepo.findByCustomerId(custid);
		
		customernamelist.stream().forEach(printAgentCollectionEntity ->{
			System.out.println("cust name=== "+printAgentCollectionEntity.getLocalLanguageName());
		localcustname = printAgentCollectionEntity.getLocalLanguageName();
		});
		
		accountStatementEntityList = PrintAccountStatementRepo.findByAccountCodeAndTxnDate(collection.getAccountCode(),collection.getTxndate());
		List<PrintAccountStatementModel> accountStatementModelList = new ArrayList<>();

		accountStatementEntityList.stream().forEach(accountcollectionEntity -> {
			PrintAccountStatementModel accountcollectionModel = new PrintAccountStatementModel();
			accountcollectionModel.setTxndate(accountcollectionEntity.getTxndate()); 
			accountcollectionModel.setTxnnumber(accountcollectionEntity.getTxnnumber());
			accountcollectionModel.setAccountCode(accountcollectionEntity.getAccountCode());
			accountcollectionModel.setParticular(accountcollectionEntity.getParticular());
			accountcollectionModel.setTransactionindicatorcode(accountcollectionEntity.getTransactionindicatorcode());
			accountcollectionModel.setAmount(accountcollectionEntity.getAmount());
			accountcollectionModel.setAccountbalance(accountcollectionEntity.getAccountbalance());

			SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
			String txndate = accountcollectionEntity.getTxndate();
			try {
				Date date = inputFormat.parse(txndate);
				String outputDate = outputFormat.format(date);
				System.out.println(outputDate);
				accountcollectionModel.setTxndate(outputDate);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
//			accountcollectionModel.se
			
//			accountStatementModelList.add(accountcollectionModel);
			
//			System.out.println("print customer Id---------"+collectionEntity.getCustomerId());
//			System.out.println("print receipt no----------"+collectionEntity.getReceiptNo());

		});

		return accountStatementModelList;
	}
	
	
	@Override
	public List<CollectionInfoModel> getCollectionInfoList(CollectionInfoModel collection, String userName) {
		List<CollectionInfoEntity> agentCollectionEntityList = null;
		UserEntity userEntity = null;

		userEntity = userRepo.findByUserName(userName);

		String agentId = userEntity.getAgentId();
		String agentName = userName;
		System.out.println("agentId in collection list----------" + agentId);
		System.out.println("agentName in collection list----------" + agentName);
//		agentCollectionEntityList = collectionInfoRepo.findByAgentId(agentId);
		agentCollectionEntityList = collectionInfoRepo.findInfoByAgentIdAndAgentName(agentId, agentName);

		List<CollectionInfoModel> agentCollectionModelList = new ArrayList<>();

		agentCollectionEntityList.stream().forEach(collectionEntity -> {
			CollectionInfoModel collectionModel = new CollectionInfoModel();
			collectionModel.setCustomerId(collectionEntity.getCustomerId());
			collectionModel.setCollectionAmount(collectionEntity.getCollectionAmount());
			collectionModel.setReceiptNo(collectionEntity.getReceiptNo());
			collectionModel.setLocalLanguageName(collectionEntity.getLocalLanguageName());
			collectionModel.setPaymentMethod(collectionEntity.getPaymentMethod());

			SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
			String collectionDate = collectionEntity.getCollectionDate();
			try {
				Date date = inputFormat.parse(collectionDate);
				String outputDate = outputFormat.format(date);
				collectionModel.setCollectionDate(outputDate);
			} catch (Exception e) {
				e.printStackTrace();
			}
			agentCollectionModelList.add(collectionModel);

			System.out.println("collectionInfo customer Id---------" + collectionEntity.getCustomerId());
			System.out.println("collectionInfo collection amount---" + collectionEntity.getCollectionAmount());
			System.out.println("collectionInfo receipt no----------" + collectionEntity.getReceiptNo());
			System.out.println("collectionInfo name----------------" + collectionEntity.getLocalLanguageName());
			System.out.println("collectionInfo payment method----------------" + collectionEntity.getPaymentMethod());
			System.out.println("collectionInfo collection date-----" + collectionDate);
		});

		return agentCollectionModelList;
	}

	@Override
	public String makeCollectionAmt0(CollectionInfoModel collection) {
		System.out.println("customerId-----" + collection.getCustomerId());
		System.out.println("name-----" + collection.getLocalLanguageName());
		System.out.println("CollectionAmount-----" + collection.getCollectionAmount());
		System.out.println("collection date-----" + collection);
		System.out.println("Receipt No-----" + collection.getReceiptNo());

		try {
			agentCollectionRepo.updateCollectionAmt(collection.getCustomerId(), collection.getReceiptNo());
			return "Success";
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}

	}

	@Override
	public List<AgentModel> getUpdateMobileCustomerList(AgentModel agent) {
		System.out.println("customerID----" + agent.getCustomerId());
		List<AgentEntity> agentEntityList = null;
		agentEntityList = agentRepo.findByCustomerIdforMobile(agent.getCustomerId());

		System.out.println("customerID----" + agent.getCustomerId() + "---------");
		System.out.println("customerID length----" + agent.getCustomerId().length() + "---------");

		List<AgentModel> agentModelList = new ArrayList<>();

		agentEntityList.stream().forEach(agentEntity -> {
			AgentModel agentModel = new AgentModel();
			agentModel.setCustomerId(agentEntity.getCustomerId());
			agentModel.setLocalLanguageName(agentEntity.getLocalLanguageName());
			agentModel.setMobile(agentEntity.getMobile());
			agentModelList.add(agentModel);

		});

		return agentModelList;
	}

	@Override
	public String updateCustomerMobileNo(CustomerMobileModifyModel customer) {
		System.out.println("customerId-----" + customer.getCustomerId());
		System.out.println("mobile-----" + customer.getMobile());
		try {
			customerMobileModifyRepo.updateCustomerMobile(customer.getCustomerId(), customer.getMobile());
			return "Successfully Updated";
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}

	}

	@Override
	public List<AgentLocationModel> getAgentLocation(AgentLocationModel agentLoc) {
		List<AgentLocationEntity> agentLocationEntityList = null;
		agentLocationEntityList = agentLocationRepo.findByAgentId(agentLoc.getAgentId());
		List<AgentLocationModel> agentLocationModel = new ArrayList<>();

		agentLocationEntityList.stream().forEach(locationEntity -> {
			AgentLocationModel agentLocModel = new AgentLocationModel();
			agentLocModel.setLatitude(locationEntity.getLatitude());
			agentLocModel.setLongitude(locationEntity.getLongitude());
			agentLocModel.setAgentId(locationEntity.getAgentId());
			agentLocModel.setAgentName(locationEntity.getAgentName());
			System.out.println("Agent id---" + locationEntity.getAgentId());
			System.out.println("Agent name---" + locationEntity.getAgentName());
			System.out.println("Agent latitude---------" + locationEntity.getLatitude());
			System.out.println("Agent longitude---" + locationEntity.getLongitude());
			agentLocationModel.add(agentLocModel);

		});
		return agentLocationModel;
	}

	@Override
	public String getMainUser(String userName) {
		UserEntity userEntity = null;
		userEntity = userRepo.findByUserName(userName);
		String isMainUser = userEntity.getIsMainAppUser();
		System.out.println("isMainUser-----" + isMainUser);
		return isMainUser;
	}

//	@Override
//	public List<AgentCollectionModel> saveAgentCollection(AgentCollectionModel agentCollection) {
//
//		List<AgentCollectionModel> agentModelList = new ArrayList<>();
//
//		agentEntityList.stream().forEach(agentEntity -> {
//			AgentModel agentModel = new AgentModel();
//			agentModel.setAccountCode(agentEntity.getAccountCode());
//			agentModel.setCustomerId(agentEntity.getCustomerId());
//			agentModel.setLedgerbalance(agentEntity.getLedgerbalance());
//			agentModel.setName(agentEntity.getName());
//			agentModel.setAccountType(agentEntity.getAccountType());
//			agentModelList.add(agentModel);
//
//		});
//
//		return agentModelList;
//	}
}
