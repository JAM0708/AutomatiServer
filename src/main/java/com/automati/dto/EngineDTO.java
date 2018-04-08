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
	private float stockEnginePrice;
	
	
	public EngineDTO() {
	}
	
	public EngineDTO(int id, int cylinders, float litres, float stockEnginePrice) {
		this.id = id;
		this.cylinders = cylinders;
		this.litres = litres;
		this.stockEnginePrice = stockEnginePrice;
	}

	public EngineDTO(int cylinders, float litres, float stockEnginePrice) {
		this.cylinders = cylinders;
		this.litres = litres;
		this.stockEnginePrice = stockEnginePrice;
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

	public float getStockEnginePrice() {
		return stockEnginePrice;
	}

	public void setStockEnginePrice(float stockEnginePrice) {
		this.stockEnginePrice = stockEnginePrice;
	}

	@Override
	public String toString() {
		return "EngineDTO [id=" + id + ", cylinders=" + cylinders + ", litres=" + litres + ", stockEnginePrice="
				+ stockEnginePrice + "]";
	}
	
}
