package com.dailydairy.delivery.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dailydairy.delivery.entity.DailyOrder;

@Repository
public interface DailyOrderRepo extends JpaRepository<DailyOrder, Long> {

}
