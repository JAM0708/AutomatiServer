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
@Table(name="creditcard")
public class CreditCard {
	
	@Id
	@Column(name = "card_id")
	@SequenceGenerator(name = "cardSeq", sequenceName = "card_Seq", allocationSize = 1)
	@GeneratedValue(generator = "cardSeq", strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(name = "num", nullable = false, unique = true, length=16)
	private String number;
	
	@Column(name="exp_date", nullable= false)
	@Temporal(TemporalType.DATE)
	private Date expDate;
	
	@Column(name="csc", nullable= false)
	private int csc;

	@ManyToOne()
	@JoinColumn(name="person_id")
	private Person person;
	
	public CreditCard() {
	}

	public CreditCard(int id, String number, Date expDate, int csc, Person person) {
		this.id = id;
		this.number = number;
		this.expDate = expDate;
		this.csc = csc;
		this.person = person;
	}
	
	
	public CreditCard(String number, Date expDate, int csc, Person person) {
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

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
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
