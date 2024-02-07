package com.ipartek.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="mascotas")
public class Mascota {
	
	@Id//primary key and not null
	@GeneratedValue(strategy = GenerationType.IDENTITY)//autoincrement
	@Column(name="id")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="edad")
	private int edad;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="foto")
	private String foto;
	
	@ManyToOne
	private Especie especie;
	
	@ManyToOne
	private Provincia provincia;

	public Mascota(int id, String nombre, int edad, String descripcion, String foto, Especie especie,
			Provincia provincia) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.descripcion = descripcion;
		this.foto = foto;
		this.especie = especie;
		this.provincia = provincia;
	}

	public Mascota() {
		super();
		this.id = 0;
		this.nombre = "";
		this.edad = 0;
		this.descripcion = "";
		this.foto = "";
		this.especie = new Especie();
		this.provincia = new Provincia();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Especie getEspecie() {
		return especie;
	}

	public void setEspecie(Especie especie) {
		this.especie = especie;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	@Override
	public String toString() {
		return "Mascota [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", descripcion=" + descripcion
				+ ", foto=" + foto + ", especie=" + especie + ", provincia=" + provincia + "]";
	}

	public String toCSV() {
		return id + ";" + nombre + ";" + edad + ";" + descripcion + ";" + foto + ";" + especie + ";" + provincia;
		}
}
