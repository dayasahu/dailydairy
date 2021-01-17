package com.dailydairy.delivery.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dailydairy.delivery.entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long>{

}
