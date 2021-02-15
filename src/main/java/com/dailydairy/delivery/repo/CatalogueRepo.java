package com.dailydairy.delivery.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dailydairy.delivery.entity.Catalougue;

public interface CatalogueRepo extends JpaRepository<Catalougue, Long>{

}
