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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.automati.dto.PersonDTO;

@Entity
@Table(name = "person")
public class Person {

	@Id
	@Column(name = "person_id")
	@SequenceGenerator(name = "personSeq", sequenceName = "person_Seq", allocationSize = 1)
	@GeneratedValue(generator = "personSeq", strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(name = "person_email", unique = true)
	private String email;

	@Column(name = "person_first_name")
	private String firstName;

	@Column(name = "person_last_name")
	private String lastName;

	@Column(name = "person_street")
	private String street;

	@Column(name = "person_city")
	private String city;

	@Column(name = "person_password")
	private String password;

	@OneToOne
	@JoinColumn(name = "state_id", nullable= true)
	private State state;

	@OneToOne
	@JoinColumn(name = "role_id")
	private Role role;

	//@OneToMany( mappedBy= "person", cascade = CascadeType.ALL, orphanRemoval = true)
	//private List<CreditCard> creditCard = new ArrayList<CreditCard>();
	
	@Column()
	private float balance;

	public Person() {
	}

	public Person(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public Person(int id, String email, String firstName, String lastName, String street, String city, String password,
			State state, Role role) {
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.street = street;
		this.city = city;
		this.password = password;
		this.state = state;
		this.role = role;
		//this.creditCard = creditCard;
	}
	
	public Person(PersonDTO personDTO, State state, Role role) {
		this.id = personDTO.getId();
		this.email = personDTO.getEmail();
		this.firstName = personDTO.getFirstName();
		this.lastName = personDTO.getLastName();
		this.street = personDTO.getStreet();
		this.city = personDTO.getCity();
		this.password = personDTO.getPassword();
		this.balance = personDTO.getBalance();
		this.state = state;
		this.role = role;
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

	/*
	public List<CreditCard> getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(List<CreditCard> creditCard) {
		this.creditCard = creditCard;
	}
	*/
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	
	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", street=" + street + ", city=" + city + ", password=" + password + ", state=" + state + ", role="
				+ role + ", balance=" + balance + "]";
	}
	

}
