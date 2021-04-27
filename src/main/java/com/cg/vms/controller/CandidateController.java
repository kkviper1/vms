package com.cg.vms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

import com.cg.vms.exception.CandidateNotFoundException;
import com.cg.vms.model.Candidate;
import com.cg.vms.model.Results;
import com.cg.vms.model.VotingSession;
import com.cg.vms.service.CandidateService;
import com.cg.vms.service.ResultService;
import com.cg.vms.service.VotingSessionService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")

public class CandidateController {
	
	@Autowired
	private CandidateService candidateService;
	@Autowired
	private VotingSessionService votingSessionService;
	@Autowired
	private ResultService resultService;
	
	@PostMapping("/candidate/add")
	public void insertData(@RequestBody Candidate candidate) {
		if(candidate.getAge()>=18 && candidate.getAge()<=60) {
			 candidateService.saveCandidate(candidate);
			VotingSession vs=new VotingSession(candidate.getCandidateId(),candidate.getName(),candidate.getConstituency(),candidate.getParty());
			votingSessionService.saveVoting(vs);
			Results res= new Results(candidate.getCandidateId(),candidate.getName(),candidate.getConstituency(),candidate.getParty());
			resultService.saveResult(res);
		 
	}
		
		}
	
	
	@GetMapping("/candidate/all")
	public List<Candidate> viewAllCandidates() {
		return candidateService.viewAllCandidates();
	}
	
	
	@GetMapping("/candidate/{candidateId}") 
		public ResponseEntity<Candidate> viewCandidate(@PathVariable( value="candidateId") Long candidateId) throws CandidateNotFoundException{
		Candidate candidate=candidateService.getCandidateById(candidateId).orElseThrow(() -> new CandidateNotFoundException("No Candidate Data Available with Candidate Id: " +candidateId));
		return ResponseEntity.ok().body(candidate);
		}
	
	@PutMapping("/candidate/{candidateId}")
	public Candidate updateCandidate(@RequestBody Candidate candidate) {
		Optional <Candidate> canOptional = candidateService.getCandidateById(candidate.getCandidateId());
		if(canOptional.isPresent() && candidate.getAge()>=18 && candidate.getAge()<=60) {
			return candidateService.saveCandidate(candidate);
		}
		else {
			return null;
		}
	}
	
	@DeleteMapping("/candidate/{candidateId}") 
	public String deleteCandidate(@PathVariable( value="candidateId") Long candidateId) throws CandidateNotFoundException{
		Candidate candidate=candidateService.getCandidateById(candidateId).orElseThrow(() -> new CandidateNotFoundException("No Candidate Data Available with Candidate Id: " +candidateId));
		candidateService.deleteCandidate(candidate);
		return "Candidate Details Deleted Successfully";
	}
	
	@RequestMapping(path = "/candidate/login/{emailId}/{password}", method = RequestMethod.GET)
	public String validCandidate(@PathVariable String emailId,@PathVariable String password) {

	return candidateService.validateCandidate(emailId, password);




	}

}

