package com.automati.dataentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="transmission")
public class Transmission {
	
	@Id
	@Column(name="transmission_id")
	@SequenceGenerator(name="transmissionSeq", sequenceName="transmission_Seq", allocationSize=1)
	@GeneratedValue(generator="transmissionSeq", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="transmission_name")
	private String name;

	public Transmission(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Transmission() {
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
