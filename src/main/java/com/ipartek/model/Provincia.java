package com.ipartek.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="provincias")
public class Provincia {

	@Id//primary key and not null
	@GeneratedValue(strategy = GenerationType.IDENTITY)//autoincrement
	@Column(name="id")
	private int id;
	
	@Column(name="provincia")
	private String provincia;

	public Provincia(int id, String provincia) {
		super();
		this.id = id;
		this.provincia = provincia;
	}

	public Provincia() {
		super();
		this.id = 0;
		this.provincia = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	@Override
	public String toString() {
		return "Provincia [id=" + id + ", provincia=" + provincia + "]";
	}
	
	public String toCSV() {
		return id+";"+provincia;
		}
}
