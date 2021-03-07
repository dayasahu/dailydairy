package com.dailydairy.delivery.repo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dailydairy.delivery.entity.DailyDelivery;
import com.dailydairy.delivery.entity.RouteDelivery;

@Repository
public interface DailyDeliveryRepo extends JpaRepository<DailyDelivery, Long> {
	
	List<DailyDelivery> findAllBydeliveredDateBetween(LocalDate startDate, LocalDate endDate);
	List<DailyDelivery> findAllByrouteId(String routeId);
	@Query(value="SELECT * FROM dailyDairy.daily_delivery d where d.status='Complete' and d.delivered_date=?1", nativeQuery = true)
	List<DailyDelivery> findAllBydeliveredDateAndstatus(String date);
	
	@Query(value="SELECT * FROM dailyDairy.daily_delivery d where d.status='Complete' and d.delivered_date=?1 and route_Id=?2", nativeQuery = true)
	List<DailyDelivery> findAllBydeliveredDateAndstatusAndRouteId(String date,String routeId);

}
