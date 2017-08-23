package com.automati.dataentity;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

public class Person {

	@Id
	@Column(name="person_id")
	@SequenceGenerator(name="personSeq", sequenceName="person_Seq", allocationSize=1)
	@GeneratedValue(generator="personSeq", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="person_first_name")
	private String firstName;
	
	@Column(name="person_last_name")
	private String lastName;
	
	@Column(name="person_street")
	private String street;
	
	@Column(name="person_city")
	private String city;
	
	@Column(name="person_password")
	private String password;
	
	@OneToOne
	@JoinColumn(name="state_id")
	private State state;
	
	@OneToOne
	@JoinColumn(name="role_id")
	private Role role;
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="credit_id")
	private CreditCard creditCard;
	
	
	
	public Person() {
	}

	public Person(int id, String firstName, String lastName, String street, String city, String password, State state,
			Role role, CreditCard creditCard) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
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

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}
	
	
	
}
