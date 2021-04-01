package com.cg.votermgmt.service;

import java.util.List;

import com.cg.votermgmt.entity.Voter;
import com.cg.votermgmt.exception.ResourceNotFoundException;




public interface VoterService {
	
	Voter createVoter(Voter voter);
	
	int updateVoter(int voterId, Voter voterDetails) throws ResourceNotFoundException;
	
	List<Voter> getAllVoters();
	
	Voter getVoterById(Integer voterId) throws ResourceNotFoundException;

	boolean deleteVoterById(Integer voterId) throws ResourceNotFoundException;


}