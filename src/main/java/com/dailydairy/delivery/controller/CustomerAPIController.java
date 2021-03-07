package com.dailydairy.delivery.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dailydairy.delivery.entity.Customer;
import com.dailydairy.delivery.entity.Vacation;
import com.dailydairy.delivery.service.CustomerService;

@RestController
@RequestMapping("dailydairyRest")
public class CustomerAPIController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/findcustomers")
	public List<Customer> getCustomer(@RequestParam(required = false) Long routeId,
			@RequestParam(required = false) Long customerid) {

		if (customerid != null) {
			List<Customer> customers = new ArrayList<Customer>();
			customers.add(customerService.find(customerid));
			return customers;
		}
		if (routeId != null) {
			return customerService.findByRouteId(routeId);
		} else {
			return customerService.findAll();
		}

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
		Customer cust = customerService.find(id);
		cust.setIsActive("N");
		customerService.save(cust);
		return "Customer Deleted Successfully";

	}

	@PostMapping("/addVacation")
	public String setVacation(@RequestBody Vacation vacation) {
		customerService.saveVacation(vacation);
		return "vacation added successfully";

	}

	@GetMapping("/getCustVacation/{custId}")
	public List<Vacation> getVacation(@PathVariable String custId) {

		return customerService.findVacation(custId);

	}

	@GetMapping("/getTodayVacation")
	public List<Vacation> getTodayVacation() {

		return customerService.findTodayVacation();

	}

	@GetMapping("/getAllVacation")
	public List<Vacation> getAllVacation() {
		return customerService.findAllVacation();

	}

}
