package com.dailydairy.delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dailydairy.delivery.entity.Customer;
import com.dailydairy.delivery.exception.CustomerNotFoundException;
import com.dailydairy.delivery.repo.CustomerRepo;

@RestController
@RequestMapping("dailydairyRest")
public class DeliveryRestController {
	

@Autowired
private  CustomerRepo customerRepo;
	
	@GetMapping("/test")
	public String testService() {
		
		return "This is dairy delivery app" ;
	}
	
	@GetMapping("/customers")
	public Iterable<Customer>  getCustomers() {
		return customerRepo.findAll();
	
	}
	
	@GetMapping("/customers/{id}")
	public Customer  getCustomer(@PathVariable Long id) {
		 return customerRepo.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
	
	}
	
	@PostMapping("/customers")
	public String  addCustomer(@RequestBody Customer customer) {
		 customerRepo.save(customer);
		return "New Customer Added Successfully" ;
		 
	
	}
	
}
