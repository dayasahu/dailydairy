package com.dailydairy.delivery.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailydairy.delivery.entity.Customer;
import com.dailydairy.delivery.entity.Vacation;
import com.dailydairy.delivery.exception.NotRecordFoundException;
import com.dailydairy.delivery.repo.CustomerRepo;
import com.dailydairy.delivery.repo.VacationRepo;

@Service
@Transactional
public class CustomerService {

	@Autowired
	private CustomerRepo repo;
	
	@Autowired
	private VacationRepo vacationRepo;

	public List<Customer> findAll() {
		return repo.findAll();
	}

	public void save(Customer customer) {
		repo.save(customer);
	}

	public Customer find(Long id) {
		return repo.findById(id).orElseThrow(() -> new NotRecordFoundException());
	}
	
	public List<Customer> findByRouteId(Long routeId) {
		return repo.findByrouteId(routeId).orElseThrow(() -> new NotRecordFoundException());
	}


	public Customer findByPhoneNum(String phnNum) {
		return repo.findByphoneNum(phnNum).orElseThrow(() -> new NotRecordFoundException());
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}
//////////////Vacation
	public List<Vacation> findAllVacation() {
		return vacationRepo.findAll();
	}
	
	public List<Vacation> findVacation(String custId) {
		
		return vacationRepo.findBycustomerId(Long.parseLong(custId)).orElseThrow(() -> new NotRecordFoundException());
	}
	
	public List<Vacation> findTodayVacation() {
		LocalDate date = LocalDate.now();
		return vacationRepo.findByendDate(date);
	}



	public void saveVacation(Vacation vacation) {
		vacationRepo.save(vacation);
	}
}
