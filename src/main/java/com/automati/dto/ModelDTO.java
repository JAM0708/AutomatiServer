package com.automati.dto;

import java.io.Serializable;

public class ModelDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7529509347401132094L;
	
	private int id;
	private String name;
	private String imgSrc;
	private String imgAlt;
	private String description;
	private float modelStockPrice;
	
	
	
	public ModelDTO() {
	}
	
	

	public ModelDTO(int id, String name, String imgSrc, String imgAlt, String description, float modelStockPrice) {
		this.id = id;
		this.name = name;
		this.imgSrc = imgSrc;
		this.imgAlt = imgAlt;
		this.description = description;
		this.modelStockPrice = modelStockPrice;
	}



	public ModelDTO(String name, String imgSrc, String imgAlt, String description, float modelStockPrice) {
		this.name = name;
		this.imgSrc = imgSrc;
		this.imgAlt = imgAlt;
		this.description = description;
		this.modelStockPrice = modelStockPrice;
	}



	public String getImgSrc() {
		return imgSrc;
	}



	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}



	public String getImgAlt() {
		return imgAlt;
	}



	public void setImgAlt(String imgAlt) {
		this.imgAlt = imgAlt;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public float getModelStockPrice() {
		return modelStockPrice;
	}



	public void setModelStockPrice(float modelStockPrice) {
		this.modelStockPrice = modelStockPrice;
	}



	public ModelDTO(String name) {
		this.name = name;
	}



	public ModelDTO(int id, String name) {
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
