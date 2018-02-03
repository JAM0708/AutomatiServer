package com.automati.dto;

import java.io.Serializable;

public class EngineDTO implements Serializable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5335808289041642072L;
	
	private int id;
	private int cylinders;
	private float litres;
	
	
	
	public EngineDTO() {
	}
	
	public EngineDTO(int id, int cylinders, float litres) {
		this.id = id;
		this.cylinders = cylinders;
		this.litres = litres;
	}

	public EngineDTO(int cylinders, float litres) {
		this.cylinders = cylinders;
		this.litres = litres;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCylinders() {
		return cylinders;
	}

	public void setCylinders(int cylinders) {
		this.cylinders = cylinders;
	}

	public float getLitres() {
		return litres;
	}

	public void setLitres(float litres) {
		this.litres = litres;
	}

	
	
}
