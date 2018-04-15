package com.automati.dataentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="transmission")
public class Transmission {
	
	@Id
	@Column(name="transmission_id")
	@SequenceGenerator(name="transmissionSeq", sequenceName="transmission_Seq", allocationSize=1)
	@GeneratedValue(generator="transmissionSeq", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="transmission_name")
	private String name;

	@Column(name = "img_src")
	private String imgSrc;
	
	@Column(name = "img_alt")
	private String imgAlt;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "transmission_price")
	private float transmissionPrice;
	
	public Transmission(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Transmission(int id, String name, String imgSrc, String imgAlt, String description) {
		this.id = id;
		this.name = name;
		this.imgSrc = imgSrc;
		this.imgAlt = imgAlt;
		this.description = description;
	}


	public Transmission(String name)
	{
		this.name = name;
	}

	public Transmission() {
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
	
}
