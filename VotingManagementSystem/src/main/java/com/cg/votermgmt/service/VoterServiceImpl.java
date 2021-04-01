package com.cg.votermgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.votermgmt.entity.Voter;
import com.cg.votermgmt.exception.ResourceNotFoundException;
import com.cg.votermgmt.repository.VoterRepository;



@Service
public class VoterServiceImpl implements VoterService {
	
	@Autowired
	VoterRepository voterRepository;

	@Override
	public Voter createVoter(Voter voter) {
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
	public boolean deleteVoterById(Integer voterId) throws ResourceNotFoundException {
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

}
