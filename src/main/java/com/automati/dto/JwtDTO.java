package com.automati.dto;

import java.io.Serializable;

public class JwtDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7366206997734150352L;
	private String jwt;
	private boolean isJWT;

	public JwtDTO(String jwt, boolean isJWT) {
		this.jwt = jwt;
		this.isJWT = isJWT;
	}

	public JwtDTO() {
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	public boolean getIsJWT() {
		return isJWT;
	}

	public void setIsJWT(boolean isJWT) {
		this.isJWT = isJWT;
	}
	
	
	

}
