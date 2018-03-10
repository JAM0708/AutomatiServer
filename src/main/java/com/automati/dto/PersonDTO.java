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
	private StateDTO state;
	private RoleDTO role;
	private float balance;
	private List<CreditCardDTO> creditCard = new ArrayList<CreditCardDTO>();
	
	
	public PersonDTO() {
	}
	
	

	public PersonDTO(int id, String firstName, String lastName, String email, String street, String city,
			String password, StateDTO state, RoleDTO role, List<CreditCardDTO> creditCard) {
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
	
	



	public PersonDTO(String firstName, String lastName, String email, String street, String city, String password,
			StateDTO state, RoleDTO role, List<CreditCardDTO> creditCard) {
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
	
	



	public PersonDTO(String firstName, String lastName, String email, String street, String city, String password,
			StateDTO state, RoleDTO role) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.street = street;
		this.city = city;
		this.password = password;
		this.state = state;
		this.role = role;
	}



	public PersonDTO(int id) {
		this.id = id;
	}


	public float getBalance() {
		return balance;
	}



	public void setBalance(float balance) {
		this.balance = balance;
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

	public StateDTO getState() {
		return state;
	}



	public void setState(StateDTO state) {
		this.state = state;
	}



	public RoleDTO getRole() {
		return role;
	}



	public void setRole(RoleDTO role) {
		this.role = role;
	}



	public List<CreditCardDTO> getCreditCard() {
		return creditCard;
	}



	public void setCreditCard(List<CreditCardDTO> creditCard) {
		this.creditCard = creditCard;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
