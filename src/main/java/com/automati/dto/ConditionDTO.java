package com.automati.dto;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;

public class ConditionDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7529509347401132094L;

	private int id;
	private String type;
	private String title;
	private int mileage;

	public ConditionDTO() {
	}

	public ConditionDTO(String type, String title, int mileage) {
		this.type = type;
		this.title = title;
		this.mileage = mileage;
	}

	public ConditionDTO(int id, String type, String title, int mileage) {
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
