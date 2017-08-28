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
	private Model model;
	private Color color;
	private List<Feature> feature;
	private Transmission transmission;
	private Condition condition;
	private EPA epa;
	private double price;
	private Lease lease;
	private List<Review> review;
	private Person person;
	
	public CarDTO(int id, int year, Model model, Color color, List<Feature> feature, Transmission transmission,
			Condition condition, EPA epa, double price, Lease lease, List<Review> review, Person person) {
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

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public List<Feature> getFeature() {
		return feature;
	}

	public void setFeature(List<Feature> feature) {
		this.feature = feature;
	}

	public Transmission getTransmission() {
		return transmission;
	}

	public void setTransmission(Transmission transmission) {
		this.transmission = transmission;
	}

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	public EPA getEpa() {
		return epa;
	}

	public void setEpa(EPA epa) {
		this.epa = epa;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Lease getLease() {
		return lease;
	}

	public void setLease(Lease lease) {
		this.lease = lease;
	}

	public List<Review> getReview() {
		return review;
	}

	public void setReview(List<Review> review) {
		this.review = review;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	
}
