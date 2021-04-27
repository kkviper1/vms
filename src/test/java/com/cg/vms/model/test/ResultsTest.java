package com.cg.vms.model.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.cg.vms.model.Results;

class ResultsTest {
	
	Results res;
	

	@BeforeEach
	void setUp() throws Exception {
		res = new Results();
	}
	
	@AfterEach
	void tearDown() throws Exception {
		res = null;
	}
	
	@Test
	void testVosName() {
		res.setName("abcde");
		assertEquals("abcde",res.getName());
	}
	
	@Test
	void testVosNameFalse() {
		res.setName("abcde");
		assertNotEquals("abe",res.getName());
	}
	
	@Test
	void testVosConstituency() {
		res.setConstituency("Pune");
		assertEquals("Pune",res.getConstituency());
	}
	
	@Test
	void testVosConstituencyFalse() {
		res.setConstituency("Pune");
		assertNotEquals("Delhi",res.getConstituency());
	}
	
	@Test
	void testCanParty() {
		res.setParty("AAA");
		assertEquals("AAA",res.getParty());
	}
	
	@Test
	void testCanPartyFalse() {
		res.setParty("AAA");
		assertNotEquals("AAB",res.getParty());
	}
}

