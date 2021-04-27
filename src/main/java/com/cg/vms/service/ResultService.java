package com.cg.vms.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.vms.model.Results;
import com.cg.vms.repository.ResultRepository;


@Service
public class ResultService {

	@Autowired
	private ResultRepository resultRepo;


	public Results saveResult(Results result) {
	return resultRepo.save(result);
	}
	
	public Optional<Results> getResultById(Long candidateId) {
		return resultRepo.findById(candidateId);
	}
	
	public List<Results> viewAll() {
		return resultRepo.findAll();
	}
	
	public void increaseVote(Results res) {
		res.setNoOfVotes(res.getNoOfVotes()+1);
		
	}
}
