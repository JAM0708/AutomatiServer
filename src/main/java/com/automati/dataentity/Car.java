package com.automati.dataentity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.automati.dto.CarDTO;

@Entity
@Table(name="car")
public class Car {
	
	@Id
	@Column(name="car_id")
	@SequenceGenerator(name="carSeq", sequenceName="car_Seq", allocationSize=1)
	@GeneratedValue(generator="carSeq", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="car_year")
	private int year;
	
	@Column(name="car_mileage")
	private int mileage;
	
	@Column(name="car_title")
	private String title;
	
	@OneToOne
	@JoinColumn(name = "model_id")
	private Model model;
	
	@OneToOne
	@JoinColumn(name = "color_id")
	private Color color;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy= "car", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Feature> feature;
	
	@OneToOne
	@JoinColumn(name="transmission_id")
	private Transmission transmission;
	
	@OneToOne
	@JoinColumn(name="condition_id")
	private Condition condition;
	
	@OneToOne
	@JoinColumn(name="epa_id")
	private EPA epa;
	
	@Column(name = "car_price")
	private double price;
	
	@OneToOne
	@JoinColumn(name="lease", nullable= true)
	private Lease lease;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="review_id", nullable= true)
	private List<Review> review = new ArrayList<Review>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="person_id" , nullable = true)
	private Person person;

	public Car() {
	}
	
	
	
	public Car(int year, Model model, Color color, List<Feature> feature, Transmission transmission,
			Condition condition, EPA epa, double price, Lease lease, List<Review> review, Person person) {
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
	

	public Car(int year, int mileage, String title, Model model, Color color, List<Feature> feature,
			Transmission transmission, Condition condition, EPA epa, double price) {
		this.year = year;
		this.mileage = mileage;
		this.title = title;
		this.model = model;
		this.color = color;
		this.feature = feature;
		this.transmission = transmission;
		this.condition = condition;
		this.epa = epa;
		this.price = price;
	}



	public Car(int year, int mileage, String title, Model model, Color color, Transmission transmission,
			Condition condition, EPA epa, double price) {
		this.year = year;
		this.mileage = mileage;
		this.title = title;
		this.model = model;
		this.color = color;
		this.transmission = transmission;
		this.condition = condition;
		this.epa = epa;
		this.price = price;
	}







	public Car(int id, int year, Model model, Color color, List<Feature> feature, Transmission transmission,
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
