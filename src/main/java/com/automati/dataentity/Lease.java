package com.automati.dataentity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.automati.dto.LeaseDTO;

@Entity
@Table(name="lease")
public class Lease {
	
	@Id
	@Column(name="lease_id")
	@SequenceGenerator(name="leaseSeq", sequenceName="lease_Seq", allocationSize=1)
	@GeneratedValue(generator="leaseSeq", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="lease_monthly_payment")
	private float monthlyPayment;
	
	@Column(name="interest_rate")
	private float interestRate;
	
	@Column(name="length")
	private int length;
	
	@Column(name="startdate")
	private Date startDate;
	
	public Lease() {
	}
	
	public Lease(int id, float monthlyPayment, float interestRate, int length, Date startDate) {
		this.id = id;
		this.monthlyPayment = monthlyPayment;
		this.interestRate = interestRate;
		this.length = length;
		this.startDate = startDate;
	}
	
	public Lease(LeaseDTO leaseDTO){
		this.monthlyPayment = leaseDTO.getMonthlyPayment();
		this.interestRate = leaseDTO.getInterestRate();
		this.length = leaseDTO.getLength();
		this.startDate = leaseDTO.getStartDate();
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
	
	
	
}
