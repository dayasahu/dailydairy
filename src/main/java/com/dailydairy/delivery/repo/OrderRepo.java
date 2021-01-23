package com.dailydairy.delivery.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dailydairy.delivery.entity.Order;

public interface OrderRepo extends JpaRepository<Order, Long> {

}
