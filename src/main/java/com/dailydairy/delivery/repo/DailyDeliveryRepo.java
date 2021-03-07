package com.dailydairy.delivery.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dailydairy.delivery.entity.DailyDelivery;

@Repository
public interface DailyDeliveryRepo extends JpaRepository<DailyDelivery, Long> {
	
	List<DailyDelivery> findAllBycreatedDateBetween(LocalDateTime startDate, LocalDateTime endDate);

}
