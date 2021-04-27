package com.cg.vms.model.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.vms.model.Voter;


class VoterTest {
	
	Voter vot;
	
	@BeforeEach
	void setUp() throws Exception {
		vot = new Voter();
	}
	
	@AfterEach
	void tearDown() throws Exception {
		vot = null;
	}

	@Test
	void testVotId() {
		vot.setVoterID(100);
		assertEquals(100,vot.getVoterID());
	}
	
	@Test
	void testVotIdFalse() {
		vot.setVoterID(100);
		assertNotEquals(110,vot.getVoterID());
	}
	
	@Test
	void testVotName() {
		vot.setVoterName("abcde");
		assertEquals("abcde",vot.getVoterName());
	}
	
	@Test
	void testVotNameFalse() {
		vot.setVoterName("abcde");
		assertNotEquals("abe",vot.getVoterName());
	}
	
	@Test
	void testVotAge() {
		vot.setVoterAge(23);
		assertEquals(23,vot.getVoterAge());
	}
	
	@Test
	void testVotAgeFalse() {
		vot.setVoterAge(23);
		assertNotEquals(12,vot.getVoterAge());
	}
	
	@Test
	void testVotPhone() {
		vot.setVoterPhone("9123445623");
		assertEquals("9123445623",vot.getVoterPhone());
	}
	
	@Test
	void testVotPhoneFalse() {
		vot.setVoterPhone("9123445623");
		assertNotEquals("91234453",vot.getVoterPhone());
	}
	
	@Test
	void testVotCity() {
		vot.setVoterCity("Pune");
		assertEquals("Pune",vot.getVoterCity());
	}
	
	@Test
	void testVotCityFalse() {
		vot.setVoterCity("Pune");
		assertNotEquals("Delhi",vot.getVoterCity());
	}
	

	@Test
	void testVotIdProof() {
		vot.setVoterIdProof("45689");
		assertEquals("45689",vot.getVoterIdProof());
	}
	
	@Test
	void testVotIdProofFalse() {
		vot.setVoterIdProof("45689");
		assertNotEquals("4569",vot.getVoterIdProof());
	}
	
	@Test
	void testVotEmail() {
		vot.setEmail("abcd@gmail.com");
		assertEquals("abcd@gmail.com",vot.getEmail());
	}
	
	@Test
	void testVotEmailFalse() {
		vot.setEmail("abcd@gmail.com");
		assertNotEquals("abc@gmail.com",vot.getEmail());
	}
	
	@Test
	void testVotPassword() {
		vot.setPassword("Abchgf");
		assertEquals("Abchgf",vot.getPassword());
	}
	
	@Test
	void testVotPasswordFalse() {
		vot.setPassword("Abchgf");
		assertNotEquals("Abchg",vot.getPassword());
	}
	
	
	
	

}
