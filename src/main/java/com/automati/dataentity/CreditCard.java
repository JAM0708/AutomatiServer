package com.automati.dataentity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="creditcard")
public class CreditCard {
	
	@Id
	@Column(name = "card_id")
	@SequenceGenerator(name = "cardSeq", sequenceName = "card_Seq", allocationSize = 1)
	@GeneratedValue(generator = "cardSeq", strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(name = "number", nullable = false, unique = true)
	@Size(min=16,max=16)
	private int number;
	
	@Column(name="owner",nullable= false)
	private String owner;
	
	@Column(name="exp_date", nullable= false)
	private Date expDate;
	
	@Column(name="csc", nullable= false)
	private int csc;

	public CreditCard() {
	}

	public CreditCard(int id, int number, String owner, Date expDate, int csc) {
		this.id = id;
		this.number = number;
		this.owner = owner;
		this.expDate = expDate;
		this.csc = csc;
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

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
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
	
	
}
