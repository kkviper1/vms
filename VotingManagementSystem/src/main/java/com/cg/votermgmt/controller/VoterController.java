package com.cg.votermgmt.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.votermgmt.entity.Voter;
import com.cg.votermgmt.exception.ResourceNotFoundException;
import com.cg.votermgmt.service.MapValidationErrorService;
import com.cg.votermgmt.service.VoterService;



@RestController 
@RequestMapping("/api/voters")
@CrossOrigin(origins = "*")
public class VoterController {
	
	@Autowired
	private VoterService voterService;
	
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
//	@PostMapping("/saveVoter/{voter_id}")
//	public Voter saveVoter(@PathVariable("voter_id") Integer voterId,@RequestBody Voter voter) throws ResourceNotFoundException {
//		return voterService.createVoter(voter); 
//	}
	
	@PostMapping("/saveVoter")
	public ResponseEntity<?> createNewUser(@Valid @RequestBody Voter voter, BindingResult result)
	{
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null) return errorMap;
		Voter newVoter = voterService.createVoter(voter);
		return new ResponseEntity<Voter>(newVoter,HttpStatus.CREATED);
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
	


