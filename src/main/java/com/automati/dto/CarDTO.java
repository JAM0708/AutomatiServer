package com.automati.dto;

import java.io.Serializable;
import java.util.List;

import com.automati.dataentity.Color;
import com.automati.dataentity.Condition;
import com.automati.dataentity.EPA;
import com.automati.dataentity.Feature;
import com.automati.dataentity.Lease;
import com.automati.dataentity.Model;
import com.automati.dataentity.Person;
import com.automati.dataentity.Review;
import com.automati.dataentity.Transmission;

public class CarDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1705468198474980763L;
	private int id;
	private int year;
	private int mileage;
	private String title;
	private ModelDTO model;
	private ColorDTO color;
	private List<Feature> feature;
	private TransmissionDTO transmission;
	private ConditionDTO condition;
	private EPADTO epa;
	private double price;
	private LeaseDTO lease;
	private List<Review> review;
	private PersonDTO person;
	
	
	
	public CarDTO() {
	}

	public CarDTO(int year, ModelDTO model, ColorDTO color, TransmissionDTO transmission, ConditionDTO condition,
			EPADTO epa, double price) {
		this.year = year;
		this.model = model;
		this.color = color;
		this.transmission = transmission;
		this.condition = condition;
		this.epa = epa;
		this.price = price;
	}

	public CarDTO(int id, int year, ModelDTO model, ColorDTO color, List<Feature> feature, TransmissionDTO transmission,
			ConditionDTO condition, EPADTO epa, double price, LeaseDTO lease, List<Review> review, PersonDTO person) {
		this.id = id;
		this.year = year;
		this.model = model;
		this.color = color;
		this.feature = feature;
		this.transmission = transmission;
		this.condition = condition;
		this.epa = epa;
		this.price = price;
		this.lease = lease;
		this.review = review;
		this.person = person;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public ModelDTO getModel() {
		return model;
	}

	public void setModel(ModelDTO model) {
		this.model = model;
	}

	public ColorDTO getColor() {
		return color;
	}

	public void setColor(ColorDTO color) {
		this.color = color;
	}

	public List<Feature> getFeature() {
		return feature;
	}

	public void setFeature(List<Feature> feature) {
		this.feature = feature;
	}

	public TransmissionDTO getTransmission() {
		return transmission;
	}

	public void setTransmission(TransmissionDTO transmission) {
		this.transmission = transmission;
	}

	public ConditionDTO getCondition() {
		return condition;
	}

	public void setCondition(ConditionDTO condition) {
		this.condition = condition;
	}

	public EPADTO getEpa() {
		return epa;
	}

	public void setEpa(EPADTO epa) {
		this.epa = epa;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LeaseDTO getLease() {
		return lease;
	}

	public void setLease(LeaseDTO lease) {
		this.lease = lease;
	}

	public List<Review> getReview() {
		return review;
	}

	public void setReview(List<Review> review) {
		this.review = review;
	}

	public PersonDTO getPerson() {
		return person;
	}

	public void setPerson(PersonDTO person) {
		this.person = person;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	
}
