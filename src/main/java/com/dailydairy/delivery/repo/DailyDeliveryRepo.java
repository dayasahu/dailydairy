package com.dailydairy.delivery.repo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dailydairy.delivery.entity.DailyDelivery;
import com.dailydairy.delivery.entity.RouteDelivery;

@Repository
public interface DailyDeliveryRepo extends JpaRepository<DailyDelivery, Long> {
	
	List<DailyDelivery> findAllBydeliveredDateBetween(LocalDate startDate, LocalDate endDate);
	List<DailyDelivery> findAllByrouteId(String routeId);

}
