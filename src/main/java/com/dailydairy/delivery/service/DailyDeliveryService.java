package com.dailydairy.delivery.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailydairy.delivery.entity.DailyOrder;
import com.dailydairy.delivery.repo.DailyOrderRepo;


@Service
@Transactional
public class DailyDeliveryService {

	
	@Autowired
	private DailyOrderRepo repo;

	public void save(DailyOrder dailyOrder) {
		repo.save(dailyOrder);
	}

}
