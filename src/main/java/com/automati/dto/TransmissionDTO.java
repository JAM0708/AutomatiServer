package com.automati.dto;

import java.io.Serializable;

public class TransmissionDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7529509347401132094L;
	
	private int id;
	private String name;
	
	
	
	public TransmissionDTO() {
	}
	
	

	public TransmissionDTO(int String) {
		this.name = name;
	}



	public TransmissionDTO(int id, String name) {
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