package com.dailydairy.delivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dailydairy.delivery.entity.DailyOrder;
import com.dailydairy.delivery.entity.Query;
import com.dailydairy.delivery.service.DailyDeliveryService;

@RestController
@RequestMapping("dailydairyRest")
public class DeliveryController {

	@Autowired
	DailyDeliveryService service;
	@GetMapping("/startDailyDelivery")
	public String startDailyDelivery(DailyOrder dailyOrder) {
		 service.save(dailyOrder);
		 return "SUCCESS";

	}
}
