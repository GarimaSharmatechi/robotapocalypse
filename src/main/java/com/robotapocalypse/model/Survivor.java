package com.robotapocalypse.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
@Table (name ="Survivor")
public class Survivor {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer survivorId;
	
	private String name;
    
	private Integer age;
    
	private String gender;
    
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn (name = "locationId")
	private Location location;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn (name = "inventoryId")
	private Inventory inventory;
    
	private Integer reportedInfectionCount;
	
	public void incrementInfection() {
		this.reportedInfectionCount++;
	}
	
}
