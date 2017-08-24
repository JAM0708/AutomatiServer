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

	public Color(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Color() {
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