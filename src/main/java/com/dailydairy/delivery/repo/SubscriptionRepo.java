package com.dailydairy.delivery.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dailydairy.delivery.entity.Subscription;

@Repository
public interface SubscriptionRepo extends JpaRepository<Subscription, Long>{

}
