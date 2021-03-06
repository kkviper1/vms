package com.cg.vms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.vms.model.Candidate;
import com.cg.vms.repository.CandidateRepository;

@Service
public class CandidateService {
	
	@Autowired
	private CandidateRepository candidateRepository;
	
	
	public Candidate saveCandidate(Candidate candidate) {
		return candidateRepository.save(candidate);
	}

	
	public List<Candidate> viewAllCandidates() {
		return candidateRepository.findAll();
	}
	
	
	public Optional<Candidate> getCandidateById(Long candidateId) {
		return candidateRepository.findById(candidateId);
	}
	
	
	public Candidate updateCandidate(Candidate candidate) {
		return candidateRepository.save(candidate);
	}
	
	
	public void deleteCandidate(Candidate candidate) {
		candidateRepository.delete(candidate);
	}
	
	public String validateCandidate(String emailId,String password) {
		Candidate c1=candidateRepository.findByEmailId(emailId);
		if(c1!=null) {
		if(c1.getPassword().equals(password)) {
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
}
