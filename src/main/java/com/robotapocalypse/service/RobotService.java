package com.robotapocalypse.service;

import com.robotapocalypse.model.Robot;
import com.robotapocalypse.repository.RobotRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RobotService {

    @Autowired
    RobotRepository robotRepo;

    public List<Robot>  getAllRobots(){
        List<Robot> robots= new ArrayList<>();
        robotRepo.findAll().forEach(robot -> robots.add(robot));
        return  robots;
    }

    public void SaveUpdate(Robot robot){
        robotRepo.save(robot);
    }

}
