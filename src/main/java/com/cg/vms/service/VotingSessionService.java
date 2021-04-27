package com.cg.vms.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.vms.model.VotingSession;
import com.cg.vms.repository.VotingSessionRepository;

@Service
public class VotingSessionService {

@Autowired
private VotingSessionRepository votingRepo;


public VotingSession saveVoting(VotingSession voting) {
return votingRepo.save(voting);
}

public Optional<VotingSession> getVotingSessionById(Long candidateId) {
	return votingRepo.findById(candidateId);
}

public List<VotingSession> viewAll() {
return votingRepo.findAll();
}
}