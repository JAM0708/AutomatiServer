package com.automati.dataentity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="review")
public class Review {
	
	@Id
	@Column(name="review_id")
	@SequenceGenerator(name="reviewSeq", sequenceName="review_Seq", allocationSize=1)
	@GeneratedValue(generator="reviewSeq", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="review_rating")
	private int rating;
	
	@Column(name="review_time")
	@Temporal(TemporalType.DATE)
	private Date time;
	
	@Column(name="description")
	@Size(min = 1, max = 3000)
	private String description;
	
	@OneToOne
	@JoinColumn(name="person_id")
	private Person person;
	
	@Column()
	private String title;
	
	@ManyToOne
	@JoinColumn(name="carId", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Car car;
	
	@ManyToOne
	@JoinColumn(name = "modelId", nullable = false) 
	private Model model;

	
	public Review(int id, int rating, Date time, String description, Person person) {
		this.id = id;
		this.rating = rating;
		this.time = time;
		this.description = description;
		this.person = person;
	}

	public Review(String title,int rating, Date time, String description, Person person, Car car, Model model) {
		this.title = title;
		this.rating = rating;
		this.time = time;
		this.description = description;
		this.person = person;
		this.car = car;
		this.model = model;
	}



	public Review(int rating, Date time, String description, Person person, Car car) {
		this.rating = rating;
		this.time = time;
		this.description = description;
		this.person = person;
		this.car = car;
	}



	public Review(int id, int rating, Date time, String description, Person person, Car car) {
		this.id = id;
		this.rating = rating;
		this.time = time;
		this.description = description;
		this.person = person;
		this.car = car;
	}
	
	

	public Review(int rating, Date time, String description, Person person) {
		this.rating = rating;
		this.time = time;
		this.description = description;
		this.person = person;
	}
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Review() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Model getModel() {
		return model;
	}
	
	public void setModel(Model model) {
		this.model = model;
	}
	
}
