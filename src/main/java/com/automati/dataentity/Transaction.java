package com.automati.dataentity;

import java.util.Date;
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

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
	
	/*
	@ManyToOne()
	@JoinColumn(name="card_id")
	private CreditCard creditCard;
	*/
	@Column(name = "credit_card_num", nullable = false, length=16)
	private String creditCardNumber;
	
	public Transaction() {
	}
	
	public Transaction(int id, float amount, Date transactionDate, String description, Person person, String number) {
		this.id = id;
		this.amount = amount;
		this.transactionDate = transactionDate;
		this.description = description;
		this.person = person;
		this.creditCardNumber = number;
	}

	public Transaction(float amount, Date transactionDate, String description, Person person, String number) {
		this.amount = amount;
		this.transactionDate = transactionDate;
		this.description = description;
		this.person = person;
		this.creditCardNumber = number;
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

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", amount=" + amount + ", transactionDate=" + transactionDate
				+ ", description=" + description + ", person=" + person + ", creditCardNumber=" + creditCardNumber
				+ "]";
	}
}
