package com.automati.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShippingDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2515109535323712432L;
	
	private int id;
	private String firstName;
	private String lastName;
	private String street;
	private String city;
	private StateDTO state;
	private PersonDTO person;
	
	
	public ShippingDTO() {
		
	}
	
	public ShippingDTO(int id, String firstName, String lastName, String street, String city, StateDTO state,
			PersonDTO person) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.street = street;
		this.city = city;
		this.state = state;
		this.person = person;
	}
	
	public ShippingDTO(String firstName, String lastName, String street, String city, StateDTO state,
			PersonDTO person) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.street = street;
		this.city = city;
		this.state = state;
		this.person = person;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public StateDTO getState() {
		return state;
	}
	public void setState(StateDTO state) {
		this.state = state;
	}
	public PersonDTO getPerson() {
		return person;
	}
	public void setPerson(PersonDTO person) {
		this.person = person;
	}
	
	
}
