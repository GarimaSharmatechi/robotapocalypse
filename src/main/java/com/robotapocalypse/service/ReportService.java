package com.robotapocalypse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robotapocalypse.repository.SurvivorRepository;

@Service
public class ReportService {
	
	@Autowired
	SurvivorRepository sr;
	
	public Double percentageOfInfectedSurvivors() {
		
		System.out.println("Total : " + sr.getTotalSurvivorsCount());
		System.out.println("Infected : " + sr.getInfectedSurvivorsCount());
		return ((double)sr.getInfectedSurvivorsCount()/(double)sr.getTotalSurvivorsCount()) * 100.00;
		
	}
	
	public Double percentageOfNonInfectedSurvivors() {
		
		System.out.println("Total : " + sr.getTotalSurvivorsCount());
		System.out.println("NonInfected : " + sr.getNonInfectedSurvivorsCount());
		return ((double)sr.getNonInfectedSurvivorsCount()/(double)sr.getTotalSurvivorsCount()) * 100.00;
		
	}

}
