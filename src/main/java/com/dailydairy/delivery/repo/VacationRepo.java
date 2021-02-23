package com.dailydairy.delivery.repo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.dailydairy.delivery.entity.Vacation;

@Repository
public interface VacationRepo extends JpaRepository<Vacation, Long>{

	Optional<List<Vacation>> findBycustomerId(Long custId);
	Optional<List<Vacation>> findByendDate(LocalDate date);
}
