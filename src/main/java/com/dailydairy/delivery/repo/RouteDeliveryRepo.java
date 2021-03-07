package com.dailydairy.delivery.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dailydairy.delivery.entity.RouteDelivery;

@Repository
public interface RouteDeliveryRepo extends JpaRepository<RouteDelivery, Long> {
	List<RouteDelivery> findAllBycreatedDateBetween(LocalDateTime startDate, LocalDateTime endDate);

}
