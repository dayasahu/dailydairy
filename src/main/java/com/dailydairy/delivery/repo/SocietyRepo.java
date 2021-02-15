package com.dailydairy.delivery.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dailydairy.delivery.entity.Society;

@Repository
public interface SocietyRepo extends JpaRepository<Society, Long> {

}
