package com.cg.vms.service;

import java.util.List;

import com.cg.vms.model.Voter;
import com.cg.vms.exception.ResourceNotFoundException;




public interface VoterService {
	
	Voter createVoter(Voter voter);
	
	int updateVoter(int voterId, Voter voterDetails) throws ResourceNotFoundException;
	
	List<Voter> getAllVoters();
	
	Voter getVoterById(Integer voterId) throws ResourceNotFoundException;

	boolean deleteVoter(Integer voterId) throws ResourceNotFoundException;
	
	 String validateVoter(String emailId,String password);
	 String updateVotingStatus(int voterId);


}