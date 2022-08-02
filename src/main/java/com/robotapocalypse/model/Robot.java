package com.robotapocalypse.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
@Data
@Entity
public class Robot {
    @Id
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    Integer id;
    long model;
    long serialNumber;
    Date manufacturedDate;
    String category;

}
