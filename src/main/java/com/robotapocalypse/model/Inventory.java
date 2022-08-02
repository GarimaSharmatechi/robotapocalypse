package com.robotapocalypse.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
@Table (name = "Inventory")
public class Inventory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Integer inventoryId;
	
	private String water;
	
	private String food;
	
	private String ammunitions;
	
//	@OneToOne (mappedBy = "inventory")
//	private Survivor survivor;
}
