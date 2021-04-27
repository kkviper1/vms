package com.cg.vms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.vms.model.Results;

public interface ResultRepository extends JpaRepository <Results, Long>{
	
}
