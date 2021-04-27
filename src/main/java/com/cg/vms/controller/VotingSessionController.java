package com.cg.vms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.vms.model.Candidate;
import com.cg.vms.model.Results;
import com.cg.vms.model.VotingSession;
import com.cg.vms.service.ResultService;
import com.cg.vms.service.VotingSessionService;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")

public class VotingSessionController {
	
	@Autowired
	VotingSessionService votingSessionService;
	@Autowired
	ResultService resultService;
	
	@GetMapping("/voting/all")
	public List<VotingSession> viewAll() {
	return votingSessionService.viewAll();
	}
	

	@PutMapping("/voting/{candidateId}")
	public void castVote(@PathVariable( value="candidateId") Long candidateId) {
		Optional<Results> res = resultService.getResultById(candidateId);
		Results r1=res.get();
		int votes=r1.getNoOfVotes();
		r1.setNoOfVotes(votes+1);
		resultService.saveResult(r1);
	
	}
}
