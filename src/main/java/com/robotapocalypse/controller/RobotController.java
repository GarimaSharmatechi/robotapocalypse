package com.robotapocalypse.controller;

import com.robotapocalypse.model.Robot;
import com.robotapocalypse.service.RobotService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RobotController {
    @Autowired
    RobotService robotService;

    @GetMapping("/robots")
  public List<Robot> getRobots(){
        return  robotService.getAllRobots();
  }

    @PostMapping("/robots")
    private ResponseEntity<String> createRobot(@RequestBody Robot robot){
        try{
            robotService.SaveUpdate(robot);
        }catch(Exception ex){
            return  new ResponseEntity<String> ("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<String>("created"+robot.getId(), HttpStatus.CREATED) ;
    }


}
