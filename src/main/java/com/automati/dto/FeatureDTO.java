package com.automati.dto;

import java.io.Serializable;

public class FeatureDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7529509347401132094L;
	

	private String name;
	
	
	
	public FeatureDTO() {
	}
	
	

	public FeatureDTO(String name) {
		this.name = name;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
}
