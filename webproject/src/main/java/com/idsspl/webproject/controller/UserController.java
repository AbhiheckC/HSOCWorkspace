package com.idsspl.webproject.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.idsspl.webproject.entity.AgentEntity;
import com.idsspl.webproject.model.AccountModel;
import com.idsspl.webproject.model.AgentCollectionModel;
import com.idsspl.webproject.model.AgentLocationModel;
import com.idsspl.webproject.model.AgentModel;
import com.idsspl.webproject.model.CollectionInfoModel;
import com.idsspl.webproject.model.CustomerMobileModifyModel;
import com.idsspl.webproject.model.CustomerModel;
import com.idsspl.webproject.model.MemberModel;
import com.idsspl.webproject.model.PrintAccountStatementModel;
import com.idsspl.webproject.model.PrintAgentCollectionModel;
import com.idsspl.webproject.model.RequestModel;
import com.idsspl.webproject.model.UserModel;
import com.idsspl.webproject.repo.AgentRepo;
import com.idsspl.webproject.repo.UserRepo;
import com.idsspl.webproject.service.AccountService;
import com.idsspl.webproject.service.AgentService;
import com.idsspl.webproject.service.MemberService;
import com.idsspl.webproject.serviceImpl.UserServiceImpl;

@Controller
public class UserController {

	@Autowired
	private AgentService agentService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private AccountService accountService;

	// TO GET THE USERNAME OF THE USER LOGIN TO DISPLAY AND USE IN ALL THE ROUTES
	@ModelAttribute("userName")
	public String addUserNameToModel(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null && authentication.isAuthenticated()) {
			return authentication.getName();
		}
		return null;
	}

	// GET LOGIN PAGE
//	@GetMapping(path = "/login")
//	public String GetLoginForm(Model model) {
//		model.addAttribute("loginError", true);
//		return "Login";
//	}

	@GetMapping(path = "/login")
	public String GetLoginForm(Model model, @RequestParam(name = "expired", required = false) String expired,
			@RequestParam(name = "timeout", required = false) String timeout,
			@RequestParam(name = "error", required = false) String error) {
		if (expired != null) {
			model.addAttribute("loginError", true);
			model.addAttribute("errorMessage", "Your session has expired. Please log in again.");
		} else if (timeout != null) {
			model.addAttribute("loginError", true);
			model.addAttribute("errorMessage", "Your session has timed out. Please log in again.");
		} else if (error != null) {
			model.addAttribute("loginError", true);
			model.addAttribute("errorMessage", "Invalid Username or Password!");
		}
		return "Login";
	}

	// TO GET ERROR PAGE
	@GetMapping(path = "/logout")
	public String Logout(Model model) {
		return "redirect:/";
	}

	// SET DEFAULT PAGE AS LOGIN
	@GetMapping(path = "/")
	public String GetDefaultPage(Model model) {
		return "redirect:/login";
	}

	// TO GET ERROR PAGE
	@GetMapping(path = "/error")
	public String ErrorPage(Model model) {
		return "Error";
	}

	// TO GET HOME PAGE
	@GetMapping(path = "/home")
	public String HomePage(Model model) {
		return "Home";
	}

//	// TO GET HOME PAGE
//	@GetMapping(path = "/home")
//	public String HomePage(Model model, Authentication authentication) {
//		String userName = authentication.getName();
//		model.addAttribute("userName", userName);
//		return "Home";
//	}

	// TO GET VIEW AGENT PAGE
	@GetMapping(path = "/viewAgent")
	public String GetViewAgentPage(Model model) {
		return "ViewAgent";
	}

	// TO GET AGENT LIST ON VIEW AGENT PAGE
	@PostMapping(path = "/viewAgentList")
	public String PostViewAgentPage(AgentModel agent, Model model, Authentication authentication) {
		List<AgentModel> agents;
		String userName = authentication.getName();

		agents = agentService.getAgentsList(agent, userName);
		System.out.println("agent======" + agents);
		if (agents == null || agents.isEmpty()) {
			String isDataMissing = "No data Found!";
			model.addAttribute("isDataMissing", isDataMissing);
		} else if (agents != null || !agents.isEmpty()) {
			System.out.println("--------------" + agents.get(0));
			model.addAttribute("agentList", agents);
		}
		return "ViewAgent";
	}

	@PostMapping(path = "/saveCollection")
	public String updateAgent(@ModelAttribute("agentCollectionList") AgentCollectionModel agentCollectionList,
			BindingResult bindingResult, Model model, Authentication authentication) {
		if (bindingResult.hasErrors()) {
			return "redirect:/home";
		}
		String userName = authentication.getName();
		String result = agentService.saveAgentCollection(agentCollectionList, userName);
		model.addAttribute("isCollectionSaved", result);
		System.out.println("result===============" + result);
		return "ViewAgent";
	}

//	@PostMapping(path = "/addGuarantor")
//	public String AddGuarantorPage(@ModelAttribute AddGuarantorListDto customerGuarantorList,
//			BindingResult bindingResult, Model model, Authentication authentication) {
//		if (bindingResult.hasErrors()) {
//			return "redirect:/home";
//		}
//		
////		for (AgentCollectionModel agentCollectionModel : form.getAgentCollectionList()) {
////			System.out.println("===== customer id = " + agentCollectionModel.getCustomerId());
////			System.out.println("accountCode = " + agentCollectionModel.getAccountCode());
////			System.out.println("collection amt = " + agentCollectionModel.getCollectionAmount());
////			System.out.println("date = " + agentCollectionModel.getReviewDate());
////			System.out.println("balance = " + agentCollectionModel.getLedgerbalance());
////		}
//		for (CustomerGuarantorModel ele : customerGuarantorList.getAddGuarantorList()) {
//			System.out.println("customerGuarantorList accountCode----"+ele.getAccountCode());
//			System.out.println("customerGuarantorList serialNumber----"+ele.getSerialNumber());
//			System.out.println("customerGuarantorList customerId----"+ele.getCustomerId());
//			System.out.println("customerGuarantorList name----"+ele.getName());
//			System.out.println("customerGuarantorList address----"+ele.getAddress());
//			System.out.println("customerGuarantorList dateofbirth----"+ele.getDateofbirth());
//			System.out.println("customerGuarantorList phonenumber----"+ele.getPhonenumber());
//			System.out.println("customerGuarantorList mobilenumber----"+ele.getMobilenumber());
//			System.out.println("customerGuarantorList stateCode----"+ele.getStateCode());
//			System.out.println("customerGuarantorList cityCode----"+ele.getCityCode());
//			System.out.println("customerGuarantorList countryCode----"+ele.getCountryCode());
//			System.out.println("customerGuarantorList zip----"+ele.getZip());
//		}
////		String result = customerService.saveCustomerGuarantor(customerGuarantorList);
////		model.addAttribute("isCollectionSaved", result);
////		System.out.println("result===============" + result);
//		return "AddGuarantor";
//	}

	// TO GET VIEW AGENT PAGE
	@GetMapping(path = "/viewMember")
	public String GetViewMemberPage(Model model) {
		return "ViewMember";
	}

	@PostMapping(path = "/viewMemberList")
	public String PostViewMemberPage(MemberModel member, Model model, Authentication authentication) {
		List<MemberModel> members;
		members = memberService.getMemberList(member);
		System.out.println("member======" + members);
		if (members == null || members.isEmpty()) {
			String isDataMissing = "No data Found!";
			model.addAttribute("isDataMissing", isDataMissing);
		} else if (members != null || !members.isEmpty()) {
			System.out.println("--------------" + members.get(0));
			model.addAttribute("memberList", members);
		}
		return "ViewMember";
	}

	
	 @PostMapping(path = "/viewclient")
		public String PostViewMemberPage(RequestModel resmodel,Authentication authentication) {
			
	    	System.out.println("member===="+resmodel);
	    	
			return "hello";
		}
	
	
//	@PostMapping(path = "/saveCollection")
//	public ResponseEntity<Map<String, String>> updateAgent(@ModelAttribute("agentCollectionList") AgentCollectionModel agentCollectionList,
//			BindingResult bindingResult, Model model, Authentication authentication) {
////		if (bindingResult.hasErrors()) {
////			return "redirect:/home";
////		}
//		String userName = authentication.getName();
//		String result = agentService.saveAgentCollection(agentCollectionList, userName);
//		model.addAttribute("isCollectionSaved", result);
//		System.out.println("result===============" + result);
//		Map<String, String> responseMap = new HashMap();
//	    if (result.equals("Saved Successfully")) {
//	        responseMap.put("status", "success");
//	        responseMap.put("message", "Data saved successfully.");
//	    } else {
//	        responseMap.put("status", "error");
//	        responseMap.put("message", "Error saving data: " + result);
//	    }
//
//	    return ResponseEntity.ok(responseMap);
//	}

	// TO GET VIEW AGENT PAGE
//	@GetMapping(path = "/viewCustomer")
//	public String GetViewCustomerPage(Model model) {
//		return "ViewCustomer";
//	}
//
//	@PostMapping(path = "/viewCustomerInfo")
//	public String GetViewCustomerInfo(CustomerModel customer, Model model) {
//		List<CustomerModel> customers;
//		customers = customerService.getCustomerList(customer);
//		if (customers == null || customers.isEmpty()) {
//			String isDataMissing = "No data Found!";
//			model.addAttribute("isDataMissing", isDataMissing);
//		} else if (customers != null || !customers.isEmpty()) {
//			model.addAttribute("customerList", customers);
//		}
//		return "ViewCustomer";
//	}

	// TO GET VIEW AGENT PAGE
	@GetMapping(path = "/printCollection")
	public String GetPrintCollectionPage(Model model) {
		return "PrintCollection";
	}

	@PostMapping(path = "/printCollectionList")
	public String PostPrintCollectionPage(PrintAgentCollectionModel collection, Model model,
			Authentication authentication) {
		List<PrintAgentCollectionModel> collections;
		collections = agentService.getCollectionList(collection);
		System.out.println("collections======" + collections);
		if (collections == null || collections.isEmpty()) {
			String isDataMissing = "No data Found!";
			model.addAttribute("isDataMissing", isDataMissing);
		} else if (collections != null || !collections.isEmpty()) {
			System.out.println("--------------" + collections.get(0));
			model.addAttribute("collectionList", collections);
		}
		return "PrintCollection";
	}

	
	// TO GET VIEW STATEMENT PAGE
		@GetMapping(path = "/viewAccountStatement")
		public String GetAccountStatementPage(Model model) {
			return "viewAccountStatement";
		}
		
		@PostMapping(path = "/printAccountStatement")
		public String PostPrintAccountStmtPage(PrintAccountStatementModel collection, Model model,
				Authentication authentication) {
			List<PrintAccountStatementModel> collections;
			collections = agentService.getCollectionList(collection);
			System.out.println("collections======" + collections);
			if (collections == null || collections.isEmpty()) {
				String isDataMissing = "No data Found!";
				model.addAttribute("isDataMissing", isDataMissing);
			} else if (collections != null || !collections.isEmpty()) {
				System.out.println("--------------" + collections.get(0));
				model.addAttribute("AccountcollectionList", collections);
			}
			return "viewAccountStatement";
		}
	
	
	
	// TO GET VIEW COLLECTION INFORMATION PAGE
	@GetMapping(path = "/viewCollectionInfo")
	public String GetCollectionInfoPage(Model model) {
		return "CollectionInfo";
	}

	@PostMapping(path = "/getCollectionInfo")
	public String PostCollectionInfoPage(CollectionInfoModel collection, Model model, Authentication authentication) {
		List<CollectionInfoModel> collections;
		String userName = authentication.getName();
		collections = agentService.getCollectionInfoList(collection, userName);
		System.out.println("collections======" + collections);
		if (collections == null || collections.isEmpty()) {
			String isDataMissing = "No data Found!";
			model.addAttribute("isDataMissing", isDataMissing);
		} else if (collections != null || !collections.isEmpty()) {
			System.out.println("--------------" + collections.get(0));
			model.addAttribute("collectionList", collections);
		}
		return "CollectionInfo";
	}

	@PostMapping(path = "/makeCollection0")
	public String PostMakeCollection0(@RequestParam(value = "checkbox", required = false) Long selectedItems,
			@ModelAttribute("collectionInfoList") CollectionInfoModel collection, Model model,
			Authentication authentication) {
		String result = "";
		if (selectedItems != null) {
			System.out.println("selected Items-----" + selectedItems);
			result = agentService.makeCollectionAmt0(collection);
			model.addAttribute("isCollectionSaved", result);
		}
		return "CollectionInfo";
	}

	// TO GET AGENT LIST ON VIEW CUSTOMER MOBILE MODIFY PAGE
	@GetMapping(path = "/viewCustomerMobileModify")
	public String GetCustomerMobileModifyPage(Model model) {
		return "CustomerMobileModify";
	}

	// TO GET CUSTOMER MOBILE MODIFY LIST PAGE
	@PostMapping(path = "/viewCustomerMobileModifyList")
	public String PostViewCustomerMobileModifyPage(AgentModel agent, Model model) {
		List<AgentModel> agents;
		agents = agentService.getUpdateMobileCustomerList(agent);
		System.out.println("customer======" + agents);
		if (agents == null || agents.isEmpty()) {
			String isDataMissing = "No data Found!";
			model.addAttribute("isDataMissing", isDataMissing);
		} else if (agents != null || !agents.isEmpty()) {
			System.out.println("--------------" + agents.get(0));
			model.addAttribute("agentList", agents);
		}
		return "CustomerMobileModify";
	}

	// TO MODIFY CUSTOMER MOBILE DETAILS
	@PostMapping(path = "/modifyCustomerMobile")
	public String PostModifyCustomerMobile(@ModelAttribute("collectionMobileList") CustomerMobileModifyModel customer,
			Model model, Authentication authentication) {
		String result = "";
		result = agentService.updateCustomerMobileNo(customer);
		model.addAttribute("isMobileUpdate", result);
		return "CustomerMobileModify";
	}

	// TO GET VIEW AGENT LOCATION PAGE
	@GetMapping(path = "/viewAgentLocation")
	public String GetAgentLocationPage(Model model, Authentication authentication, RedirectAttributes redirAttr) {
		String userName = authentication.getName();
		String isMainUser = agentService.getMainUser(userName);

		if (isMainUser.equals("N")) {
//			model.addAttribute("isMainUser", "it's not accessible");
			redirAttr.addFlashAttribute("isMainUser", "it's not accessible");
			return "redirect:/home";
		}
		return "AgentLocation";
	}

	// TO GET CUSTOMER MOBILE MODIFY LIST PAGE
	@PostMapping(path = "/getAgentLocation")
	public String PostAgentLocationPage(AgentLocationModel agentLoc, Model model) {
		List<AgentLocationModel> agentLocations;
		agentLocations = agentService.getAgentLocation(agentLoc);
		System.out.println("agentLocations======" + agentLocations);
		if (agentLocations == null || agentLocations.isEmpty()) {
			String isDataMissing = "No data Found!";
			model.addAttribute("isDataMissing", isDataMissing);
		} else if (agentLocations != null || !agentLocations.isEmpty()) {
			System.out.println("--------------" + agentLocations.get(0));
			model.addAttribute("agentLocations", agentLocations);
		}
		return "AgentLocation";
	}

//	@PostMapping(path = "/saveCollection")
//	public String updateAgent(@ModelAttribute("agentCollectionList") ArrayList<AgentCollectionModel> agentCollectionList,
//			BindingResult bindingResult) {
//		if (bindingResult.hasErrors()) {
//			return "redirect:/home";
//		}
////		System.out.println("customerId-----" + agentList.getCustomerId());
////		System.out.println("accountCode-----" + agentList.getAccountCode());
////		System.out.println("accountType-----" + agentList.getAccountType());
////		System.out.println("name-----" + agentList.getName());
////		System.out.println("ledgerbalance-----" + agentList.getLedgerbalance());
////		System.out.println("ColletionAmount-----" + agentList.getCollectionAmount());
//
//		for (AgentCollectionModel agent : agentCollectionList) {
//
//			System.out.println("customerId-----" + agent.getCustomerId());
//			System.out.println("accountCode-----" + agent.getAccountCode());
//			System.out.println("accountType-----" + agent.getAccountType());
//			System.out.println("name-----" + agent.getName());
//			System.out.println("ledgerbalance-----" + agent.getLedgerbalance());
//			System.out.println("ColletionAmount-----" + agent.getCollectionAmount());
//		}
//		return "redirect:/viewAgent";
//	}

	@GetMapping(path = "/hello")
	public String sayHello(Model model) {
		String username = agentService.sayHello();
		model.addAttribute("username", username);
		return "hello";
	}
}
