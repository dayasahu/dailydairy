package com.dailydairy.delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dailydairy.delivery.entity.Customer;

import com.dailydairy.delivery.service.CustomerService;

@RestController
@RequestMapping("dailydairyRest")
public class CustomerAPIController {

	@Autowired
	private CustomerService customerService;

	
	@GetMapping("/getallcustomers")
	public Iterable<Customer> getCustomers() {
		return customerService.findAll();

	}

	@GetMapping("/findcustomer/{id}")
	public Customer getCustomer(@PathVariable Long id) {
		return customerService.find(id);

	}

	@PostMapping("/addNewcustomer")
	public String addCustomer(@RequestBody Customer customer) {
		customer.setIsActive("Y");
		customerService.save(customer);
		return "New Customer Added Successfully";

	}

	@PutMapping("/updateCustomer")
	public String updateCustomer(@RequestBody Customer customer) {
		customerService.save(customer);
		return "Customer Detail updated Successfully";

	}
	
	@DeleteMapping("/deactivateCustomers/{id}")
	public String deleteCustomer(@PathVariable Long id) {
		Customer cust= customerService.find(id);
		cust.setIsActive("N");
		customerService.save(cust);
		return "Customer Deleted Successfully";

	}

}
