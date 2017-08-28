package com.automati.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.automati.dataentity.CreditCard;
import com.automati.dataentity.Role;
import com.automati.dataentity.State;

public class PersonDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -576849559819299160L;
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String street;
	private String city;
	private String password;
	private State state;
	private Role role;
	private List<CreditCard> creditCard = new ArrayList<CreditCard>();
	
	
	public PersonDTO() {
	}
	
	

	public PersonDTO(int id) {
		this.id = id;
	}


	public PersonDTO(int id, String firstName, String lastName, String email, String street, String city,
			String password, State state, Role role, List<CreditCard> creditCard) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.street = street;
		this.city = city;
		this.password = password;
		this.state = state;
		this.role = role;
		this.creditCard = creditCard;
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



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public State getState() {
		return state;
	}



	public void setState(State state) {
		this.state = state;
	}



	public Role getRole() {
		return role;
	}



	public void setRole(Role role) {
		this.role = role;
	}



	public List<CreditCard> getCreditCard() {
		return creditCard;
	}



	public void setCreditCard(List<CreditCard> creditCard) {
		this.creditCard = creditCard;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
