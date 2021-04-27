package com.cg.vms.model.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.cg.vms.model.VotingSession;

class VotingSessionTest {
	
	VotingSession vos;

	@BeforeEach
	void setUp() throws Exception {
		vos = new VotingSession();
	}
	
	@AfterEach
	void tearDown() throws Exception {
		vos = null;
	}
	
	@Test
	void testVosName() {
		vos.setName("abcde");
		assertEquals("abcde",vos.getName());
	}
	
	@Test
	void testVosNameFalse() {
		vos.setName("abcde");
		assertNotEquals("abe",vos.getName());
	}
	
	@Test
	void testVosConstituency() {
		vos.setConstituency("Pune");
		assertEquals("Pune",vos.getConstituency());
	}
	
	@Test
	void testVosConstituencyFalse() {
		vos.setConstituency("Pune");
		assertNotEquals("Delhi",vos.getConstituency());
	}
	
	@Test
	void testCanParty() {
		vos.setParty("AAA");
		assertEquals("AAA",vos.getParty());
	}
	
	@Test
	void testCanPartyFalse() {
		vos.setParty("AAA");
		assertNotEquals("AAB",vos.getParty());
	}
}
