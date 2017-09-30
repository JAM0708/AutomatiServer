package com.automati.dto;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component(value="status-check")
public class StatusCheck implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3561396964654243417L;
	
	private boolean passed;

	public StatusCheck(boolean passed) {
		this.passed = passed;
	}

	public StatusCheck() {
	}

	public boolean isPassed() {
		return passed;
	}

	public void setPassed(boolean passed) {
		this.passed = passed;
	}
	
	public void setPassedTrue() {
		this.passed = true;
	}
	
	public void setPassedFalse() {
		this.passed = false;
	}

}
