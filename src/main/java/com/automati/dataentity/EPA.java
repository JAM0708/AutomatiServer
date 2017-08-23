package com.automati.dataentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="epa")
public class EPA {
	
	@Id
	@Column(name="epa_id")
	@SequenceGenerator(name="epaSeq", sequenceName="epa_Seq", allocationSize=1)
	@GeneratedValue(generator="epaSeq", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="epa_mileage")
	private int mileage;

	public EPA(int id, int mileage) {
		this.id = id;
		this.mileage = mileage;
	}

	public EPA() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	
	
}
