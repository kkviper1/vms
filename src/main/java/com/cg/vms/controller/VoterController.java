package com.cg.vms.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.cg.vms.model.Voter;
import com.cg.vms.exception.ResourceNotFoundException;
import com.cg.vms.service.MapValidationErrorService;
import com.cg.vms.service.VoterService;



@RestController 
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class VoterController {
	
	@Autowired
	private VoterService voterService;
	
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
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
	
	@PutMapping("/UpdateVoter/{voterId}")
	public Integer updatevoter(@PathVariable("voter_id") Integer voterId,@RequestBody Voter voterDetails) throws ResourceNotFoundException{
		
		return voterService.updateVoter(voterId, voterDetails);
	
	}
	
	
	
	
	@DeleteMapping("deleteVoter/{voterId}")
	public ResponseEntity<Boolean> deleteVoter(@PathVariable(value = "voterId") Integer voterId) throws ResourceNotFoundException	{
		
		boolean voter = voterService.deleteVoter(voterId);
		return  ResponseEntity.ok(voter);
	}
	
	@RequestMapping(path = "/voter/login/{emailId}/{password}", method = RequestMethod.GET)
	public String validVoter(@PathVariable String emailId,@PathVariable String password) {

	return voterService.validateVoter(emailId, password);




	}
	
	@PutMapping("/UpdateVotingStatus/{voterId}")
	public String updateVotingStatus(@PathVariable("voterId") Integer voterId) throws ResourceNotFoundException{
		
		return voterService.updateVotingStatus(voterId);
	
	}




	}
	
	


