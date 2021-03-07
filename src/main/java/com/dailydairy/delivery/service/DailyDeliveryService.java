package com.dailydairy.delivery.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.dailydairy.delivery.constant.Constant;
import com.dailydairy.delivery.entity.DailyDelivery;
import com.dailydairy.delivery.entity.RouteDelivery;
import com.dailydairy.delivery.entity.Vacation;
import com.dailydairy.delivery.model.CustomerDeliveryList;
import com.dailydairy.delivery.model.CustomerSubscr;
import com.dailydairy.delivery.repo.DailyDeliveryRepo;
import com.dailydairy.delivery.repo.RouteDeliveryRepo;

@Service
@Transactional
public class DailyDeliveryService {

	@Autowired
	private DailyDeliveryRepo dailydeliveryrepo;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private CustomerService customerservice;

	@Autowired
	private RouteDeliveryRepo routeDeliveryRepo;

	public void saveDailyDelivery(DailyDelivery dailydelivery) {
		dailydeliveryrepo.save(dailydelivery);
	}

	public void saveRouteDelivery(RouteDelivery routeDelivery) {
		routeDeliveryRepo.save(routeDelivery);
	}

	public List<RouteDelivery> getAllRouteDelivery() {
		return routeDeliveryRepo.findAll();
	}
	
	public List<RouteDelivery>  getAllRouteDeliveryByRange(LocalDate startDate,LocalDate endDate) {
		return routeDeliveryRepo.findAllBydeliveryDateBetween(startDate, endDate);
	}
	
	public List<RouteDelivery>  getAllRouteDeliveryByRouteId(String routeId) {
		return routeDeliveryRepo.findAllByrouteId(routeId);
	}

	public List<DailyDelivery> getAllDailyDelivery() {
		return dailydeliveryrepo.findAll();
	}

	public List<DailyDelivery> getAllDailyDeliveryByRange(LocalDate startDate,LocalDate endDate) {
		return dailydeliveryrepo.findAllBydeliveredDateBetween(startDate, endDate);
	}
	
	public List<DailyDelivery> getAllDailyDeliveryByRouteId(String routeId) {
		return dailydeliveryrepo.findAllByrouteId(routeId);
	}
	
	public CustomerDeliveryList findCustomerSubscription() {

		String sql = Constant.CUSTOMER_SUB_QUERY;

		List<CustomerSubscr> customers = new ArrayList<>();

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

		for (Map row : rows) {
			CustomerSubscr obj = new CustomerSubscr();
			obj.setCustomer_id(Objects.toString(row.get("customer_id"), ""));
			obj.setCustrRouteId(Objects.toString(row.get("custrRouteId"), ""));
			obj.setFirst_name(Objects.toString(row.get("first_name"), ""));
			obj.setProdId(Objects.toString(row.get("prodId"), ""));
			obj.setProdType(Objects.toString(row.get("prodType"), ""));
			obj.setProductName(Objects.toString(row.get("productName"), ""));
			obj.setQuantity(Objects.toString(row.get("quantity"), ""));
			obj.setRate(Objects.toString(row.get("rate"), ""));
			obj.setTotalCost(Objects.toString(row.get("totalCost"), ""));
			obj.setUnit(Objects.toString(row.get("unit"), ""));

			customers.add(obj);
		}
		List<Vacation> vacationsList = customerservice.findTodayVacation();

		List<CustomerSubscr> availableCust = new ArrayList<>();
		List<CustomerSubscr> vacationCustList = new ArrayList<>();
		CustomerDeliveryList delList= new CustomerDeliveryList();
		for (CustomerSubscr cust : customers) {
			String cust1 = cust.getCustomer_id();
			boolean onvacation=false;
			for (Vacation vac : vacationsList) {
				String vacCustemer = String.valueOf(vac.getCustomerId());
				if (cust1.equalsIgnoreCase(vacCustemer)) {
					onvacation=true;
				} 
			}
		
			if (onvacation) {
				vacationCustList.add(cust);
			} else {
				availableCust.add(cust);
			}
		}
		delList.setCustAvailable(availableCust);
		delList.setCustOnVacation(vacationCustList);
		
		return delList;
	}

	
}
