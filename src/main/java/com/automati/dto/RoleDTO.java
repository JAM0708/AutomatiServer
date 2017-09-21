package com.automati.dto;

import java.io.Serializable;

public class RoleDTO implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 742234012595296639L;
	private int id;
	private String name;
	public RoleDTO(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public RoleDTO(String name) {
		this.name = name;
	}

	public RoleDTO() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
