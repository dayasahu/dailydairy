package com.dailydairy.delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dailydairy.delivery.entity.Customer;
import com.dailydairy.delivery.model.LoginRequest;
import com.dailydairy.delivery.repo.CustomerRepo;
import com.dailydairy.delivery.service.CustomerService;

@RestController
@RequestMapping("dailydairyRest")
public class LoginController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest req) {
		
		String userId=req.getLoginId();
		String pwd=req.getPwd();
		
		Customer cust=	customerService.findByPhoneNum(userId);
	
		String pwdFound=cust.getPwd();
		if(pwdFound.equals(pwd)) {
			 return new ResponseEntity<>(
					 cust, 
			          HttpStatus.OK);	
			
		}
		else {
			 return new ResponseEntity<>(
			          "Invalid Password", 
			          HttpStatus.UNAUTHORIZED);	
		}
	}

}
