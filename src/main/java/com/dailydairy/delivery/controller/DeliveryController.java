package com.dailydairy.delivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dailydairy.delivery.entity.DailyDelivery;
import com.dailydairy.delivery.entity.RouteDelivery;
import com.dailydairy.delivery.model.CustomerDeliveryList;
import com.dailydairy.delivery.model.DeliveryFilter;
import com.dailydairy.delivery.service.DailyDeliveryService;

@RestController
@RequestMapping("dailydairyRest")
public class DeliveryController {

	@Autowired
	DailyDeliveryService service;
	
	@PostMapping("/markDelivery")
	public String addDelivery(DailyDelivery dailyOrder) {
		 service.saveDailyDelivery(dailyOrder);
		 return "SUCCESS";

	}
	
	@PostMapping("/routeDelivery")
	public String addrouteDelivery(RouteDelivery routeDelivery) {
		 service.saveRouteDelivery(routeDelivery);
		 return "SUCCESS";

	}
	
	@PostMapping("/startDailyDelivery")
	public String startRouteDelivery(DailyDelivery dailyOrder) {
		 service.saveDailyDelivery(dailyOrder);
		 return "SUCCESS";

	}
	
	

	@PostMapping("/getCustomerDeliveries")
	public List<DailyDelivery> getDeliveriesByFilter(@RequestBody DeliveryFilter range) {
		
		if(range.getStartDate()!=null && range.getEndDate()!=null) {
			return service.getAllDailyDeliveryByRange(range.getStartDate(),range.getEndDate());
		}else {
		return service.getAllDailyDelivery();
		}
		
	}
	
	
	@GetMapping("/getAllRouteDelivery")
	public List<RouteDelivery> getAllRouteDelivery(@RequestBody DeliveryFilter range) {
		if(range.getStartDate()!=null && range.getEndDate()!=null) {
			return service.getAllRouteDeliveryByRange(range.getStartDate(),range.getEndDate());
		}
		else {
		return service.getAllRouteDelivery();
		}
		
	}
	
	@GetMapping("/getTodayToBeDelivered")
	public CustomerDeliveryList getTodayDelivery() {
		return service.findCustomerSubscription();
		
	}
}
