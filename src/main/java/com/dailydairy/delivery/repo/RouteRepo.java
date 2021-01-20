package com.dailydairy.delivery.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dailydairy.delivery.entity.Route;

public interface RouteRepo extends JpaRepository<Route, Long> {

}
