/**
 * 
 */
package com.cg.vms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author karankha
 * 
 * POJO Class for Voter Entity
 *
 */
@Entity
@Table(name="VOTER")
public class Voter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int voterID;
	
	@NotEmpty(message = "Name cannot be empty")
	private String voterName;
	
	@NotNull(message = "Age cannot be empty")
	@Min(18)
	private int voterAge;
	
	@Size(min=10, max = 10, message = "Invalid Phone number")
	private String voterPhone;
	
	private String voterCity;
	
	private String voterIdProof;
	private String votingStatus;
	
	@Email
	private String email;
	
	@Size(min=8)
	@NotEmpty(message = "Invalid password")
	private String password;

	/**
	 * @return the voterID
	 */
	public int getVoterID() {
		return voterID;
	}

	/**
	 * @param voterID the voterID to set
	 */
	public void setVoterID(int voterID) {
		this.voterID = voterID;
	}

	/**
	 * @return the voterName
	 */
	public String getVoterName() {
		return voterName;
	}

	/**
	 * @param voterName the voterName to set
	 */
	public void setVoterName(String voterName) {
		this.voterName = voterName;
	}

	/**
	 * @return the voterAge
	 */
	public int getVoterAge() {
		return voterAge;
	}

	/**
	 * @param voterAge the voterAge to set
	 */
	public void setVoterAge(int voterAge) {
		this.voterAge = voterAge;
	}

	/**
	 * @return the voterPhone
	 */
	public String getVoterPhone() {
		return voterPhone;
	}

	/**
	 * @param voterPhone the voterPhone to set
	 */
	public void setVoterPhone(String voterPhone) {
		this.voterPhone = voterPhone;
	}

	/**
	 * @return the voterCity
	 */
	public String getVoterCity() {
		return voterCity;
	}

	/**
	 * @param voterCity the voterCity to set
	 */
	public void setVoterCity(String voterCity) {
		this.voterCity = voterCity;
	}

	/**
	 * @return the voterIdProof
	 */
	public String getVoterIdProof() {
		return voterIdProof;
	}

	/**
	 * @param voterIdProof the voterIdProof to set
	 */
	public void setVoterIdProof(String voterIdProof) {
		this.voterIdProof = voterIdProof;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVotingStatus() {
		return votingStatus;
	}

	public void setVotingStatus(String votingStatus) {
		this.votingStatus = votingStatus;
	}
	
	
	

}