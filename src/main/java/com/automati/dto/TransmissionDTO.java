package com.automati.dto;

import java.io.Serializable;

import javax.persistence.Column;

public class TransmissionDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7529509347401132094L;
	
	private int id;
	private String name;
	private String imgSrc;
	private String imgAlt;
	private String description;
	private float transmissionPrice;
	
	
	public TransmissionDTO() {
	}

	public TransmissionDTO(int id, String name, String imgSrc, String imgAlt, String description,
			float transmissionPrice) {
		this.id = id;
		this.name = name;
		this.imgSrc = imgSrc;
		this.imgAlt = imgAlt;
		this.description = description;
		this.transmissionPrice = transmissionPrice;
	}

	public TransmissionDTO(String name, String imgSrc, String imgAlt, String description, float transmissionPrice) {
		this.name = name;
		this.imgSrc = imgSrc;
		this.imgAlt = imgAlt;
		this.description = description;
		this.transmissionPrice = transmissionPrice;
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

	public float getTransmissionPrice() {
		return transmissionPrice;
	}

	public void setTransmissionPrice(float transmissionPrice) {
		this.transmissionPrice = transmissionPrice;
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

	@Override
	public String toString() {
		return "TransmissionDTO [id=" + id + ", name=" + name + ", imgSrc=" + imgSrc + ", imgAlt=" + imgAlt
				+ ", description=" + description + ", transmissionPrice=" + transmissionPrice + "]";
	}
	
}
