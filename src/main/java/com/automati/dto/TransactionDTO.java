package com.automati.dto;

import java.io.Serializable;
import java.util.Date;

public class TransactionDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7260588058566184582L;
	
	private int id;
	private float amount;
	private Date transactionDate;
	private String description;
	private PersonDTO person;
	private CreditCardDTO card;
	
	
	
	public TransactionDTO(int id, float amount, Date transactionDate, String description, PersonDTO person,
			CreditCardDTO card) {
		this.id = id;
		this.amount = amount;
		this.transactionDate = transactionDate;
		this.description = description;
		this.person = person;
		this.card = card;
	}

	public TransactionDTO() {
		
	}
	public TransactionDTO(float amount, String description, PersonDTO person, CreditCardDTO card) {
		this.amount = amount;
		this.description = description;
		this.person = person;
		this.card = card;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public float getAmount() {
		return amount;
	}


	public void setAmount(float amount) {
		this.amount = amount;
	}


	public Date getTransactionDate() {
		return transactionDate;
	}


	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
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


	public CreditCardDTO getCard() {
		return card;
	}


	public void setCard(CreditCardDTO card) {
		this.card = card;
	}

	@Override
	public String toString() {
		return "TransactionDTO [id=" + id + ", amount=" + amount + ", transactionDate=" + transactionDate
				+ ", description=" + description + ", person=" + person + ", card=" + card + "]";
	}
	
}
