package com.dailydairy.delivery.controller;

import java.time.LocalDate;
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
	


	@PostMapping("/getCustomerDelivery")
	public List<DailyDelivery> getDeliveriesByFilter(@RequestBody DeliveryFilter filter) {
		
		if(filter.getStartDate()!=null && filter.getEndDate()!=null) {
			return service.getAllDailyDeliveryByRange(filter.getStartDate(),filter.getEndDate());
		}else if(filter.getRouteId()!=null) {
			return service.getAllDailyDeliveryByRouteId(filter.getRouteId());	
		}
		return service.getAllDailyDelivery();
		
		
	}
	
	
	@PostMapping("/getRouteDelivery")
	public List<RouteDelivery> getAllRouteDelivery(@RequestBody DeliveryFilter filter) {
		if(filter.getStartDate()!=null && filter.getEndDate()!=null) {
			return service.getAllRouteDeliveryByRange(filter.getStartDate(),filter.getEndDate());
		}
		else if(filter.getRouteId()!=null) {
			return service.getAllRouteDeliveryByRouteId(filter.getRouteId());
		}
		return service.getAllRouteDelivery();
		
		
	}
	
	@GetMapping("/getTodayToBeDelivered")
	public CustomerDeliveryList getTodayDelivery() {
		return service.findCustomerSubscription();
		
	}
}
