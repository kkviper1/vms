package com.cg.votermgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.votermgmt.entity.Voter;
import com.cg.votermgmt.exception.ResourceNotFoundException;
import com.cg.votermgmt.service.VoterService;



@RestController 

public class VoterController {
	
	@Autowired
	private VoterService voterService;
	
	@PostMapping("/saveVoter/{voter_id}")
	public Voter saveVoter(@PathVariable("voter_id") Integer voterId,@RequestBody Voter voter) throws ResourceNotFoundException {
		return voterService.createVoter(voter); 
	}
	
	@GetMapping("/voters")
	public List<Voter> getAllVoters(){
		List<Voter> voter = voterService.getAllVoters();
		return voter;
	}
	
	@GetMapping("/getVoter/{id}")
	public Voter getVoterById(@PathVariable(value = "id") Integer voterId) throws ResourceNotFoundException{
      return voterService.getVoterById(voterId);
	}
	
	@PutMapping("/UpdateVoter/{voter_id}")
	public Integer updatevoter(@PathVariable("voter_id") Integer voterId,@RequestBody Voter voterDetails) throws ResourceNotFoundException{
		
		return voterService.updateVoter(voterId, voterDetails);
	
	}
	}
	


