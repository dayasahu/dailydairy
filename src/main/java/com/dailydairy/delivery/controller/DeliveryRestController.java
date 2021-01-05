package com.dailydairy.delivery.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeliveryRestController {

	@GetMapping
	public String testService() {
		
		return "This is dairy delivery app" ;
	}
}
