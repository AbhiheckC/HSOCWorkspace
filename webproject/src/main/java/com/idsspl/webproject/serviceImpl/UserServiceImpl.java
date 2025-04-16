package com.idsspl.webproject.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestTemplate;

import com.idsspl.webproject.entity.AgentEntity;
import com.idsspl.webproject.entity.UserEntity;
import com.idsspl.webproject.model.AgentModel;
import com.idsspl.webproject.model.UserModel;
import com.idsspl.webproject.repo.AgentRepo;
import com.idsspl.webproject.repo.UserRepo;

public class UserServiceImpl implements UserDetailsService {
	@Autowired
	private UserRepo userRepo;
	
	@Override
//	@Transactional
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		UserEntity user = userRepo.findByUserName(userName);
		System.out.println("user--------"+user);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        System.out.println("user---------" + user.getUserName() + "   " + user.getPassword());
        return new UserModel(user);
	}
	

	@ControllerAdvice
	public class ExceptionHandlerAdvice {
		@ExceptionHandler(UsernameNotFoundException.class)
		public String handleUsernameNotFoundException(UsernameNotFoundException ex, Model model) {
			model.addAttribute("king", "Invalid Username or Password");
			return "Login";
		}
	}

//	///////// METHOD TO LOGIN THE USER
//	public UserModel userLoginCheck(UserModel userModel) {
//
//		UserEntity user = null;
//
//		if (userModel.getUserName() != null) {
//			Optional<UserEntity> userData = userRepo.findByUserName(userModel.getUserName());
//			
//			System.out.println("username--------" + userModel.getUserName());
//			if (userData.isPresent()) {
//				user = userData.get();
//			}
//		}
//
//		if (user == null || user.getPassword() == null) {
//			userModel.setErrorMessage("User Does not Exists!");
//			userModel.setErrorCode("01");
//		} else if (user.getPassword() != null && !user.getPassword().equals(userModel.getPassword())) {
//			userModel.setErrorMessage("Username or Password is invalid");
//			userModel.setErrorCode("01");
//			System.out.println("password--------" + user.getPassword());
//		} else {
//			userModel.setErrorCode("00");
//			userModel.setErrorMessage("Login Successfully");
//		}
//		return userModel;
//	}

}
