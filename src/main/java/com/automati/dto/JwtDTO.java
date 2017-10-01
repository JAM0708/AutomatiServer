package com.automati.dto;

import java.io.Serializable;

public class JwtDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7366206997734150352L;
	private String jwt;

	public JwtDTO(String jwt) {
		this.jwt = jwt;
	}

	public JwtDTO() {
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	
	

}
