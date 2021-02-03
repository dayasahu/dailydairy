package com.dailydairy.delivery.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dailydairy.delivery.entity.Route;

@Repository
public interface RouteRepo extends JpaRepository<Route, Long> {

}
