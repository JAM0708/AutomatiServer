package com.automati.dto;

import java.io.Serializable;
import java.sql.Date;
import com.automati.dataentity.Car;
import com.automati.dataentity.Person;

public class ReviewDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4451576155347850798L;

	private int id;
	private int rating;
	private String time;
	private String description;
	private PersonDTO person;
	private CarDTO car

	;

	public ReviewDTO(int id, int rating, String time, String description, PersonDTO person, CarDTO car) {
		this.id = id;
		this.rating = rating;
		this.time = time;
		this.description = description;
		this.person = person;
		this.car = car;
	}

	public ReviewDTO() {
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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public PersonDTO getPerson() {
		return person;
	}

	public void setPerson(PersonDTO person) {
		this.person = person;
	}

	public CarDTO getCar() {
		return car;
	}

	public void setCar(CarDTO car) {
		this.car = car;
	}

}
