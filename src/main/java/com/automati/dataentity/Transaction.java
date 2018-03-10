package com.automati.dataentity;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="transaction")
public class Transaction {
	
	@Id
	@Column(name = "transaction_id")
	@SequenceGenerator(name = "transactionSeq", sequenceName = "transaction_Seq", allocationSize = 1)
	@GeneratedValue(generator = "transactionSeq", strategy = GenerationType.SEQUENCE)
	private int id;

	@Column()
	private float amount;
	
	@Column(name="transaction_date", nullable= false)
	@Temporal(TemporalType.DATE)
	private Date transactionDate;
	
	@Column()
	private String description;

	@ManyToOne()
	@JoinColumn(name="person_id")
	private Person person;
	
	@ManyToOne()
	@JoinColumn(name="card_id")
	private CreditCard creditCard;
	
	public Transaction() {
	}

	public Transaction(int id, float amount, Date transactionDate, String description, Person person,
			CreditCard creditCard) {
		this.id = id;
		this.amount = amount;
		this.transactionDate = transactionDate;
		this.description = description;
		this.person = person;
		this.creditCard = creditCard;
	}

	
	public Transaction(float amount, Date transactionDate, String description, Person person, CreditCard creditCard) {
		this.amount = amount;
		this.transactionDate = transactionDate;
		this.description = description;
		this.person = person;
		this.creditCard = creditCard;
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

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", amount=" + amount + ", transactionDate=" + transactionDate
				+ ", description=" + description + ", person=" + person + ", creditCard=" + creditCard + "]";
	}
	
}
