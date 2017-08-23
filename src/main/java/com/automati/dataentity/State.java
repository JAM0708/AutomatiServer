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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "zipcode_id")
	private ZipCode code;
}
