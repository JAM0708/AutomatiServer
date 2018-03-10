package com.automati.dataentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="engine")
public class Engine {
	
	@Id
	@Column(name="engine_id")
	@SequenceGenerator(name="engineSeq", sequenceName="engine_Seq", allocationSize=1)
	@GeneratedValue(generator="engineSeq", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column()
	private int cylinders;

	@Column()
	private float litres;

	@Column(name = "stock_engine_price")
	private float stockEnginePrice;
	
	public Engine() {
		
	}
	
	public Engine(int id, int cylinders, float litres) {
		this.id = id;
		this.cylinders = cylinders;
		this.litres = litres;
	}

	public Engine(int cylinders, float litres) {
		this.cylinders = cylinders;
		this.litres = litres;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCylinders() {
		return cylinders;
	}

	public void setCylinders(int cylinders) {
		this.cylinders = cylinders;
	}

	public float getLitres() {
		return litres;
	}

	public void setLitres(float litres) {
		this.litres = litres;
	}

	public float getStockEnginePrice() {
		return stockEnginePrice;
	}

	public void setStockEnginePrice(float stockEnginePrice) {
		this.stockEnginePrice = stockEnginePrice;
	}

	@Override
	public String toString() {
		return "Engine [id=" + id + ", cylinders=" + cylinders + ", litres=" + litres + "]";
	}
	
}
