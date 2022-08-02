package com.robotapocalypse.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robotapocalypse.model.Location;
import com.robotapocalypse.model.Survivor;
import com.robotapocalypse.repository.SurvivorRepository;
@Service
public class SurvivorService {
    @Autowired
    SurvivorRepository survivorRepo;

    public List<Survivor> getAllSurvivors(){
        List<Survivor> survivors= new ArrayList<>();
        survivorRepo.findAll().forEach(survivor -> survivors.add(survivor));
        return  survivors;
    }
    public void SaveUpdate(Survivor survivor){
        survivorRepo.save(survivor);
    }

    public  List<Survivor> getInfectedSurvivor(boolean infected){
        List<Survivor> survivors= new ArrayList<>();
        survivorRepo.getInfectedSurvivor(infected).forEach(survivor -> survivors.add(survivor));
        return  survivors;
    }
    
    public  void updateLocation(Integer survivorId, Location location){
        Survivor survivor = survivorRepo.findById(survivorId).get();
        survivor.getLocation().setLatitude(location.getLatitude());
        survivor.getLocation().setLongitude(location.getLongitude());
        survivorRepo.save(survivor);
   }
    
    public  void reportInfection(Integer survivorId){
         Survivor survivor = survivorRepo.findById(survivorId).get();
         survivor.incrementInfection();
         survivorRepo.save(survivor);
    }
}

