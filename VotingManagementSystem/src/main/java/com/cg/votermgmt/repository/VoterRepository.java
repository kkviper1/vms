package com.cg.votermgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.votermgmt.entity.Voter;

@Repository
public interface VoterRepository extends JpaRepository<Voter, Integer> {

}
