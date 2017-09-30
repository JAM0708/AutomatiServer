package com.automati.dataentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="zipcode")
public class ZipCode {
	
	@Id
	@Column(name = "zipcode_id")
	@SequenceGenerator(name = "zipCodeSeq", sequenceName = "code_Seq", allocationSize = 1)
	@GeneratedValue(generator = "zipCodeSeq", strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(name = "code", nullable = false, unique = true)
	private String code;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="stateId")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private State state;
	
	public ZipCode() {
	}

	public ZipCode(int id, String code) {
		this.id = id;
		this.code = code;
	}
	
	
	public ZipCode(String code) {
		this.code = code;
	}

	public ZipCode(String code, State state) {
		this.code = code;
		this.state = state;
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

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	
}
