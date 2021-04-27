package com.cg.vms.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Results extends CandidateBase{

	@Id
    private Long candidateId;
	private int noOfVotes;
	
	
	public Long getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Long candidateId) {
		this.candidateId = candidateId;
	}
	
	public int getNoOfVotes() {
		return noOfVotes;
	}

	public void setNoOfVotes(int noOfVotes) {
		this.noOfVotes = noOfVotes;
	}
	
	public Results(Long candidateId, String Name, String constituency, String party) {
		// TODO Auto-generated constructor stub
		this.candidateId=candidateId;
		this.name=Name;
		this.constituency=constituency;
		this.party=party;
		}
	
	public Results() {}
}
