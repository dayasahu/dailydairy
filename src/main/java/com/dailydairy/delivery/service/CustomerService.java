package com.dailydairy.delivery.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailydairy.delivery.entity.Customer;
import com.dailydairy.delivery.exception.NotRecordFoundException;
import com.dailydairy.delivery.repo.CustomerRepo;

@Service
@Transactional
public class CustomerService {

	@Autowired
	private CustomerRepo repo;

	public List<Customer> findAll() {
		return repo.findAll();
	}

	public void save(Customer customer) {
		repo.save(customer);
	}

	public Customer find(Long id) {
		return repo.findById(id).orElseThrow(() -> new NotRecordFoundException());
	}

	public Customer findByPhoneNum(String phnNum) {
		return repo.findByphoneNum(phnNum).orElseThrow(() -> new NotRecordFoundException());
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}

}
