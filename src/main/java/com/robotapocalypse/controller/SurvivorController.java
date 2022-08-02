package com.robotapocalypse.controller;

import com.robotapocalypse.model.Location;
import com.robotapocalypse.model.Survivor;
import com.robotapocalypse.service.SurvivorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/survivors")
public class SurvivorController {
    @Autowired
    SurvivorService survivorService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<Survivor> getSurvivors(){
    	System.out.println("Inside GET Survivors");
        return survivorService.getAllSurvivors();
    }

    @RequestMapping(value = "/",method = RequestMethod.GET,params = {"infected"})
    public List<Survivor> getSurvivors(@RequestParam(value="infected",required = false)  boolean infected){
        return survivorService.getInfectedSurvivor(infected);
    }

    @PostMapping("/")
    private ResponseEntity<String> createSurvivor(@RequestBody Survivor survivor){
        try{
            survivorService.SaveUpdate(survivor);
        }catch(Exception ex){
            return  new ResponseEntity<String> ("Failed",HttpStatus.INTERNAL_SERVER_ERROR);
        }
         return new ResponseEntity<String>("created"+ survivor.getSurvivorId(), HttpStatus.CREATED) ;
    }

    @PatchMapping("/{survivorId}/location/")
    private ResponseEntity<String> updateLocation(@PathVariable Integer survivorId, @RequestBody Location location){
        try{
        	System.out.println("Inside PATCH Locations");
        	survivorService.updateLocation(survivorId, location);
        }catch(Exception ex){
            return  new ResponseEntity<String> ("Failed",HttpStatus.INTERNAL_SERVER_ERROR);
        }
         return new ResponseEntity<String>("updated"+ survivorId, HttpStatus.CREATED) ;
    }
    
    @PutMapping("/{survivorId}/report")
    private ResponseEntity<String> reportInfection(@RequestParam Integer survivorId){
        try{
        	survivorService.reportInfection(survivorId);
        }catch(Exception ex){
            return  new ResponseEntity<String> ("Failed",HttpStatus.INTERNAL_SERVER_ERROR);
        }
         return new ResponseEntity<String>("reported"+ survivorId, HttpStatus.CREATED) ;
    }


}
