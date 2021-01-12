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


import com.dailydairy.delivery.entity.Query;

import com.dailydairy.delivery.service.QueryService;

@RestController
@RequestMapping("dailydairyRest")
public class QueryAPIController {

	@Autowired
	private QueryService service;

	
	@GetMapping("/getAllqueries")
	public Iterable<Query> getQueries() {
		return service.findAll();

	}

	@GetMapping("/findQuery/{id}")
	public Query getQuery(@PathVariable Long id) {
		return service.find(id);

	}

	@PostMapping("/addNewQuery")
	public String addQuery(@RequestBody Query query) {
		query.setIsActive("Y");
		service.save(query);
		return "New Customer Added Successfully";

	}

	@PutMapping("/updateQuery")
	public String updateQuery(@RequestBody Query query) {
		service.save(query);
		return "Customer Detail updated Successfully";

	}
	
	@DeleteMapping("/deActivateQuery/{id}")
	public String deleteQuery(@PathVariable Long id) {
		Query cust= service.find(id);
		cust.setIsActive("N");
		service.save(cust);
		return "Customer Deleted Successfully";

	}
}
