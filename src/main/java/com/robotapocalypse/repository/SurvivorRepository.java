package com.robotapocalypse.repository;

import com.robotapocalypse.model.Survivor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface SurvivorRepository extends JpaRepository<Survivor,Integer> {
	 
    @Query("select survivor from Survivor survivor where survivor.reportedInfectionCount>=3")
    public List<Survivor> getInfectedSurvivor(@RequestParam boolean infected);
    
    @Query("select count(*) from Survivor survivor")
    public Integer getTotalSurvivorsCount();
    
    @Query("select count(*) from Survivor survivor where survivor.reportedInfectionCount>=3")
    public Integer getInfectedSurvivorsCount();
    
    @Query("select count(*) from Survivor survivor where survivor.reportedInfectionCount<3")
    public Integer getNonInfectedSurvivorsCount();
}
