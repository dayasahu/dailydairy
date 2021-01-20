package com.dailydairy.delivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dailydairy.delivery.entity.Route;
import com.dailydairy.delivery.entity.Society;
import com.dailydairy.delivery.service.RouteService;

@RestController
@RequestMapping("dailydairyRest")
public class RouteController {

	@Autowired
	private RouteService routeservice;

	@GetMapping("/getAllroutes")
	public List<Route> getRoutes() {
		return routeservice.findAllRoutes();

	}

	@GetMapping("/findRoute/{id}")
	public Route getRoute(@PathVariable Long id) {
		return routeservice.findRoute(id);

	}

	@PostMapping("/addNewRoute")
	public String addQuery(@RequestBody Route route) {
		route.setIsActive("Y");
		routeservice.saveRoute(route);
		return "New Route Added Successfully";

	}

	@PutMapping("/updateRoute")
	public String updateRoute(@RequestBody Route route) {
		routeservice.saveRoute(route);
		return "Route Detail updated Successfully";

	}

	@DeleteMapping("/deActivateRoute/{id}")
	public String deleteRoute(@PathVariable Long id) {
		Route route = routeservice.findRoute(id);
		route.setIsActive("N");
		routeservice.saveRoute(route);
		return "Route Deleted Successfully";

	}

	// Society

	@GetMapping("/getAllsociety")
	public List<Society> getSociety() {
		return routeservice.findAllSociety();

	}

	@GetMapping("/findSociety/{id}")
	public Society getSociety(@PathVariable Long id) {
		return routeservice.findSociety(id);

	}

	@PostMapping("/addNewSociety")
	public String addQuery(@RequestBody Society route) {
		route.setIsActive("Y");
		routeservice.saveSociety(route);
		return "New Society Added Successfully";

	}

	@PutMapping("/updateSociety")
	public String updateRoute(@RequestBody Society society) {
		routeservice.saveSociety(society);
		return "Society Detail updated Successfully";

	}

	@DeleteMapping("/deActivateSociety/{id}")
	public String deleteSociety(@PathVariable Long id) {
		Society society = routeservice.findSociety(id);
		society.setIsActive("N");
		routeservice.saveSociety(society);
		return "society Deleted Successfully";

	}
}
