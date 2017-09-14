package com.automati.dto;

import java.io.Serializable;

public class EPADTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7529509347401132094L;
	
	private int id;
	private int mileage;
	
	
	
	public EPADTO() {
	}



	public EPADTO(int id, int mileage) {
		this.id = id;
		this.mileage = mileage;
	}



	public EPADTO(int mileage) {
		this.mileage = mileage;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getMileage() {
		return mileage;
	}



	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	
	
	
	
	
	
	
}
