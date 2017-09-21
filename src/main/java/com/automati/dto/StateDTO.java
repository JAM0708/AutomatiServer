package com.automati.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.automati.dataentity.ZipCode;

public class StateDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7529509347401132094L;
	
	private int id;
	private String name;
	private Set<ZipCodeDTO> codes = new HashSet<ZipCodeDTO>();
	
	
	
	public StateDTO() {
	}
	
	

	public StateDTO(int id, String name, Set<ZipCodeDTO> codes) {
		this.id = id;
		this.name = name;
		this.codes = codes;
	}



	public StateDTO(String name) {
		this.name = name;
	}


	public StateDTO(String name, Set<ZipCodeDTO> code) {
		this.name = name;
		this.codes = code;
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



	public Set<ZipCodeDTO> getCodes() {
		return codes;
	}



	public void setCodes(Set<ZipCodeDTO> code) {
		this.codes = code;
	}



	@Override
	public String toString() {
		return "StateDTO [id=" + id + ", name=" + name + ", code=" + codes + "]";
	}
	
	
	
	
}
