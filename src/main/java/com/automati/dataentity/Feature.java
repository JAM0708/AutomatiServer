package com.automati.dataentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@ManyToOne
	@JoinColumn(name="carId", nullable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Car car;
	
	public Feature() {
	}	

	public Feature(int id, String description, Car car) {
		this.id = id;
		this.description = description;
		this.car = car;
	}
	
	
	
	public Feature(String description) {
		this.description = description;
	}

	public Feature(String description, Car car) {
		this.description = description;
		this.car = car;
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
	
	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "Feature [id=" + id + ", description=" + description + "]";
	}
	
	
}
