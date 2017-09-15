package com.automati.dataentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "feature")
public class Feature {

	@Id
	@Column(name = "feature_id")
	@SequenceGenerator(name = "featureSeq", sequenceName = "feature_Seq", allocationSize = 1)
	@GeneratedValue(generator = "featureSeq", strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(name = "feature_description")
	private String description;

	public Feature() {
	}

	public Feature(int id, String description) {
		this.id = id;
		this.description = description;
	}

	public Feature(String name) {
		this.description = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Feature [id=" + id + ", description=" + description + "]";
	}
	
	
}
