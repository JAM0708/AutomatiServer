package com.automati.dataentity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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
	private Date time;
	
	@Column(name="description")
	private String description;
	
	@OneToOne
	@JoinColumn(name="person_id")
	private Person person;

	public Review(int id, int rating, Date time, String description, Person person) {
		this.id = id;
		this.rating = rating;
		this.time = time;
		this.description = description;
		this.person = person;
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
	
	
}
