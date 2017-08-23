package com.automati.dataentity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public class Role {
	
	public Role() {
		super();
	}

	@Id
	@Column(name="role_id")
	@SequenceGenerator(name="roleSeq", sequenceName="role_Seq", allocationSize=1)
	@GeneratedValue(generator="roleSeq", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="role_name")
	private String name;

	public Role(int id, String name) {
		this.id = id;
		this.name = name;
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
