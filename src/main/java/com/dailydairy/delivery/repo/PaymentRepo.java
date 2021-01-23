package com.dailydairy.delivery.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dailydairy.delivery.entity.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Long>{

}
