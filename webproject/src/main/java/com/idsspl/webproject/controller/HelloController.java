package com.idsspl.webproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	 @GetMapping(path = "/getUserName") 
		public String sayHello() {
		 return "abhishek";
	 }
	
}
