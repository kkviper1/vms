package com.cg.vms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.vms.model.Voter;

@Repository
public interface VoterRepository extends JpaRepository<Voter, Integer> {
	
	public Voter findByEmail(String emailId);

}
