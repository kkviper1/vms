package com.cg.vms.service.test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.cg.vms.model.Candidate;
import com.cg.vms.repository.CandidateRepository;
import com.cg.vms.service.CandidateService;

@RunWith(SpringRunner.class)
@SpringBootTest

class CandidateServiceTest {

	@MockBean
    private CandidateRepository candidateRepository;
	
	@Autowired
	private CandidateService candidateService;
	
	@Test
	void testCreateCandidate() throws Exception{
		Candidate candidate = new Candidate();
		candidate.setCandidateId(001L);
		candidate.setName("Charushi");
		candidate.setGender("Female");
		candidate.setAge(27);
		candidate.setEmailId("charuu@gmail.com");
		candidate.setPhoneNumber("8885126767");
		candidate.setConstituency("Xyx");
		candidate.setPassword("chhaj4272");
		candidate.setParty("AAA");
	   	 Mockito.when(candidateRepository.save(candidate)).thenReturn(candidate);
	   	 assertThat(candidateService.saveCandidate(candidate)).isEqualTo(candidate);               
	}

	@Test
	void testGetAllCandidates() throws Exception{
		Candidate viewcandidate = new Candidate();
		viewcandidate.setCandidateId(002L);
		viewcandidate.setName("Digvijay");
		viewcandidate.setGender("Male");
		viewcandidate.setAge(29);
		viewcandidate.setEmailId("dtu@gmail.com");
		viewcandidate.setPhoneNumber("888552167");
		viewcandidate.setConstituency("abcd");
		viewcandidate.setPassword("c72bsba@");
		viewcandidate.setParty("AAA");
	   	
		Candidate viewcandidate1 = new Candidate();
	   	viewcandidate1.setCandidateId(003L);
	   	viewcandidate1.setName("Mahi");
	   	viewcandidate1.setGender("Female");
	   	viewcandidate1.setAge(25);
	   	viewcandidate1.setEmailId("mht@gmail.com");
	   	viewcandidate1.setPhoneNumber("9985126767");
	   	viewcandidate1.setConstituency("Xyxz");
	   	viewcandidate1.setPassword("c%488h2");
	   	viewcandidate1.setParty("AAA");
	   	List<Candidate> checklist=new ArrayList<>();
		checklist.add(viewcandidate);
		checklist.add(viewcandidate1);
	   	
	    List<Candidate> candidatelist = new ArrayList<>();
	    candidatelist.add(viewcandidate);
	    candidatelist.add(viewcandidate1);
	    
	    Mockito.when(candidateRepository.findAll()).thenReturn(candidatelist);  
	    assertThat(candidateService.viewAllCandidates()).isEqualTo(candidatelist);
	}
	
	@Test
	void testdeleteCandidate() throws Exception{
		Candidate candidate1 = new Candidate();
		candidate1.setCandidateId(003L);
	   	candidate1.setName("Arnav");
	   	candidate1.setGender("male");
	   	candidate1.setAge(25);
	   	candidate1.setEmailId("mnaar@gmail.com");
	   	candidate1.setPhoneNumber("9989006767");
	   	candidate1.setConstituency("yxnmz");
	   	candidate1.setPassword("c@1q88h2");
	   	candidate1.setParty("AAA");
	    candidateRepository.delete(candidate1);
	    System.out.println(candidateRepository.findById(003L));
	    Assert.assertTrue(candidateRepository.findById(003L).isEmpty());    
	} 
}