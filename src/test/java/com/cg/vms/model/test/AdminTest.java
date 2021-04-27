package com.cg.vms.model.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.cg.vms.model.Admin;

class AdminTest {
	
	Admin adm;
	
	@BeforeEach
	void setUp() throws Exception {
		adm = new Admin();
	}
	
	@AfterEach
	void tearDown() throws Exception {
		adm = null;
	}
	

	@Test
	void testAdmPassword() {
		adm.setPassword("abcde");
		assertEquals("abcde",adm.getPassword());
	}
	
	@Test
	void testAdmPasswordFalse() {
		adm.setPassword("abcde");
		assertNotEquals("abe",adm.getPassword());
	}

	

}
