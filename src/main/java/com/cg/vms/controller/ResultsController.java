package com.cg.vms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.vms.model.Results;
import com.cg.vms.service.ResultService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class ResultsController {

	@Autowired
	private ResultService resultService;
	
	@GetMapping("/results/all")
	public List<Results> viewAll() {
		return resultService.viewAll();
	}
	
}
