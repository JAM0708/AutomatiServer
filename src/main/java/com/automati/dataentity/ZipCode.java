package com.automati.dataentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="zipcode")
public class ZipCode {
	
	@Id
	@Column(name = "zipcode_id")
	@SequenceGenerator(name = "zipCodeSeq", sequenceName = "code_Seq", allocationSize = 1)
	@GeneratedValue(generator = "zipCodeSeq", strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(name = "code", nullable = false, unique = true)
	private int code;

	public ZipCode() {
	}

	public ZipCode(int id, int code) {
		this.id = id;
		this.code = code;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	
}
