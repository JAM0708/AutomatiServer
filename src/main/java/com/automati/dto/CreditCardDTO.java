package com.automati.dto;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;

import com.automati.dataentity.Person;

public class CreditCardDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7529509347401132094L;
	
	private int id;
	private String number;
	private String expDate;
	private int csc;
	private PersonDTO owner;
	
	
	public CreditCardDTO() {
	}
	
	
	
	public CreditCardDTO(int id, String number, String expDate, int csc, PersonDTO owner) {
		this.id = id;
		this.number = number;
		this.expDate = expDate;
		this.csc = csc;
		this.owner = owner;
	}

	


	public CreditCardDTO(String number, String expDate, int csc, PersonDTO owner) {
		this.number = number;
		this.expDate = expDate;
		this.csc = csc;
		this.owner = owner;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public int getCsc() {
		return csc;
	}

	public void setCsc(int csc) {
		this.csc = csc;
	}



	public PersonDTO getOwner() {
		return owner;
	}



	public void setOwner(PersonDTO owner) {
		this.owner = owner;
	}
	
	
	
	
}
