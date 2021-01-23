package com.dailydairy.delivery.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dailydairy.delivery.entity.Subscription;

public interface SubscriptionRepo extends JpaRepository<Subscription, Long>{

}
