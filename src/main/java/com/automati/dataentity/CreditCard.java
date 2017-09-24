package com.automati.dataentity;

import java.sql.Date;

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
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="creditcard")
public class CreditCard {
	
	@Id
	@Column(name = "card_id")
	@SequenceGenerator(name = "cardSeq", sequenceName = "card_Seq", allocationSize = 1)
	@GeneratedValue(generator = "cardSeq", strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(name = "num", nullable = false, unique = true)
	@Size(min=16,max=16)
	private int number;
	
	@Column(name="exp_date", nullable= false)
	private Date expDate;
	
	@Column(name="csc", nullable= false)
	private int csc;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="person_id", nullable= true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Person person;
	
	public CreditCard() {
	}

	public CreditCard(int id, int number, Date expDate, int csc, Person person) {
		this.id = id;
		this.number = number;
		this.expDate = expDate;
		this.csc = csc;
		this.person = person;
	}
	
	
	public CreditCard(int number, Date expDate, int csc, Person person) {
		this.number = number;
		this.expDate = expDate;
		this.csc = csc;
		this.person = person;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public int getCsc() {
		return csc;
	}

	public void setCsc(int csc) {
		this.csc = csc;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	
	
}
