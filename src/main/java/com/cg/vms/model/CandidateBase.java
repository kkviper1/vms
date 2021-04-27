package com.cg.vms.model;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class CandidateBase {

	protected String name;
	protected String constituency;
	protected String party;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getConstituency() {
		return constituency;
	}
	public void setConstituency(String constituency) {
		this.constituency = constituency;
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}
	
	
}
