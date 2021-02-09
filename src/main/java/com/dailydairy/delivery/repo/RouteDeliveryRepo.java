package com.dailydairy.delivery.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.dailydairy.delivery.entity.RouteDelivery;

@Repository
public interface RouteDeliveryRepo extends JpaRepository<RouteDelivery, Long> {


}
