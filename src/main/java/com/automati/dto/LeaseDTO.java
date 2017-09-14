package com.automati.dto;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;

public class LeaseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7529509347401132094L;
	
	private int id;
	private float monthlyPayment;
	private float interestRate;
	private int length;
	private Date startDate;
	
	
	
	public LeaseDTO() {
	}


	public LeaseDTO(float monthlyPayment, float interestRate, int length, Date startDate) {
		this.monthlyPayment = monthlyPayment;
		this.interestRate = interestRate;
		this.length = length;
		this.startDate = startDate;
	}


	public LeaseDTO(int id, float monthlyPayment, float interestRate, int length, Date startDate) {
		this.id = id;
		this.monthlyPayment = monthlyPayment;
		this.interestRate = interestRate;
		this.length = length;
		this.startDate = startDate;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public float getMonthlyPayment() {
		return monthlyPayment;
	}


	public void setMonthlyPayment(float monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}


	public float getInterestRate() {
		return interestRate;
	}


	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}


	public int getLength() {
		return length;
	}


	public void setLength(int length) {
		this.length = length;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	@Override
	public String toString() {
		return "LeaseDTO [id=" + id + ", monthlyPayment=" + monthlyPayment + ", interestRate=" + interestRate
				+ ", length=" + length + ", startDate=" + startDate + "]";
	}
	
	
	
	
	
	
	
}
