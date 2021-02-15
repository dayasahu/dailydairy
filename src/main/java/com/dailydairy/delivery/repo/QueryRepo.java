package com.dailydairy.delivery.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dailydairy.delivery.entity.Query;

public interface QueryRepo extends JpaRepository<Query, Long> {

}
