package com.automati.dataentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ResetToken")
public class ResetToken {
	
	@Id
	@Column(name="reset_token_id")
	@SequenceGenerator(name="resetTokenSeq", sequenceName="resetToken_Seq", allocationSize=1)
	@GeneratedValue(generator="resetTokenSeq", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="tokenNum")
	private int tokenNum;
	
	@Column(name = "email")
	private String email;

	public ResetToken() {
	}

	public ResetToken(int tokenNum, String email) {
		this.tokenNum = tokenNum;
		this.email = email;
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