package com.gm.base.entities;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

public class DietStructure {
	
	@Transient
	public static final String SEQUENCE_NAME = "diet_structure_sequence";

	@Id
	Integer dietStructureId;
	String timing;
	List<String> dietComponents;
	
	public Integer getDietStructureId() {
		return dietStructureId;
	}
	public void setDietStructureId(Integer dietStructureId) {
		this.dietStructureId = dietStructureId;
	}
	public List<String> getDietComponents() {
		return dietComponents;
	}
	public void setDietComponents(List<String> dietComponents) {
		this.dietComponents = dietComponents;
	}
}
