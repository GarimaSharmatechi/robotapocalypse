package com.robotapocalypse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.robotapocalypse.service.ReportService;

@RestController
@RequestMapping("/report")
public class ReportController {
	
	@Autowired
	ReportService rs;
	
	@RequestMapping (method=RequestMethod.GET, value = "/infected")
	public double getInfectedReport() {
		
		return rs.percentageOfInfectedSurvivors();
		
	}
	
	@RequestMapping (method=RequestMethod.GET, value = "/nonInfected")
	public double getNonInfectedReport() {
		
		return rs.percentageOfNonInfectedSurvivors();
		
	}

}
