package com.dailydairy.delivery.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailydairy.delivery.entity.DailyDelivery;
import com.dailydairy.delivery.entity.RouteDelivery;
import com.dailydairy.delivery.repo.DailyDeliveryRepo;
import com.dailydairy.delivery.repo.RouteDeliveryRepo;


@Service
@Transactional
public class DailyDeliveryService {

	
	@Autowired
	private DailyDeliveryRepo dailydeliveryrepo;
	
	@Autowired
	private RouteDeliveryRepo routeDeliveryRepo;

	public void saveDailyDelivery(DailyDelivery dailydelivery) {
		dailydeliveryrepo.save(dailydelivery);
	}
	
	public void saveRouteDelivery(RouteDelivery routeDelivery) {
		routeDeliveryRepo.save(routeDelivery);
	}
	
	public List<RouteDelivery> getAllRouteDelivery(){
		return routeDeliveryRepo.findAll();
	}
	
	public List<DailyDelivery> getAllDailyDelivery(){
		return dailydeliveryrepo.findAll();
	}

}
