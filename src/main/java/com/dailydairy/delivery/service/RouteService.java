package com.dailydairy.delivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dailydairy.delivery.entity.Route;
import com.dailydairy.delivery.entity.Society;
import com.dailydairy.delivery.exception.NotRecordFoundException;
import com.dailydairy.delivery.repo.RouteRepo;
import com.dailydairy.delivery.repo.SocietyRepo;

public class RouteService {

	@Autowired
	private RouteRepo routeRepo;

	@Autowired
	private SocietyRepo socRepo;

	// Route Service
	public List<Route> findAllRoutes() {
		return routeRepo.findAll();
	}

	public void saveRoute(Route route) {
		routeRepo.save(route);
	}

	public Route findRoute(Long id) {
		return routeRepo.findById(id).orElseThrow(() -> new NotRecordFoundException(id));
	}

	public void deleteRoute(Long id) {
		routeRepo.deleteById(id);
	}

	// Society Service
	public List<Society> findAllSociety() {
		return socRepo.findAll();
	}

	public void saveSociety(Society route) {
		socRepo.save(route);
	}

	public Society findSociety(Long id) {
		return socRepo.findById(id).orElseThrow(() -> new NotRecordFoundException(id));
	}

	public void deleteSociety(Long id) {
		socRepo.deleteById(id);
	}

}
