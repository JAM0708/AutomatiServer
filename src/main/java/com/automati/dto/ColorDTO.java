package com.automati.dto;

import java.io.Serializable;

public class ColorDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7529509347401132094L;
	
	private int id;
	private String name;
	private String imgSrc;
	private String imgAlt;
	private String description;
	private float colorPrice;
	
	
	
	
	
	public ColorDTO() {
	}

	public ColorDTO(int id, String name, String imgSrc, String imgAlt, String description, float colorPrice) {
		this.id = id;
		this.name = name;
		this.imgSrc = imgSrc;
		this.imgAlt = imgAlt;
		this.description = description;
		this.colorPrice = colorPrice;
	}
	
	

	public ColorDTO(String name, String imgSrc, String imgAlt, String description, float colorPrice) {
		this.name = name;
		this.imgSrc = imgSrc;
		this.imgAlt = imgAlt;
		this.description = description;
		this.colorPrice = colorPrice;
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

	public float getColorPrice() {
		return colorPrice;
	}

	public void setColorPrice(float colorPrice) {
		this.colorPrice = colorPrice;
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
