package com.dailydairy.delivery.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dailydairy.delivery.entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

	Optional<Customer> findByphoneNum(String phoneNum);
	Optional<List<Customer>> findByrouteId(Long routeId);
}
