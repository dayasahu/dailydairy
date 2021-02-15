package com.dailydairy.delivery.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dailydairy.delivery.entity.Payment;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Long>{

}
