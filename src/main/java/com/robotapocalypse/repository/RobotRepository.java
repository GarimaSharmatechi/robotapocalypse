package com.robotapocalypse.repository;

import com.robotapocalypse.model.Robot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RobotRepository extends JpaRepository<Robot , Integer> {

}
