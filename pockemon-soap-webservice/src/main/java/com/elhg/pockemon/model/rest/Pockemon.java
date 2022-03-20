package com.elhg.pockemon.model.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pockemon {
	private Habilidades[] abilities;
	private String base_experience;
	private HeldItems[] held_items;
	private int id;
	private String name;
	private String location_area_encounters;
	  
}
