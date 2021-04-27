package com.cg.vms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.vms.model.Voter;
import com.cg.vms.exception.ResourceNotFoundException;
import com.cg.vms.repository.VoterRepository;



@Service
public class VoterServiceImpl implements VoterService {
	
	@Autowired
	VoterRepository voterRepository;

	@Override
	public Voter createVoter(Voter voter) {
		voter.setVotingStatus("Not Voted");
		return voterRepository.save(voter);
	}

	@Override
	public List<Voter> getAllVoters() {
		return voterRepository.findAll();
	}

	@Override
	public Voter getVoterById(Integer voterId) throws ResourceNotFoundException {
		return voterRepository.getOne(voterId);
	}

	@Override
	public boolean deleteVoter(Integer voterId) throws ResourceNotFoundException {
		boolean check=false;
		Voter voter = voterRepository.findById(voterId).orElseThrow(
				() -> new ResourceNotFoundException("Voter not found for this id :: " + voterId));
		check=(voter!=null);
		voterRepository.deleteById(voterId);
		return check;
	
	}

	@Override
	public int updateVoter(int voterId, Voter voterDetails) throws ResourceNotFoundException {
		Voter voter=voterRepository.findById(voterId).orElseThrow(() -> new ResourceNotFoundException(" Voter not found for this id :: " + voterId));
		voter.setVoterName(voterDetails.getVoterName());
		voter.setVoterAge(voterDetails.getVoterAge());
		voter.setVoterIdProof(voterDetails.getVoterIdProof());
		voter.setVoterCity(voterDetails.getVoterCity());
		voter.setVoterPhone(voterDetails.getVoterPhone());
		voterRepository.save(voter);
		return voter.getVoterID();
	}
	
	public String validateVoter(String emailId,String password) {
		Voter v1=voterRepository.findByEmail(emailId);
		if(v1!=null) {
		if(v1.getPassword().equals(password)) {
		return "Valid";
		}
		else {
		return "Invalid";
		}
		}
		else {
		return "No User Found";
		}
		}

	@Override
	public String updateVotingStatus(int voterId) {
		
			Optional<Voter> vot1=voterRepository.findById(voterId);
			Voter voter=vot1.get();
			if(voter.getVotingStatus().equalsIgnoreCase("Not Voted")) {
			voter.setVotingStatus("Voted");
			voterRepository.save(voter);
			return "Status Updated";
			}
			else {
				return "Already Voted";
			}
		
		
	}


}
