package com.dailydairy.delivery.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailydairy.delivery.entity.Query;
import com.dailydairy.delivery.exception.NotRecordFoundException;
import com.dailydairy.delivery.repo.QueryRepo;

@Service
@Transactional
public class QueryService {

	@Autowired
	private QueryRepo repo;

	public List<Query> findAll() {
		return repo.findAll();
	}

	public void save(Query query) {
		repo.save(query);
	}

	public Query find(Long id) {
		return repo.findById(id).orElseThrow(() -> new NotRecordFoundException());
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}

}
