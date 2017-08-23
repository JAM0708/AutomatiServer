package com.automati.dataentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="condition")
public class Condition {
	
	@Id
	@Column(name="condition_id")
	@SequenceGenerator(name="conditionSeq", sequenceName="condition_Seq", allocationSize=1)
	@GeneratedValue(generator="conditionSeq", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="condition_type")
	private String type;
	
	@Column(name="condition_title")
	private String title;
	
	@Column(name="condition_mileage")
	private int mileage;

	public Condition() {
	}
	
	public Condition(int id, String type, String title, int mileage) {
		this.id = id;
		this.type = type;
		this.title = title;
		this.mileage = mileage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	
	
}
