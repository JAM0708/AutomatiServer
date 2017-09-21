package com.automati.dto;

import java.io.Serializable;

public class ZipCodeDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7529509347401132094L;
	
	private int id;
	private String code;
	
	
	
	public ZipCodeDTO() {
	}

	public ZipCodeDTO(int id, String code) {
		this.id = id;
		this.code = code;
	}


	public ZipCodeDTO(String code) {
		this.code = code;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "ZipCodeDTO [id=" + id + ", code=" + code + "]";
	}
	
	
	
}
