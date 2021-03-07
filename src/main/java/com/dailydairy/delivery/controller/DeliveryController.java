package com.dailydairy.delivery.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@PostMapping("/addUpdateCustomerDelivery")
	public String addDelivery(DailyDelivery dailyOrder) {
		
		 service.saveDailyDelivery(dailyOrder);
		 return "SUCCESS";

	}
	
	@PostMapping("/addUpdateRouteDelivery")
	public String addrouteDelivery(RouteDelivery routeDelivery) {
		
		 service.saveRouteDelivery(routeDelivery);
		 return "SUCCESS";

	}
	


	@GetMapping("/getCustomerDelivery")
	public List<DailyDelivery> getCustomerDelivery(@RequestParam(required = false)  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,@RequestParam(required = false)  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,@RequestParam(required = false) String routeId) {
		
		if(startDate!=null && endDate!=null) {
			return service.getAllDailyDeliveryByRange(startDate,endDate);
		}else if(routeId!=null) {
			return service.getAllDailyDeliveryByRouteId(routeId);	
		}
		return service.getAllDailyDelivery();
		
		
	}
	
	
	@GetMapping("/getRouteDelivery")
	public List<RouteDelivery> getRouteDelivery(@RequestParam(required = false)  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,@RequestParam(required = false)  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,@RequestParam(required = false) String routeId) {
		
			if(startDate!=null && endDate!=null) {
			return service.getAllRouteDeliveryByRange(startDate,endDate);
		}
		else if(routeId!=null) {
			return service.getAllRouteDeliveryByRouteId(routeId);	
		}
		return service.getAllRouteDelivery();
		
		
	}
	
	@GetMapping("/getTodayToBeDelivered")
	public CustomerDeliveryList getTodayDelivery() {
		return service.findCustomerSubscription();
		
	}
	
	@GetMapping("/getTodayDelivered")
	public List<DailyDelivery> getTodayDelivered(@RequestParam(required = false) String routeId) {
		if(routeId!=null) {
			return service.getTodayCompletedDeliveriesbyRouteId(routeId);
		}
		return service.getTodayCompletedDeliveries();
		
	}
}
