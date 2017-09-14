package com.automati.dto;

import java.io.Serializable;

public class FeatureDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7529509347401132094L;
	
	private int id;
	private String name;
	
	
	
	public FeatureDTO() {
	}
	
	

	public FeatureDTO(int String) {
		this.name = name;
	}



	public FeatureDTO(int id, String name) {
		this.id = id;
		this.name = name;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
}
