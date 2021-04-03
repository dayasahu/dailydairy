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
	@Query(value="SELECT d.id,d.customer_id,cust.first_name,cust.last_name,cust.full_address,cust.phone_num,d.emp_id,emp.empName,d.product_id,d.status,d.route_delivery_id,d.prod_type,d.product_name,d.unit,d.created_dateFROM dailyDairy.daily_delivery d,dailyDairy.customer cust,dailyDairy.employee emp where d.customer_id=cust.id and d.emp_id=emp.id and d.status='Complete' and d.delivered_date=?1", nativeQuery = true)
	List<DailyDelivery> findAllBydeliveredDateAndstatus(String date);
	
	@Query(value="SELECT d.id,d.customer_id,cust.first_name,cust.last_name,cust.full_address,cust.phone_num,d.emp_id,emp.empName,d.product_id,d.status,d.route_delivery_id,d.prod_type,d.product_name,d.unit,d.created_dateFROM dailyDairy.daily_delivery d,dailyDairy.customer cust,dailyDairy.employee emp where d.customer_id=cust.id and d.emp_id=emp.id and d.status='Complete' and d.delivered_date=?1 and route_Id=?2", nativeQuery = true)
	List<DailyDelivery> findAllBydeliveredDateAndstatusAndRouteId(String date,String routeId);

}
