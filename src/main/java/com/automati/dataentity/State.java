package com.automati.dataentity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="state")
public class State {
	
	@Id
	@Column(name = "state_id")
	@SequenceGenerator(name = "stateSeq", sequenceName = "state_Seq", allocationSize = 1)
	@GeneratedValue(generator = "stateSeq", strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(name = "name", nullable = false, unique = true)
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "zipcode_id")
	private Set<ZipCode> code = new HashSet<ZipCode>();

	public State() {
	}

	public State(int id, String name, Set<ZipCode> code) {
		this.id = id;
		this.name = name;
		this.code = code;
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

	public Set<ZipCode> getCode() {
		return code;
	}

	public void setCode(Set<ZipCode> code) {
		this.code = code;
	}
	
	
}
