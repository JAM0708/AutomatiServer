package com.automati.dataentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="model")
public class Model {

	@Id
	@Column(name="model_id")
	@SequenceGenerator(name="modelSeq", sequenceName="model_Seq", allocationSize=1)
	@GeneratedValue(generator="modelSeq", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="model_name")
	private String name;
	
	@Column(name = "img_src")
	private String imgSrc;
	
	@Column(name = "img_alt")
	private String imgAlt;

	public Model() {
	}

	public Model(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Model(int id, String name, String imgSrc, String imgAlt) {
		this.id = id;
		this.name = name;
		this.imgSrc = imgSrc;
		this.imgAlt = imgAlt;
	}

	public Model(String name) {
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
	
	
	
	
}
