package com.ipartek.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="especies")
public class Especie {

	@Id//primary key and not null
	@GeneratedValue(strategy = GenerationType.IDENTITY)//autoincrement
	@Column(name="id")
	private int id;
	
	@Column(name="especie")
	private String especie;
	
	

	public Especie(int id, String especie) {
		super();
		this.id = id;
		this.especie = especie;
	}

	public Especie() {
		super();
		this.id = 0;
		this.especie = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	@Override
	public String toString() {
		return "Especie [id=" + id + ", especie=" + especie + "]";
	}
	

	public String toCSV() {
		return id+";"+especie;
		}
}





