package com.cg.vms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
//@SecondaryTable(name = "Voting", pkJoinColumns = @PrimaryKeyJoinColumn(name = "Candidate_Id"))
//@SecondaryTable(name = "results", pkJoinColumns = @PrimaryKeyJoinColumn(name = "Candidate_Id"))
@Table(name="Candidate_data")
public class Candidate extends CandidateBase {
	
	
//	@Column(name="name",table="Voting")
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long candidateId;
	private String gender;
	private int age;
	@Column(name="Phone_No")
	private String phoneNumber;
	@Column(name="Email")
	private String emailId;
	private String password;
	
	public Candidate() {
		super();
	}
	
	public Long getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Long candidateId) {
		this.candidateId = candidateId;
	}

	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Candidate(Long candidateId, String name,String constituency,String party,int age, String emailId,String gender,
			String password,String phoneNumber) {
		super();
		this.candidateId = candidateId;
		this.name = name;
		
		this.gender = gender;
		this.party=party;
		this.age = age;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.constituency = constituency;
		this.password = password;
	}
	@Override
	public String toString() {
		return "Candidate [candidateId=" + candidateId + ", Name=" + name 
				+ ", gender=" + gender + ", age=" + age +", party=" + party + ", emailId=" + emailId + ", phoneNumber=" + phoneNumber
				+ ", constituency=" + constituency + ", password=" + password + "]";
	}
	
	
	
	
	
	
	

}
