package com.automati.dataentity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.automati.dto.ShippingDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "shipping")
public class Shipping {
	
	@Id
	@Column(name="shipping_id")
	@SequenceGenerator(name="shippingSeq", sequenceName="shipping_Seq", allocationSize=1)
	@GeneratedValue(generator="shippingSeq", strategy=GenerationType.SEQUENCE)
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "street")
	private String street;

	@Column(name = "city")
	private String city;

	@OneToOne
	@JoinColumn(name = "state_id", nullable= true)
	private State state;
	
	@ManyToOne()
	@JoinColumn(name="person_id" , nullable = true)
	private Person person;
	
	public Shipping() {
		
	}
	
	public Shipping(String firstName, String lastName, String street, String city, State state, Person person) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.street = street;
		this.city = city;
		this.state = state;
		this.person = person;
	}

	public Shipping(int id, String firstName, String lastName, String street, String city, State state, Person person) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.street = street;
		this.city = city;
		this.state = state;
		this.person = person;
	}
	
	public Shipping(ShippingDTO shippingDTO, Person person, State state) {
		this.firstName = shippingDTO.getFirstName();
		this.lastName = shippingDTO.getLastName();
		this.street = shippingDTO.getStreet();
		this.city = shippingDTO.getCity();
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

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Shipping [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", street=" + street
				+ ", city=" + city + ", state=" + state + ", person=" + person + "]";
	}
	
}
