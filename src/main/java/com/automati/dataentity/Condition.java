package com.automati.dataentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.automati.dto.ConditionDTO;

@Entity
@Table(name="condition")
public class Condition {
	
	@Id
	@Column(name="condition_id")
	@SequenceGenerator(name="conditionSeq", sequenceName="condition_Seq", allocationSize=1)
	@GeneratedValue(generator="conditionSeq", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="condition_type")
	private String type;
	
	@Column(name = "description")
	private String description;

	public Condition() {
	}
	
	public Condition(int id, String type, String description) {
		this.id = id;
		this.type = type;
		this.description = description;
	}
	
	public Condition(ConditionDTO conditionDTO) {
		this.type = conditionDTO.getType();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
