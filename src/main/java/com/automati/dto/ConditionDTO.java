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
	

	public ConditionDTO() {
	}
	
	

	public ConditionDTO(String type) {
		this.type = type;
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



}
