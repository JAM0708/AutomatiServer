package com.automati.dto;

import java.io.Serializable;

public class ResetTokenDTO  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 914266734233308701L;
	
	private int tokenNum;
	private String email;
	public ResetTokenDTO() {
	}
	public int getTokenNum() {
		return tokenNum;
	}
	public void setTokenNum(int tokenNum) {
		this.tokenNum = tokenNum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}