package com.automati.dataentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="color")
public class Color {
	
	@Id
	@Column(name="color_id")
	@SequenceGenerator(name="colorSeq", sequenceName="color_Seq", allocationSize=1)
	@GeneratedValue(generator="colorSeq", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="color_name")
	private String name;
	
	@Column(name = "img_src")
	private String imgSrc;
	
	@Column(name = "img_alt")
	private String imgAlt;
	
	@Column(name = "description")
	private String description;

	@Column(name = "color_price")
	private float colorPrice;
	
	public Color(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Color(int id, String name, String imgSrc, String imgAlt, String description) {
		this.id = id;
		this.name = name;
		this.imgSrc = imgSrc;
		this.imgAlt = imgAlt;
		this.description = description;
	}

	public Color() {
	}

	public Color(String name) {
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

	
}
